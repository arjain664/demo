package service;

import entity.PortalUser;
import entity.UserSelfAssessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PortalUserRepository;
import repository.UserSelfAssessmentRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    PortalUserRepository portalUserRepository;

    @Autowired
    UserSelfAssessmentRepository userSelfAssessmentRepository;

    public PortalUser saveUser(PortalUser user){
        return portalUserRepository.save(user);
    }

    public PortalUser getUser(int userId){
        Optional<PortalUser> byId = portalUserRepository.findById(userId);
        if(!byId.isPresent())
            throw new RuntimeException("User not found");
        return byId.get();
    }

    public int saveAssessment(UserSelfAssessment assessment) {
        UserSelfAssessment userSelfAssessment = userSelfAssessmentRepository.save(assessment);
        return calculateRisk(userSelfAssessment);
    }

    private int calculateRisk(UserSelfAssessment assessment) {
        int noOfSymptoms = assessment.getSymptoms() != null ? assessment.getSymptoms().size() : 0;
        boolean travelHistory = assessment.isTravelHistory();
        boolean contact = assessment.isContactWithCovidPatient();

        if(noOfSymptoms == 0 && !travelHistory && !contact )
            return 5;
        else if(noOfSymptoms == 1 && (travelHistory || contact))
            return 50;
        else if(noOfSymptoms == 2 && (travelHistory || contact))
            return 75;
        else if(noOfSymptoms>2 && (travelHistory || contact)) {
            return 95;
        }
        return 50;
    }
}
