package miu.sa.payment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import miu.sa.payment.dto.ApiResponse;
import miu.sa.payment.dto.OrderRequest;
import miu.sa.payment.dto.TransactionRequest;
import miu.sa.payment.model.Payment;
import miu.sa.payment.service.PaymentService;
import miu.sa.payment.util.ServicesEndpoint;
import miu.sa.payment.util.ServicesURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/makepayment")
    public ResponseEntity<?> makepayment(@Valid @RequestBody OrderRequest request) throws JsonProcessingException {
        Payment payment=new Payment();
        payment.setOrderId(request.getOrderId());
        payment.setAmount(request.getAmount());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setStatus("Not Paid");
        paymentService.savePayment(payment);

        TransactionRequest transactionRequest = new TransactionRequest(payment.getId());
        String serviceUrl = "";
        switch (request.getPaymentMethod()) {
            case "Credit Card" -> serviceUrl = ServicesURL.CREDIT_CARD_SERVICE_URL + ServicesEndpoint.PAY_CREDIT_CARD_END_POINT;
            case "PayPal" -> serviceUrl = ServicesURL.PAYPAL_SERVICE_URL + ServicesEndpoint.PAY_PAYPAL_CARD_END_POINT;
            case "Bank Account" -> serviceUrl = ServicesURL.BANK_ACCOUNT_SERVICE_URL + ServicesEndpoint.PAY_BANK_ACCOUNT_END_POINT;
        }
        ResponseEntity<ApiResponse> paymentResponse = restTemplate.postForEntity(serviceUrl, transactionRequest, ApiResponse.class);
        if (paymentResponse.getStatusCode() == HttpStatus.OK &&
                paymentResponse.getBody() != null && paymentResponse.getBody().getSuccess()){
            payment.setStatus("Paid");
            paymentService.savePayment(payment);
            return ResponseEntity.ok(new ApiResponse(true, "Payment is fulfilled"));
        }else {
            return ResponseEntity.ok(new ApiResponse(false, "Payment was not fulfilled"));
        }
    }
}
