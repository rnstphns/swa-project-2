package miu.sa.payment.service;

import miu.sa.payment.model.Payment;

import java.util.List;

public interface PaymentService {
    public List<Payment> getPayments();
    public Payment getPaymentById(Integer id);
    public Payment savePayment(Payment payment);
    public Payment updatePayment(Payment payment,Integer id);
    public void deletePayment(Integer id);





}
