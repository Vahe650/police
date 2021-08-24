package com.test.police;

import com.test.police.dto.ResponseDto;
import com.test.police.enums.Letter;
import com.test.police.service.CarNumberService;
import com.test.police.util.RandomNumberGenerator;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PoliceApplicationTests {

    @Autowired
    CarNumberService carNumberService;



    @Test
    void contextLoads() {
    }

    @Test
     void testGetNext() {
        ResponseDto responseDtoWhenNull = new ResponseDto(0, Letter.A, Letter.A, Letter.A);
        Assertions.assertEquals(RandomNumberGenerator.createResponse(responseDtoWhenNull,"116 RUS"), carNumberService.getNextNumber());
        ResponseDto responseDtoWhenNotNull = new ResponseDto(1, Letter.A, Letter.A, Letter.A);
        Assertions.assertEquals(RandomNumberGenerator.createResponse(responseDtoWhenNotNull,"116 RUS"), carNumberService.getNextNumber());
    }

}
