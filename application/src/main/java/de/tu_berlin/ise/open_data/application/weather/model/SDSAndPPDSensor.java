package de.tu_berlin.ise.open_data.application.weather.model;

import de.tu_berlin.ise.open_data.library.model.Schema;

/**
 * Created by ahmadjawid on 6/20/17.
 * All necessary fields for parsing data from source is defined here.
 * Final fields are not used when parsing from file
 */
public class SDSAndPPDSensor extends Schema {


    private String sensorId;
    private String sensorType;
    private String location;
    private String lat;
    private String lon;
    private String timestamp;
    private String p1;
    private String durP1;
    private String ratioP1;
    private String p2;
    private String durP2;
    private String ratioP2;

    /**
     * Declared as final to skip the field when parsing csv file
     */
    private final String sourceId = "luftdaten_info";

    /**
     * Declared as final to skip the field when parsing csv file
     */
    private final String license = "find out";

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getDurP1() {
        return durP1;
    }

    public void setDurP1(String durP1) {
        this.durP1 = durP1;
    }

    public String getRatioP1() {
        return ratioP1;
    }

    public void setRatioP1(String ratioP1) {
        this.ratioP1 = ratioP1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getDurP2() {
        return durP2;
    }

    public void setDurP2(String durP2) {
        this.durP2 = durP2;
    }

    public String getRatioP2() {
        return ratioP2;
    }

    public void setRatioP2(String ratioP2) {
        this.ratioP2 = ratioP2;
    }

    public String getSourceId() {
        return sourceId;
    }

    public String getLicense() {
        return license;
    }

    @Override
    public String getDelimiter() {
        return ";";
    }
}
