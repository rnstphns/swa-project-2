package miu.sa.customer.repo;


import miu.sa.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAll();

    Customer findByEmail(String email);

    Customer findUserByEmail(String email);
}
