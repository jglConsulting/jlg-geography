package jlg.geography.wsg84;

import static jlg.codecontract.CodeContract.verifyNotNull;

/**
 * Utility class that transforms various wsg84 shapes into a WKT string
 */
public class WktFormat {
    public static String transform(LatLon point){
        verifyNotNull(point);

        StringBuilder sb = new StringBuilder();
        sb.append("POINT(").append(point.getLongitude()).append(" ").append(point.getLatitude()).append(")");
        return sb.toString();
    }

    public static String transform(GeographicLine line){
        verifyNotNull(line);

        StringBuilder sb = new StringBuilder();
        sb.append("LINESTRING(");
        for(LatLon point:line.getPoints()){
            sb.append(point.getLongitude()).append(" ").append(point.getLatitude()).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));   //remove last ',' character
        sb.append(")");

        return sb.toString();
    }

    public static String transform(GeographicPolygon polygon){
        verifyNotNull(polygon);

        StringBuilder sb = new StringBuilder();
        sb.append("POLYGON((");
        for(LatLon point:polygon.getPoints()){
            //append each coordinate
            sb.append(point.getLongitude()).append(" ").append(point.getLatitude()).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));   //remove last ',' character
        sb.append("))");

        return sb.toString();
    }

    public static String transform(GeographicMultiPolygon multiPolygon){
        verifyNotNull(multiPolygon);

        StringBuilder sb = new StringBuilder();
        sb.append("MULTIPOLYGON(");
        for(GeographicPolygon polygon:multiPolygon.getPolygons()){
            String polygonWkt = WktFormat.transform(polygon).replace("POLYGON","");
            sb.append(polygonWkt);
            sb.append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(")");

        return sb.toString();
    }
}