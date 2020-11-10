package dev.grabros.osikdang.web.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressResponse {

    private List<AddressInformation> addressInformation = new ArrayList<>();

    @Builder
    protected AddressResponse(List<AddressInformation> addressInformation) {
        this.addressInformation = addressInformation;
    }

    public static AddressResponse of(List<AddressInformation> addressInformation) {
        return AddressResponse.builder()
            .addressInformation(addressInformation)
            .build();
    }
}
