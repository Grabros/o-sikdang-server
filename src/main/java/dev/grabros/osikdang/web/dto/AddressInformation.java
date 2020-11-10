package dev.grabros.osikdang.web.dto;

import dev.grabros.osikdang.openApi.kakao.response.KakaoMapAddress;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressInformation {

    private String address;
    private String addressProvince;
    private String addressCity;
    private String addressDistrict;
    private String addressDetail;

    @Builder
    protected AddressInformation(String address, String addressProvince, String addressCity,
        String addressDistrict, String addressDetail) {
        this.address = address;
        this.addressProvince = addressProvince;
        this.addressCity = addressCity;
        this.addressDistrict = addressDistrict;
        this.addressDetail = addressDetail;
    }

    public static AddressInformation of(KakaoMapAddress kakaoMapAddress) {
        return AddressInformation.builder()
            .address(kakaoMapAddress.getAddress())
            .addressProvince(kakaoMapAddress.getAddressProvince())
            .addressCity(kakaoMapAddress.getAddressCity())
            .addressDistrict(kakaoMapAddress.getAddressDistrict())
            .addressDetail(kakaoMapAddress.getAddressDetail())
            .build();
    }
}
