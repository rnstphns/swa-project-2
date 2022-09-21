package miu.sa.bankAccountTransaction.service.Impl;

import miu.sa.bankAccountTransaction.model.BankAccount;
import miu.sa.bankAccountTransaction.repository.BankAccountRepository;
import miu.sa.bankAccountTransaction.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;


    @Override
    public BankAccount saveAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public List<BankAccount> getAccounts() {
        return bankAccountRepository.findAll();
    }

    @Override
    public BankAccount getAccountById(Integer id) {
        return bankAccountRepository.getById(id);
    }

    @Override
    public void deleteAccount(Integer id) {
        bankAccountRepository.deleteById(id);

    }
}
