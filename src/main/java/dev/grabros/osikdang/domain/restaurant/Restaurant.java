package dev.grabros.osikdang.domain.restaurant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private String categoryCode;

    private String categoryMain;

    private String categorySub;

    private String categoryIndustry;

    private String addressProvince;

    private String addressCity;

    private String addressDistrict;

    private String addressDistrictOld;

    private String addressOld;

    private String address;

    private Integer zipCode;

    private Double longitude;

    private Double latitude;
}
