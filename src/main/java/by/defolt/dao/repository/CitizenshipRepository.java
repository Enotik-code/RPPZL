package by.defolt.dao.repository;

import by.defolt.entity.bean.Citizenship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenshipRepository extends JpaRepository<Citizenship, Long> {
    List<Citizenship> findAll();
}
