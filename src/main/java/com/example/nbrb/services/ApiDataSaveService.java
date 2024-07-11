package com.example.nbrb.services;

import com.example.nbrb.entity.Currency;
import com.example.nbrb.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ApiDataSaveService {
    @Autowired NacBankService nacBankService;

    @Autowired CurrencyServiceImplementation currencyServiceImplementation;
    public List<Currency> saveDataFromApi(String dateString){
        try {
            var currencies = nacBankService.getCurrencyDataByDate(dateString);
            for(var currency : currencies) {
                currencyServiceImplementation.saveCurrency(currency);
            }
            return currencies;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Currency updateCurrencyFromApi(Date date, String id) {
        try {

            Currency currency = nacBankService.getCurrencyByIdDateFromApi(id,date);
            currencyServiceImplementation.updateCurrency(currency, Integer.valueOf(id));
            return currency;
        } catch (RuntimeException e) {
            e.getMessage();
        }
        return null;
    }
}
