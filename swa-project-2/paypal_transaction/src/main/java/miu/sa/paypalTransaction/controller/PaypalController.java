package miu.sa.paypalTransaction.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import miu.sa.paypalTransaction.dto.ApiResponse;
import miu.sa.paypalTransaction.dto.TransactionRequest;
import miu.sa.paypalTransaction.model.Paypal;
import miu.sa.paypalTransaction.service.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PaypalController {
    @Autowired
    private PaypalService paypalService;

    // @PostMapping
    // public Paypal savePaypal(@RequestBody Paypal paypal) {
    //     return paypalService.savePaypal(paypal);
    // }

    // @GetMapping
    // public List<Paypal> getPaypals() {
    //     return paypalService.getPaypals();
    // }

    // @GetMapping("/{id}")
    // public Paypal getPaypalById(@PathVariable Integer id) {
    //     return paypalService.getPaypalById(id);
    // }

    // @DeleteMapping("/{id}")
    // public void deletePaypal(@PathVariable Integer id) {
    //     paypalService.deletePaypal(id);

    // }
    @PostMapping("/pay")
    public ResponseEntity<?> pay(@Valid @RequestBody TransactionRequest request) throws JsonProcessingException {
        return ResponseEntity.ok(new ApiResponse(true, "Transaction approved, paymentId = " + request.getPaymentId()));
    }





}
