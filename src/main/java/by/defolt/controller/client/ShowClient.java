package by.defolt.controller.client;

import by.defolt.authentication.bean.Client;
import by.defolt.authentication.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowClient {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping(value = "/showClient"+ "/{id}")
    public ModelAndView showClient(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("client/showClient");
        Client thisClient = clientRepository.findClientById(id);
        modelAndView.addObject("client", thisClient);
        return modelAndView;
    }
}
