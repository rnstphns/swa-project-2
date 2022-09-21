package miu.sa.paypalTransaction.service;


import miu.sa.paypalTransaction.model.Paypal;

import java.util.List;

public interface PaypalService {
    public Paypal savePaypal(Paypal paypal);
    public List<Paypal> getPaypals();
    public Paypal getPaypalById(Integer id);
    public void deletePaypal(Integer id);



}
