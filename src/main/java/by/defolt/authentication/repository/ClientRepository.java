package by.defolt.authentication.repository;
import by.defolt.authentication.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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
    Client findClientById(Long id);
    Client findClientByUserName(String userName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Client c set c.firstName = ?2, c.lastName = ?3, c.userName = ?4, c.email = ?5," +
            " c.address = ?6 where  c.id = ?1")
    void updateInfo(long id, String firstName, String lastName, String userName, String email, String address);

}
