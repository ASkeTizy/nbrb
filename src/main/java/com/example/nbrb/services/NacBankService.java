package com.example.nbrb.services;

import com.example.nbrb.entity.Currency;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class NacBankService {

    private final RestTemplate restTemplate = new RestTemplate();
    public static final String DATE_ID_URL = "https://api.nbrb.by/exrates/rates/{currID}?ondate={ondate}";
    public static final String DATE_URL = "https://api.nbrb.by/exrates/rates?ondate={ondate}&periodicity=0";

    public Currency getCurrencyByIdDateFromApi(String id, Date date ) {

        Map<String,String> params = new HashMap<>(Collections.singletonMap("currId", id));
        params.put("ondate", String.valueOf(date));
        Currency result = restTemplate.getForObject(DATE_ID_URL,  Currency.class, params);
         return result;

    }
    public List<Currency> getCurrencyDataByDate(String date) {
        Map<String,String> params = new HashMap<>(Collections.singletonMap("ondate", String.valueOf(date)));
            var result = restTemplate.getForObject(DATE_URL,Currency[].class, params);
        List<Currency> list = null;
        if (result != null) {
            list = List.of(result);
        }

        return list;
    }

}
