package com.currency.exchange.currencyexchange.controller;

import com.currency.exchange.currencyexchange.bean.CurrencyExchange;
import com.currency.exchange.currencyexchange.repo.CurrencyExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeRestController {

    @Autowired
    CurrencyExchangeRepo currencyExchangeRepo;

    @GetMapping("/{from}/to/{to}")
    public CurrencyExchange getExchnageRate(@PathVariable("from") String from, @PathVariable("to") String to ){

        CurrencyExchange currencyExchange =  currencyExchangeRepo.findByFromAndTo(from,to);
        return currencyExchange;
    }

    @GetMapping
    public List<CurrencyExchange> getAllExchnageRate(){
        List<CurrencyExchange> currencyExchangeLst =  currencyExchangeRepo.findAll();
        return currencyExchangeLst;
    }
}