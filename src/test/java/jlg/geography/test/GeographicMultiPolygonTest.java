package jlg.geography.test;

import jlg.geography.wsg84.GeographicMultiPolygon;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GeographicMultiPolygonTest {
    @Test
    public void the_constructor_when_points_are_valid_should_build_multi_polygon(){
        //arrange
        final List<Double> somePolygonCoordinates = new ArrayList<Double>(Arrays.asList(10.123, 11.123, 12.123, 13.123, 10.123, 11.123));
        final List<Double> someOtherPolygonCoordinates = new ArrayList<>(Arrays.asList(15.123, 15.123, 12.123, 13.123, 15.123, 15.123));
        List<List<Double>> multipolygonPoints = new ArrayList<List<Double>>(){{
            add(somePolygonCoordinates);add(someOtherPolygonCoordinates);
        }};

        //act
        GeographicMultiPolygon multiPolygon = new GeographicMultiPolygon(multipolygonPoints);

        //assert
        int expectedPolygons = 2;
        assertEquals(expectedPolygons, multiPolygon.getPolygons().size());
    }
}