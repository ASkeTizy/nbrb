package com.example.nbrb.services;

import com.example.nbrb.entity.Currency;
import com.example.nbrb.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class CurrencyServiceImplementation implements CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public Currency saveCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public List<Currency> fetchCurrencyList() {
        return (List<Currency>) currencyRepository.findAll();
    }

    @Override
    public Currency updateCurrency(Currency currency, Integer currencyId) {
        Currency currencyDb = currencyRepository.findById(Long.valueOf(currencyId)).get();
        currencyDb.setDate(currency.getDate());
        currencyDb.setCurScale(currency.getCurScale());
        currencyDb.setCurName(currency.getCurName());
        currencyDb.setCurOficialRate(currency.getCurOficialRate());
        currencyDb.setCurAbbrevation(currency.getCurAbbrevation());
        return currencyRepository.save(currencyDb);
    }
}
