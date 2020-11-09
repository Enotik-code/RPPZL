package by.defolt.controller.client;

import by.defolt.authentication.bean.Client;
import by.defolt.authentication.repository.ClientRepository;
import by.defolt.authentication.service.ClientAccessService;
import by.defolt.authentication.service.ClientService;
import by.defolt.consts.SuccessConstants;
import by.defolt.dao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@Controller
public class ClientInfoController {

    @Autowired
    private ClientAccessService clientAccessService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private CitizenshipRepository citizenshipRepository;

    @Autowired
    private CityOfRegistrationRepository cityOfRegistrationRepository;

    @Autowired
    private CityOfResidenceRepository cityOfResidenceRepository;

    @Autowired
    private MaritalStatusRepository maritalStatusRepository;

    @Autowired
    private DisabilityRepository disabilityRepository;

  /*  @GetMapping(value = "/additionalInfo")
    public ModelAndView updateUserInfo() {
        ModelAndView modelAndView = new ModelAndView("client/operationClient");
        //modelAndView.addObject(SuccessConstants.IS_AUTHENTICATED, clientAccessService.isCurrentUserAuthenticated());
        modelAndView.addObject("citizenship", citizenshipRepository.findAll());
        modelAndView.addObject("cityOfRegistration", cityOfRegistrationRepository.findAll());
        modelAndView.addObject("cityOfResidence", cityOfResidenceRepository.findAll());
        modelAndView.addObject("maritalStatus", maritalStatusRepository.findAll());
        modelAndView.addObject("disability", disabilityRepository.findAll());
        modelAndView.addObject("client", clientService.findUserByUserName("logon"));
        System.out.println(clientService.findUserByUserName("logon").getDateOfBirthday());
        modelAndView.addObject("disabilityHaving", (clientRepository.findClientByUserName("logon")).getIdDisability().equals(1L));
        modelAndView.addObject("retireeHaving", (clientRepository.findClientByUserName("logon")).getRetiree().equals(true));
        modelAndView.addObject("liableHaving", (clientRepository.findClientByUserName("logon")).getLiableForMilitaryService().equals(true));
        return modelAndView;
    }
*/

    @GetMapping(value = "/delete" + "/{id}")
    public ModelAndView deleteUser(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Client thisClient = clientRepository.findClientById(id);
        clientRepository.delete(thisClient);
        modelAndView.setViewName("redirect:/infoClients");
        return modelAndView;
    }


    @GetMapping(value = "/info" + "/{id}")
    public ModelAndView allInfo(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("client/operationClient");
        //modelAndView.addObject(SuccessConstants.IS_AUTHENTICATED, clientAccessService.isCurrentUserAuthenticated());
        Client thisClient = clientRepository.findClientById(id);
        modelAndView.addObject("client", thisClient);
        modelAndView.addObject("citizenship", citizenshipRepository.findAll());
        modelAndView.addObject("cityOfRegistration", cityOfRegistrationRepository.findAll());
        modelAndView.addObject("cityOfResidence", cityOfResidenceRepository.findAll());
        modelAndView.addObject("maritalStatus", maritalStatusRepository.findAll());
        modelAndView.addObject("disability", disabilityRepository.findAll());
        modelAndView.addObject("disabilityHaving", disabilityRepository.findAll());
        //modelAndView.addObject("retireeHaving", (thisClient.getRetiree().equals(true)));
        //modelAndView.addObject("liableHaving", (thisClient.getLiableForMilitaryService().equals(true)));
        return modelAndView;
    }

    @PostMapping(value = "/info" + "/{id}")
    public ModelAndView updateInfo(@PathVariable(name = "id") Long id,
                                   @RequestParam(value = "input_email", required = false) String userEmail,
                                   @RequestParam(value = "input_user_name", required = false) String userName,
                                   @RequestParam(value = "input_first_name", required = false) String firstName,
                                   @RequestParam(value = "input_second_name", required = false) String secondName,
                                   @RequestParam(value = "input_patronymic", required = false) String patronymic,
                                   @RequestParam(value = "input_address", required = false) String address,
                                   @RequestParam(value = "input_birthday", required = false) String birthday,
                                   @RequestParam(value = "input_gender", required = false) String gender){
        ModelAndView modelAndView = new ModelAndView("client/operationClient");
        //modelAndView.addObject(SuccessConstants.IS_AUTHENTICATED, clientAccessService.isCurrentUserAuthenticated());
        clientRepository.updateInfo(id, firstName, secondName, userName, userEmail, address);
        modelAndView.setViewName("redirect:/infoClients");
        return modelAndView;
    }

    @GetMapping(value = "/infoClients")
    public ModelAndView infoClients() {
        ModelAndView modelAndView = new ModelAndView("client/infoClient");
        modelAndView.addObject(SuccessConstants.IS_AUTHENTICATED, clientAccessService.isCurrentUserAuthenticated());
        modelAndView.addObject("client", clientRepository.findAll());
        return modelAndView;
    }

}
