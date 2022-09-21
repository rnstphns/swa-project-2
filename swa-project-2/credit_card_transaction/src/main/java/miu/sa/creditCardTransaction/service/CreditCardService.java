package miu.sa.creditCardTransaction.service;

import miu.sa.creditCardTransaction.model.CreditCard;

import java.util.List;

public interface CreditCardService {
    public CreditCard saveCard(CreditCard creditCard);
    public List<CreditCard> getCards();
    public CreditCard getCardById(Integer id);
    public void deleteCard(Integer id);



}
