package com.appsdeveloperblog.spring.mvc.SpringBootMVCProject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

//    @GetMapping("/")
//    public String homePage(Model model){
//        model.addAttribute("firstName", "Andrés")
//                .addAttribute("lastName", "Salazar");
//        return "home";
//    }

    @GetMapping("/")
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("home");
        modelAndView.addObject("firstName", "Andrés");
        modelAndView.addObject("lastName", "Salazar");

        return modelAndView;
    }

}
