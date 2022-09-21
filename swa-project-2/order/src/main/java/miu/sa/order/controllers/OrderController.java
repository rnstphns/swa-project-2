package miu.sa.order.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import miu.sa.order.dto.*;
import miu.sa.order.model.*;
import miu.sa.order.repository.OrderRepository;
import miu.sa.order.util.ServicesEndpoint;
import miu.sa.order.util.ServicesURL;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ObjectMapper objectMapper;

    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/placeOrder")
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest request) throws JsonProcessingException {
        //call the product service
        List<Item> items = request.getOrderLines().stream().map(ol -> new Item(ol.getProductId(), ol.getQuantity())).toList();
        ResponseEntity<ApiResponse> response = restTemplate.postForEntity(ServicesURL.PRODUCT_SERVICE_URL + ServicesEndpoint.CHECK_PRODUCT_END_POINT,
                new ProductCheckRequest(items), ApiResponse.class);
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null && response.getBody().getSuccess()){
            Order order = new Order();
            order.setOrderLines(request.getOrderLines());
            order.setCustomerId(request.getCustomerId());
            order.setStatus("Pending");
            ShippingAddress address = new ShippingAddress(request.getShippingAddress());
            order.setAddress(address);
            double totalAmount = request.getOrderLines().stream().map(ol -> ol.getPrice() * ol.getQuantity())
                    .reduce(0.0, Double::sum);
            order.setTotalAmount(totalAmount);
            PaymentMethod method = new PaymentMethod(request.getPaymentMethodData());
            order.setPaymentMethod(method);
            orderRepository.save(order);
            //Call the payment service
            PaymentRequest paymentRequest = new PaymentRequest(order.getId(), totalAmount, method.getType());
            ResponseEntity<ApiResponse> paymentResponse = restTemplate.postForEntity(ServicesURL.PAYMENT_SERVICE_URL + ServicesEndpoint.MAKE_PAYMENT_END_POINT,
                    paymentRequest, ApiResponse.class);
            if (paymentResponse.getStatusCode() == HttpStatus.OK &&
                    paymentResponse.getBody() != null &&
                    paymentResponse.getBody().getSuccess()){
                order.setStatus("Confirmed");
                orderRepository.save(order);
                //call the shipping service
                ResponseEntity<ApiResponse> shippingResponse = restTemplate.postForEntity(
                        ServicesURL.SHIPPING_SERVICE_URL + ServicesEndpoint.SHIP_ORDER_END_POINT,
                        new ShippingRequest(order.getId(), items), ApiResponse.class);
                if (shippingResponse.getStatusCode() == HttpStatus.OK
                        && shippingResponse.getBody() != null
                        && shippingResponse.getBody().getSuccess()){
                    return ResponseEntity.ok(new ApiResponse(true,
                            "Payment fulfilled, Order saved and shipped with tracking number : " +shippingResponse.getBody().getMessage() ));
                }else {
                    return ResponseEntity.ok(new ApiResponse(true,"Payment fulfilled, Order saved and waiting to be shipped"));
                }
            }else {
                order.setStatus("Canceled");
                orderRepository.save(order);
                return ResponseEntity.ok(new ApiResponse(false, "Order is not fulfilled because the payment is not approved"));
            }
        }else {
            return ResponseEntity.ok(new ApiResponse(false, response.getBody().getMessage()));
        }
    }
}
