package dev.grabros.osikdang.domain.restaurant;

import dev.grabros.osikdang.domain.favorite.Favorite;
import dev.grabros.osikdang.domain.myList.MyList;
import dev.grabros.osikdang.domain.review.Review;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.locationtech.jts.geom.Point;

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

    private Point point;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorite> favorites = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MyList> myLists = new ArrayList<>();
}
