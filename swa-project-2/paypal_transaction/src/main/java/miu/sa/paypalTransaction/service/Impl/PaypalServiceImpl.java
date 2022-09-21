package miu.sa.paypalTransaction.service.Impl;

import miu.sa.paypalTransaction.model.Paypal;
import miu.sa.paypalTransaction.repository.PaypalRepository;
import miu.sa.paypalTransaction.service.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaypalServiceImpl implements PaypalService {
    @Autowired
    private PaypalRepository paypalRepository;


    @Override
    public Paypal savePaypal(Paypal paypal) {
        return paypalRepository.save(paypal);
    }

    @Override
    public List<Paypal> getPaypals() {
        return paypalRepository.findAll();
    }

    @Override
    public Paypal getPaypalById(Integer id) {
        return paypalRepository.getById(id);
    }

    @Override
    public void deletePaypal(Integer id) {
        paypalRepository.deleteById(id);

    }
}
