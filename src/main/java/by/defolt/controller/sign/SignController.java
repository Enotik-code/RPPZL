package by.defolt.controller.sign;

import by.defolt.authentication.bean.Client;
import by.defolt.authentication.repository.ClientRepository;
import by.defolt.authentication.service.ClientAccessService;
import by.defolt.authentication.service.ClientService;
import by.defolt.mail.MailEngine;
import by.defolt.validate.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.util.Optional;


@Controller
public class SignController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(value = "/signUp")
    public String signUp() {
        return "sign/signUp";
    }

    @GetMapping("/signIn")
    public ModelAndView showLoginPage() {
        return new ModelAndView("sign/signIn");
    }

    @PostMapping(value = "/signUp")
    public ModelAndView addNewUser(@RequestParam(value = "user_name", required = false) String userName,
                                   @RequestParam(value = "first_name", required = false) String firstName,
                                   @RequestParam(value = "last_name", required = false) String lastName,
                                   @RequestParam(value = "email", required = false) String email,
                                   @RequestParam(value = "password", required = false) String password,
                                   @RequestParam Optional<String> confPassword) throws SQLException {
        ModelAndView mod = new ModelAndView("sign/signUp");
        Client client = clientService.findUserByUserName(userName);
        Client newClient = Client.builder()
                .userName(userName)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .activationCode(clientService.generateActivationCode())
                .password(password)
                .build();
        if (client != null) {
            mod.addObject("successRegistration", "User with the same name already exists!");
            return mod;
        }
        if (!confPassword.isPresent() || !newClient.getPassword().equals(confPassword.get())) {
            mod.addObject("successRegistration", "Password mismatch.");
        }
        if (!UserValidate.validateFirstName(newClient.getFirstName())) {
            mod.addObject("successRegistration", "Enter a name of more than 3 characters.");
        }
        if (!UserValidate.validateLastName(newClient.getLastName())) {
            mod.addObject("successRegistration", "Enter the last name more than 3 characters.");
        }
        if (!UserValidate.validatePassword(newClient.getPassword())) {
            mod.addObject("successRegistration", "Create a password with more than 8 characters.");
        }
        if (UserValidate.checkValidateDataUser(newClient) &&
                (!confPassword.isPresent() || newClient.getPassword().equals(confPassword.get()))) {
            clientService.saveClient(newClient, Optional.empty());
            clientService.deactivateUser(newClient.getId());
            mod.setViewName("sign/signUp");
            return new ModelAndView("redirect:/infoClient");
        }
        return mod;
    }
}