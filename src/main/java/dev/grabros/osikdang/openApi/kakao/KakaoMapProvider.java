package dev.grabros.osikdang.openApi.kakao;

import dev.grabros.osikdang.openApi.OpenApiProvider;
import dev.grabros.osikdang.openApi.kakao.response.KakaoMap;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import static dev.grabros.osikdang.openApi.kakao.KakaoMapEnum.*;

@Component
@RequiredArgsConstructor
public class KakaoMapProvider implements OpenApiProvider {

    private final WebClient.Builder builder;

    @Override
    public KakaoMap requestAddressByCoordinate(Coordinate coordinate) {
        WebClient webClient = builder.baseUrl(BASE_URL.getValue()).build();
        return null;
    }
}
