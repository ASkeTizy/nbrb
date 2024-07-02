package com.example.nbrb.services;

import com.example.nbrb.entity.Currency;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class NacBankService {
    public static final String dateCurrUrl = "https://api.nbrb.by/exrates/rates/{currID}?ondate={ondate}";
    public static final String dateUrl = "https://api.nbrb.by/exrates/rates?ondate={ondate}&periodicity=0";
    public String getDataFromNbrbApi() {
        RestTemplate restTemplate = new RestTemplate();
        Currency result = restTemplate.getForObject(dateUrl,  Currency.class);
        if(result != null) return "Ok";

        return "Exception";
    }

}
