package by.defolt.dao.repository;

import by.defolt.entity.bean.Disability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisabilityRepository extends JpaRepository<Disability, Long> {
    List<Disability> findAll();
}
