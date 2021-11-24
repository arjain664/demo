package service;

import entity.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ZoneRepository;

import java.util.Optional;

@Service
public class ZoneService {
    @Autowired
    ZoneRepository zoneRepository;

    public Zone getZoneInfo(String pinCode) {
        Optional<Zone> optZone = zoneRepository.findById(pinCode);
        Zone zone = optZone.orElse(new Zone(pinCode));
        return zone;
    }
}
