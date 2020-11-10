package dev.grabros.osikdang.web.controller;

import dev.grabros.osikdang.openApi.kakao.KakaoMapProvider;
import dev.grabros.osikdang.web.dto.AddressResponse;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
public class KakaoMapController {

    private final KakaoMapProvider kakaoMapProvider;

    @GetMapping("/address")
    public ResponseEntity<AddressResponse> viewAddressInformation(
        @RequestParam(value = "x") Double x,
        @RequestParam(value = "y") Double y) {
        return new ResponseEntity(kakaoMapProvider.getAddressInformation(new Coordinate(x, y)), HttpStatus.OK);
    }
}
