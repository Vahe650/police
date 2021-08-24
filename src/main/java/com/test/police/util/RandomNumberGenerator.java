package com.test.police.util;

import com.test.police.enums.Letter;
import com.test.police.dto.ResponseDto;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static com.test.police.enums.Letter.randomLetter;

public class RandomNumberGenerator {
    private static Set<ResponseDto> cashedResponse = new HashSet<>();
    private static ResponseDto currentResponse;
    private static final int LAST_NUMBER = 2;


    public static String generateRandom(String countryCode) {
        if (isFreeNumber()) {
            Random random = new Random();
            Letter firstSymbol = randomLetter();
            Letter secondSymbol = randomLetter();
            Letter thirdSymbol = randomLetter();
            int nextNumber = random.nextInt(LAST_NUMBER);
            ResponseDto responseDto = new ResponseDto(nextNumber, firstSymbol, secondSymbol, thirdSymbol);
            currentResponse = responseDto;
            if (!cashedResponse.contains(responseDto)) {
                cashedResponse.add(responseDto);
                return createResponse(responseDto, countryCode);
            }
        }
        return generateNext(countryCode);
    }


    public static String intToString(int num) {
        return String.format("%03d", num);
    }

    public static String generateNext(String countryCode) {
        if (isFreeNumber()) {
            Letter firstSymbol = Letter.A;
            Letter secondSymbol = Letter.A;
            Letter thirdSymbol = Letter.A;
            int nextNumber = 0;
            if (currentResponse != null) {
                firstSymbol = currentResponse.getFirstSymbol();
                secondSymbol = currentResponse.getSecondSymbol();
                thirdSymbol = currentResponse.getThirdSymbol();
                nextNumber = currentResponse.getNum();
                if (currentResponse.getNum() == LAST_NUMBER) {
                    nextNumber = 0;
                    if (Letter.isLastLetter(firstSymbol)) {
                        firstSymbol = Letter.getByCode(1);
                        if (Letter.isLastLetter(secondSymbol)) {
                            secondSymbol = Letter.getByCode(1);
                            if (Letter.isLastLetter(thirdSymbol)) {
                                thirdSymbol = Letter.getByCode(1);
                            } else {
                                thirdSymbol = Letter.getByCode(thirdSymbol.getCode() + 1);
                            }
                        } else {
                            secondSymbol = Letter.getByCode(secondSymbol.getCode() + 1);
                        }
                    } else {
                        firstSymbol = Letter.getByCode(firstSymbol.getCode() + 1);
                    }
                } else nextNumber++;
            }
            ResponseDto responseDto = new ResponseDto(nextNumber, firstSymbol, secondSymbol, thirdSymbol);
            currentResponse = responseDto;
            if (!cashedResponse.contains(responseDto)) {
                cashedResponse.add(responseDto);
                return createResponse(responseDto, countryCode);
            }
        }
        return generateNext(countryCode);
    }

    public static String createResponse(ResponseDto responseDto, String countryCode) {
        return responseDto.getFirstSymbol() + " " + intToString(responseDto.getNum()) + " " + responseDto.getSecondSymbol().name() + responseDto.getThirdSymbol().name() + countryCode;
    }

    private static boolean isFreeNumber() {
        if (cashedResponse.size() == (Math.pow(Letter.values().length, 3) * (LAST_NUMBER + 1))) {
            throw new RuntimeException("There is no any available number");
        }
        return true;
    }
}
