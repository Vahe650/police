package com.test.police.dto;

import com.test.police.enums.Letter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class ResponseDto {

    private final int num;
    private final Letter firstSymbol;
    private final Letter secondSymbol;
    private final Letter thirdSymbol;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseDto that = (ResponseDto) o;
        return num == that.num &&
                firstSymbol == that.firstSymbol &&
                secondSymbol == that.secondSymbol &&
                thirdSymbol == that.thirdSymbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, firstSymbol, secondSymbol, thirdSymbol);
    }
}
