package miu.sa.customer.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import miu.sa.customer.dto.*;
import miu.sa.customer.model.*;
import miu.sa.customer.repo.AddressRepository;
import miu.sa.customer.repo.CustomerRepository;
import miu.sa.customer.repo.PaymentMethodRepository;
import miu.sa.customer.service.CustomUserDetailsService;
import miu.sa.customer.util.JwtUtil;
import miu.sa.customer.util.ServicesEndpoint;
import miu.sa.customer.util.ServicesURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CustomUserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Autowired
    ObjectMapper objectMapper;

    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        if(userDetails != null){
            final String jwt = jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        }else {
            return ResponseEntity.ok("No User found with the specified credentials");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody Customer customer) {
        if(customerRepository.findUserByEmail(customer.getEmail()) != null) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
    }

     @PostMapping("/placeOrder")
     public ResponseEntity<?> placeOrder(@RequestBody OrderRequest request){
         if(request.getPaymentMethodData() == null){
             PaymentMethod method = paymentMethodRepository.getDefault(request.getCustomerId());
             request.setPaymentMethodData(method);
         }
         if(request.getShippingAddress() == null){
             Address address = addressRepository.getDefaultAddress(request.getCustomerId());
             request.setShippingAddress(address);
         }
         return restTemplate.postForEntity(ServicesURL.ORDER_SERVICE_URL + ServicesEndpoint.PLACE_ORDER_END_POINT,
                 request, ApiResponse.class);
     }

    @PostMapping("/addPaymentMethod/{userId}")
    public ResponseEntity<?> addPaymentMethod(@Valid @RequestBody PaymentMethod paymentMethod, @PathVariable int userId) throws JsonProcessingException {
        Optional<Customer> o = customerRepository.findById(userId);
        if (o.isPresent()){
            Customer customer = o.get();
            customer.addPaymentMethod(paymentMethod);
            return ResponseEntity.ok(new ApiResponse(true, "User payment method added successfully"));
        }else {
            return ResponseEntity.ok(new ApiResponse(false, "No user found"));
        }

    }
}
