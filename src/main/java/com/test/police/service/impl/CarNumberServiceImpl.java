package com.test.police.service.impl;

import com.test.police.service.CarNumberService;
import com.test.police.util.RandomNumberGenerator;
import org.springframework.stereotype.Service;

@Service
public class CarNumberServiceImpl implements CarNumberService {


    @Override
    public String getNextNumber() {
        return RandomNumberGenerator.generateNext();
    }

    @Override
    public String getRandomNumber() {
        return RandomNumberGenerator.generateRandom();
    }


}
