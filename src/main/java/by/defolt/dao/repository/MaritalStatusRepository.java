package by.defolt.dao.repository;

import by.defolt.entity.bean.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaritalStatusRepository extends JpaRepository<MaritalStatus, Long> {
    List<MaritalStatus> findAll();
}
