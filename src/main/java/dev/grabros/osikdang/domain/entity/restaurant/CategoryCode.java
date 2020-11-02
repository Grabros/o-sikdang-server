package dev.grabros.osikdang.domain.entity.restaurant;

import dev.grabros.osikdang.global.error.exception.CategoryNotFoundException;
import java.util.Arrays;
import lombok.Getter;

@Getter
public enum CategoryCode {
    C01("한식"),
    C02("일식/수산물"),
    C03("중식"),
    C04("양식"),
    C05("패스트푸드"),
    C06("분식"),
    C07("별식/퓨전요리"),
    C08("닭/오리요리"),
    C09("부페"),
    C10("기타음식업"),
    C11("음식배달서비스"),
    C12("커피점/카페"),
    C13("제과제빵떡케익");

    private String value;

    CategoryCode(String value) {
        this.value = value;
    }

    public static String getValueOf(String categoryCode) {
        return Arrays.stream(values())
            .filter(v -> categoryCode.equals(v.toString()))
            .findFirst()
            .orElseThrow(CategoryNotFoundException::new)
            .value;
    }
}
