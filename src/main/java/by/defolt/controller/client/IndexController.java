package by.defolt.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping(value = "/index")
    public ModelAndView indexPage() {
        ModelAndView modelAndView = new ModelAndView("client/index");
        return modelAndView;
    }

}
