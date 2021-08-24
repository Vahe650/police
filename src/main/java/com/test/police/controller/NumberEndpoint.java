package com.test.police.controller;

import com.test.police.service.CarNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/number")
public class NumberEndpoint {

    private final CarNumberService carNumberService;

    @GetMapping("/random")
    public String getRandomNumber() {
        return carNumberService.getRandomNumber();
    }


    @GetMapping("/next")
    public String getNextNumber() {
        return carNumberService.getNextNumber();
    }
}
