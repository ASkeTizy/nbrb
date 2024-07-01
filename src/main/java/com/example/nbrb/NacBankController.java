package com.example.nbrb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@RestController
public class NacBankController {
    public static final String url = "https://api.nbrb.by/exrates/currencies/456";
    @GetMapping("/nbrb")
    public String index() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);

        return result;
    }
}
