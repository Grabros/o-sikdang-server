package dev.grabros.osikdang.openApi.kakao.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class KakaoMap {

    @JsonProperty("documents")
    private List<KakaoMapDocument> kakaoMapDocuments = new ArrayList<>();
}
