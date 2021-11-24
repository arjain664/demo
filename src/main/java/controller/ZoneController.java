package controller;

import entity.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.ZoneService;

@RestController
public class ZoneController {

    @Autowired
    ZoneService zoneService;

    @RequestMapping(value = "/api/zone/getZoneInfo", method = RequestMethod.GET, produces = "application/json")
    public ZoneDTO getZoneInfo(@RequestBody String pinCode) {
        Zone zoneInfo = zoneService.getZoneInfo(pinCode);
        return new ZoneDTO(zoneInfo.getNumberOfCases(), zoneInfo.getZoneType());
    }
}
