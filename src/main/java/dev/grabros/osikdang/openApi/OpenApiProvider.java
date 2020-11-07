package dev.grabros.osikdang.openApi;

import org.locationtech.jts.geom.Coordinate;

public interface OpenApiProvider {

    <T> T requestAddressByCoordinate(Coordinate coordinate);
}
