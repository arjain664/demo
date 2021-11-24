package service;

import controller.CovidResult;
import entity.PortalUser;
import entity.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    ZoneService zoneService;

    @Autowired
    UserService userService;

    public boolean updateCovidResult(CovidResult covidResult) {
        PortalUser user = userService.getUser(covidResult.getUserId());
        Zone zone = zoneService.getZoneInfo(user.getPinCode());
        if(covidResult.isResult()) {
            zone.incrementNumberOfCases();
        }
        else {
            zone.decrementNumberOfCases();
        }
        //save zone
        return true;
    }
}
