package miu.sa.customer.repo;

import miu.sa.customer.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query(value = "SELECT * FROM address WHERE customer_id = :customerId AND default_address = true", nativeQuery = true)
    Address getDefaultAddress(@Param("customerId") int customerId);
}
