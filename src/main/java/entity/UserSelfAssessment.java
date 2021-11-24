package entity;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class UserSelfAssessment {
    @OneToOne()
    @JoinTable(name="PortalUser")
    int userId;
    List<String> symptoms;
    boolean travelHistory;
    boolean contactWithCovidPatient;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public boolean isTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(boolean travelHistory) {
        this.travelHistory = travelHistory;
    }

    public boolean isContactWithCovidPatient() {
        return contactWithCovidPatient;
    }

    public void setContactWithCovidPatient(boolean contactWithCovidPatient) {
        this.contactWithCovidPatient = contactWithCovidPatient;
    }
}
