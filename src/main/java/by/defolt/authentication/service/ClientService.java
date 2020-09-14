package by.defolt.authentication.service;


import by.defolt.authentication.bean.Client;
import by.defolt.authentication.bean.Role;
import by.defolt.authentication.bean.UserRoles;
import by.defolt.authentication.repository.ClientRepository;
import by.defolt.authentication.repository.RoleRepository;
import by.defolt.config.DatabaseConection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Client saveClient(Client client, Optional<UserRoles> userRoleOp) {
        UserRoles newUserRole = userRoleOp.orElseGet(() -> UserRoles.ROLE_GUEST);
        client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
        client.setActive(true);
        Role userRole = roleRepository.findByRoleName(newUserRole);
        if (userRole == null) {
            userRole = roleRepository.save(new Role(null, newUserRole));
        }
        client.setRoles(new HashSet<>(Arrays.asList(userRole)));
        return clientRepository.save(client);
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public String generateActivationCode(){
        Random r = new Random();
        return  String.valueOf(r.nextInt((999999 - 100000) + 1) + 100000);
    }

    public void deactivateUser(Long id) throws SQLException {
        String query = " update users " +
                "set users.active = 0 " +
                "where users.id_client = " + id;
        try (PreparedStatement preparedStatement = DatabaseConection.getDbConnection().prepareStatement(query)) {
            preparedStatement.execute();
        }
    }

    public void activateUser(Long id) throws SQLException {
        String query = "update users " +
                "set users.active = 1" +
                " where users.id_client = " + id;
        try (PreparedStatement preparedStatement = DatabaseConection.getDbConnection().prepareStatement(query)) {
            preparedStatement.execute();
        }
    }

    public Client findUserByUserName(String userName) {
        return clientRepository.findClientByUserName(userName);
    }

    public boolean checkUserName(String userName){
        return clientRepository.findAllByUserName(userName).size() == 0;
    }

    public boolean checkFirstName(String firstName){
        return clientRepository.findAllByFirstName(firstName).size() == 0;
    }

    public boolean checkLastName(String lastName){
        return clientRepository.findAllByLastName(lastName).size() == 0;
    }

    public boolean checkPatronymic(String patronymic){
        return clientRepository.findAllByPatronymic(patronymic).size() == 0;
    }

    public boolean checkPassportNumber(String passportNumber){
        return clientRepository.findAllByPassportNumber(passportNumber).size() == 0;
    }

    public boolean checkIdentificationNumber(String identificationNumber){
        return clientRepository.findAllByIdentificationNumber(identificationNumber).size() == 0;
    }

    public void checkClientForRepeat(Client client){
    }
}
