package miu.sa.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import miu.sa.shipping.model.Shipment;

@Repository
public interface ShippingRepository extends JpaRepository<Shipment,Integer> {
}
