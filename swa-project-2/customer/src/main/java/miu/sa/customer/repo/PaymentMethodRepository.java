package miu.sa.customer.repo;

import miu.sa.customer.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {
    @Query(value = "SELECT *, 0 as clazz_ FROM payment_method WHERE customer_id = :customerId AND default_payment_method = true", nativeQuery = true)
    PaymentMethod getDefaultPaymentMethod(@Param("customerId") int customerId);

    @Query(value = "SELECT * FROM payment_method WHERE customer_id = :customer_id AND default_payment_method = true", nativeQuery = true)
    PaymentMethod getDefault(@Param("customer_id") int customerId);
}
