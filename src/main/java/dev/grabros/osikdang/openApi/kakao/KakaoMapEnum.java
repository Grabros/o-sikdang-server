package dev.grabros.osikdang.openApi.kakao;

import lombok.Getter;

@Getter
public enum KakaoMapEnum {
    BASE_URL("https://dapi.kakao.com/v2/local/geo/coord2regioncode.json"),
    COORDINATE_X("x"),
    COORDINATE_Y("y"),
    KAKAO_AK("KakaoAK ");

    private String value;

    KakaoMapEnum(String value) {
        this.value = value;
    }
}
