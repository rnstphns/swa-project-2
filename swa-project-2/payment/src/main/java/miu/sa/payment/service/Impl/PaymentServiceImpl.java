package miu.sa.payment.service.Impl;

import miu.sa.payment.model.Payment;
import miu.sa.payment.repository.PaymentRepository;
import miu.sa.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentRepository.getById(id);
    }

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Payment payment, Integer id) {
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(Integer id) {
        paymentRepository.deleteById(id);

    }
}
