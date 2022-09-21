package miu.sa.paypalTransaction.repository;

import miu.sa.paypalTransaction.model.Paypal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaypalRepository extends JpaRepository<Paypal,Integer> {
}
