package by.defolt.authentication.repository;
import by.defolt.authentication.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAll();
    List<Client> findAllByUserName(String userName);
    List<Client> findAllByFirstName(String firstName);
    List<Client> findAllByLastName(String lastName);
    List<Client> findAllByPatronymic(String patronymic);
    List<Client> findAllByPassportNumber(String passportNumber);
    List<Client> findAllByIdentificationNumber(String identificationNumber);
    Client findClientByUserName(String userName);
}
