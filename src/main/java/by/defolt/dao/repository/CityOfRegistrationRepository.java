package by.defolt.dao.repository;

import by.defolt.entity.bean.CityOfRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityOfRegistrationRepository  extends JpaRepository<CityOfRegistration, Long> {
    List<CityOfRegistration> findAll();
}
