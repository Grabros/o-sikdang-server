package dev.grabros.osikdang.global.util.geometry;

import lombok.Getter;

@Getter
public class Point {

    private Double x;
    private Double y;

    private Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(Double x, Double y) {
        return new Point(x, y);
    }
}
