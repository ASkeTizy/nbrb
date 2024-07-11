package com.example.nbrb.services;

import com.example.nbrb.entity.Currency;

import java.util.List;

public interface CurrencyService {
    Currency saveCurrency(Currency currency);
    List<Currency> fetchCurrencyList();
    Currency updateCurrency(Currency currency,Integer currencyId);
}
