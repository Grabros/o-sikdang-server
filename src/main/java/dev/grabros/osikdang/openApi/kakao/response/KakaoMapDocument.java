package dev.grabros.osikdang.openApi.kakao.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class KakaoMapDocument {

    @JsonProperty("address_name")
    private String address;

    @JsonProperty("region_1depth_name")
    private String addressProvince;

    @JsonProperty("region_2depth_name")
    private String addressCity;

    @JsonProperty("region_3depth_name")
    private String addressDistrict;

    @JsonProperty("region_4depth_name")
    private String addressDetail;

    private Double x;
    private Double y;
}
