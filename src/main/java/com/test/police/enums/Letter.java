package com.test.police.enums;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;


public enum Letter {
    A(1), B(2), C(3), E(4), H(5), K(6), M(7), O(8), P(9), T(10), X(11), Y(12);

    private final int code;
    private static final List<Letter> VALUES = Arrays.asList(values());

   Letter(int code) {
        this.code = code;
    }


    @SneakyThrows
    public static Letter getByCode(final int code) {
        return Arrays.stream(values()).filter(it -> it.code == code).findAny()
                .orElseThrow((Supplier<Throwable>) () -> new RuntimeException("Could not find letter by code: " + code));
    }

    public static boolean isLastLetter(Letter letter) {
        return letter.equals(Letter.Y);
    }


    public static Letter randomLetter() {
        return VALUES.get(new Random().nextInt(VALUES.size()));
    }

    public int getCode() {
        return code;
    }

}
