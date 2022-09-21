package miu.sa.bankAccountTransaction.repository;

import miu.sa.bankAccountTransaction.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,Integer> {
}
