package miu.sa.bankAccountTransaction.service;

import miu.sa.bankAccountTransaction.model.BankAccount;


import java.util.List;

public interface BankAccountService {
    public BankAccount saveAccount(BankAccount bankAccount);
    public List<BankAccount> getAccounts();
    public BankAccount getAccountById(Integer id);
    public void deleteAccount(Integer id);



}
