package miu.sa.creditCardTransaction.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import miu.sa.creditCardTransaction.dto.ApiResponse;
import miu.sa.creditCardTransaction.dto.TransactionRequest;
import miu.sa.creditCardTransaction.model.CreditCard;
import miu.sa.creditCardTransaction.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CreditcardController {
    @Autowired
    private CreditCardService creditCardService;

    // @PostMapping
    // public CreditCard saveCard(@RequestBody CreditCard creditCard) {
    //     return creditCardService.saveCard(creditCard);
    // }

    // @GetMapping
    // public List<CreditCard> getCards() {
    //     return creditCardService.getCards();
    // }

    // @GetMapping("/{id}")
    // public CreditCard getCardById(@PathVariable Integer id) {
    //     return creditCardService.getCardById(id);
    // }

    // @DeleteMapping("/{id}")
    // public void deleteCard(@PathVariable Integer id) {
    //     creditCardService.deleteCard(id);

    // }
    @PostMapping("/pay")
    public ResponseEntity<?> pay(@Valid @RequestBody TransactionRequest request) throws JsonProcessingException {
        return ResponseEntity.ok(new ApiResponse(true, "Transaction approved, paymentId = " + request.getPaymentId()));
    }




}
