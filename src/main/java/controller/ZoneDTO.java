package controller;

public class ZoneDTO {
    int numberOfCases;
    String zoneType;

    public ZoneDTO(int numberOfCases, String zoneType) {
        this.numberOfCases = numberOfCases;
        this.zoneType = zoneType;
    }

    public int getNumberOfCases() {
        return numberOfCases;
    }

    public void setNumberOfCases(int numberOfCases) {
        this.numberOfCases = numberOfCases;
    }

    public String getZoneType() {
        return zoneType;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }
}
