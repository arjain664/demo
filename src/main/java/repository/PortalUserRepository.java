package repository;

import entity.PortalUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortalUserRepository extends CrudRepository<PortalUser, Integer> {
    @Override
    PortalUser save(PortalUser user);

    @Override
    Optional<PortalUser> findById(Integer userId);
}
