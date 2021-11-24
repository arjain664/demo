package repository;

import entity.PortalUser;
import entity.UserSelfAssessment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSelfAssessmentRepository extends CrudRepository<UserSelfAssessment, Integer> {

    @Override
    UserSelfAssessment save(UserSelfAssessment userSelfAssessment);

    @Override
    Optional<UserSelfAssessment> findById(Integer userId);
}
