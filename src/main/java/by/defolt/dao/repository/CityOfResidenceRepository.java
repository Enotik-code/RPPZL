package by.defolt.dao.repository;

import by.defolt.entity.bean.CityOfResidence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityOfResidenceRepository extends JpaRepository<CityOfResidence, Long> {
    List<CityOfResidence> findAll();
}
