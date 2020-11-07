package dev.grabros.osikdang.openApi.kakao;

import lombok.Getter;

@Getter
public enum KakaoMapEnum {
    BASE_URL("https://dapi.kakao.com/v2/local/geo/coord2regioncode.json"),
    INPUT_COORD("input_coord"),
    OUTPUT_COORD("output_coord"),
    WGS84("WGS84");

    private String value;

    KakaoMapEnum(String value) {
        this.value = value;
    }
}
