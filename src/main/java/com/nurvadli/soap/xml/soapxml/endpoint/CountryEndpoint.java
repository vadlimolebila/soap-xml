package com.nurvadli.soap.xml.soapxml.endpoint;

import com.nurvadli.soap.xml.soapxml.repository.CountryRepository;
import com.nurvadli.soap_xml.producing_web_service.GetCountryRequest;
import com.nurvadli.soap_xml.producing_web_service.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author Nurvadli
 */
@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://nurvadli.com/soap-xml/producing-web-service";

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint (CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request){
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));
        return response;
    }

}
