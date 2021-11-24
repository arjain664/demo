package repository;

import entity.Zone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZoneRepository extends CrudRepository<Zone, String> {
    @Override
    <S extends Zone> S save(S entity);

    @Override
    Optional<Zone> findById(String s);
}
