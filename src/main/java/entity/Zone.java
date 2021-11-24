package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Zone {
    @Id
    String pinCode;
    int numberOfCases;
    String zoneType;

    public Zone(String pinCode, int numberOfCases, String zoneType) {
        this.pinCode = pinCode;
        this.numberOfCases = numberOfCases;
        this.zoneType = zoneType;
        computeZoneType();
    }

    public Zone(String pinCode) {
        this.pinCode = pinCode;
        this.numberOfCases = 0;
        computeZoneType();
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public int getNumberOfCases() {
        return numberOfCases;
    }

    public void incrementNumberOfCases() {
        numberOfCases++;
        computeZoneType();
    }

    public void decrementNumberOfCases() {
        if(numberOfCases > 0)
            numberOfCases--;
        computeZoneType();
    }

    private void computeZoneType() {
        if(numberOfCases == 0)
            zoneType = "GREEN";
        else if(numberOfCases < 5)
            zoneType = "ORANGE";
        else
            zoneType = "RED";
    }

    public String getZoneType() {
        return zoneType;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }
}
