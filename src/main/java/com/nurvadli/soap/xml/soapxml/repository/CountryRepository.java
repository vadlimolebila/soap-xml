package com.nurvadli.soap.xml.soapxml.repository;

import com.nurvadli.soap_xml.producing_web_service.Country;
import com.nurvadli.soap_xml.producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nurvadli
 */
@Component
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData(){

        Country indonesia = new Country();
        indonesia.setName("Indonesia");
        indonesia.setCapital("Jakarta");
        indonesia.setCurrency(Currency.EUR);
        indonesia.setPopulation(839848484);
        countries.put(indonesia.getName(), indonesia);

        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(10101010);
        countries.put(spain.getName(), spain);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(322847473);
        countries.put(poland.getName(), poland);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(239494848);
        countries.put(uk.getName(), uk);
    }

    public Country findCountry(String name){
        Assert.notNull(name, "The country's name must not be null");
        return countries.get(name);
    }
}
