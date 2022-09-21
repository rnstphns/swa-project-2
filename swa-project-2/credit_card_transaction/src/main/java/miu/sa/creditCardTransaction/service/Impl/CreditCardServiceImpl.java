package miu.sa.creditCardTransaction.service.Impl;

import miu.sa.creditCardTransaction.model.CreditCard;
import miu.sa.creditCardTransaction.repository.CreditCardRepository;
import miu.sa.creditCardTransaction.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreditCardServiceImpl implements CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    @Override
    public CreditCard saveCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    public List<CreditCard> getCards() {
        return creditCardRepository.findAll();
    }

    @Override
    public CreditCard getCardById(Integer id) {
        return creditCardRepository.getById(id);
    }

    @Override
    public void deleteCard(Integer id) {
        creditCardRepository.deleteById(id);

    }
}
