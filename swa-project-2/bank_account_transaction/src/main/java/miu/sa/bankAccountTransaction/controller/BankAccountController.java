package miu.sa.bankAccountTransaction.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import miu.sa.bankAccountTransaction.dto.ApiResponse;
import miu.sa.bankAccountTransaction.dto.TransactionRequest;
import miu.sa.bankAccountTransaction.model.BankAccount;
import miu.sa.bankAccountTransaction.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    // @PostMapping
    // public BankAccount saveBankAccount(@RequestBody BankAccount bankAccount) {
    //     return bankAccountService.saveAccount(bankAccount);
    // }

    // @GetMapping
    // public List<BankAccount> getAccounts() {
    //     return bankAccountService.getAccounts();
    // }

    // @GetMapping("/{id}")
    // public BankAccount getAccountById(@PathVariable Integer id) {
    //     return bankAccountService.getAccountById(id);
    // }

    // @DeleteMapping("/{id}")
    // public void deleteCard(@PathVariable Integer id) {
    //     bankAccountService.deleteAccount(id);

    // }
    @PostMapping("/pay")
    public ResponseEntity<?> pay(@Valid @RequestBody TransactionRequest request) throws JsonProcessingException {
        return ResponseEntity.ok(new ApiResponse(true, "Transaction approved, paymentId = " + request.getPaymentId()));
    }




}
