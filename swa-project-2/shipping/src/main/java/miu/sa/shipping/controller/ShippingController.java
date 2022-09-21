package miu.sa.shipping.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import miu.sa.shipping.dto.ApiResponse;
import miu.sa.shipping.model.Item;
import miu.sa.shipping.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import miu.sa.shipping.dto.ShippingRequest;
import miu.sa.shipping.model.Shipment;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ShippingController {
    @Autowired
    private ShippingRepository shippingRepository;

    @PostMapping("/shipOrder")
    public ResponseEntity<?> shipOrder(@Valid @RequestBody ShippingRequest request) throws JsonProcessingException {
        Shipment shipment = new Shipment();
        shipment.setOrderId(request.getOrderId());
        List<Item> items = request.getItems().stream().map(i -> {
            Item item = new Item();
            item.setQuantity(i.getStock());
            item.setProductId(i.getId());
            return item;
        }).toList();
        shipment.setItems(items);
        shipment.setStatus("Shipped");
        shipment.setTrackingNumber("1012457879865323154");
        shippingRepository.save(shipment);
        return ResponseEntity.ok(new ApiResponse(true, shipment.getTrackingNumber()));
    }
}
