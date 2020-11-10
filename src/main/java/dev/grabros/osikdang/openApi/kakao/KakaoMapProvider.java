package dev.grabros.osikdang.openApi.kakao;

import dev.grabros.osikdang.global.error.exception.openApi.InvalidRequestException;
import dev.grabros.osikdang.global.error.exception.openApi.KakaoApiException;
import dev.grabros.osikdang.openApi.OpenApiProvider;
import dev.grabros.osikdang.openApi.kakao.response.KakaoMap;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static dev.grabros.osikdang.openApi.kakao.KakaoMapEnum.*;

@Component
@RequiredArgsConstructor
public class KakaoMapProvider implements OpenApiProvider {

    private final WebClient.Builder builder;

    @Value("${KAKAO_REST_API_KEY}")
    private String KAKAO_REST_API_KEY;

    @Override
    public KakaoMap requestAddressByCoordinate(Coordinate coordinate) {
        WebClient webClient = builder.baseUrl(BASE_URL.getValue()).build();
        KakaoMap kakaoMap = webClient.get()
            .uri(uriBuilder -> uriBuilder
                .queryParam(COORDINATE_X.getValue(), coordinate.x)
                .queryParam(COORDINATE_Y.getValue(), coordinate.y)
                .build())
            .header(HttpHeaders.AUTHORIZATION, KAKAO_AK.getValue() + KAKAO_REST_API_KEY)
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new InvalidRequestException()))
            .onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new KakaoApiException()))
            .bodyToMono(KakaoMap.class)
            .block();

        return kakaoMap;
    }
}
