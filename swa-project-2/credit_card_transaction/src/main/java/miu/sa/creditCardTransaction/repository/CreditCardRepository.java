package miu.sa.creditCardTransaction.repository;

import miu.sa.creditCardTransaction.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,Integer> {
}
