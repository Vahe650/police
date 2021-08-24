package com.test.police.service.impl;

import com.test.police.service.CarNumberService;
import com.test.police.util.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CarNumberServiceImpl implements CarNumberService {



    private static String countryCode;


    @Override
    public String getNextNumber() {
        return RandomNumberGenerator.generateNext(countryCode);
    }

    @Override
    public String getRandomNumber() {
        return RandomNumberGenerator.generateRandom(countryCode);
    }


    @Value("${app.countryCode}")
    public void setCountryCode(String countryCode) {
        CarNumberServiceImpl.countryCode = countryCode;
    }
}
