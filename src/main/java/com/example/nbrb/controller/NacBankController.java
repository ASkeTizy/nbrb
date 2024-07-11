package com.example.nbrb.controller;

import com.example.nbrb.entity.Currency;
import com.example.nbrb.services.ApiDataSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class NacBankController {
    @Autowired
    ApiDataSaveService apiDataSaveService;
    @GetMapping("/nbrb/{id}/{date}")
    public String getCurrencyByIdAndDate(String id, Date date ) {

        return apiDataSaveService.updateCurrencyFromApi(date, id).toString();
    }

    @GetMapping("/nbrb/{date}")
    public String getCurrencyByDate(@PathVariable String date ) {

         var currencies = apiDataSaveService.saveDataFromApi(date);
        StringBuilder stringBuilder = new StringBuilder();
         for(var currency: currencies) {
             stringBuilder.append(currency.toString()).append("\n");
         }
         return stringBuilder.toString();
    }
}
