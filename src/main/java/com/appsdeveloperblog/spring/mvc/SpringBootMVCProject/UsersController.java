package com.appsdeveloperblog.spring.mvc.SpringBootMVCProject;

import com.appsdeveloperblog.spring.mvc.SpringBootMVCProject.model.User;
import com.appsdeveloperblog.spring.mvc.SpringBootMVCProject.model.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class UsersController {

    @GetMapping(path = "/users/{userId}/albums/{albumId}")
    public ModelAndView getAlbum(@PathVariable("userId") String userId, @PathVariable("albumId") String albumId){

        ModelAndView modelAndView = new ModelAndView("album");
        modelAndView.addObject("userId",userId);
        modelAndView.addObject("albumId",albumId);

        return modelAndView;
    }

    @GetMapping(path = "/users")
    public ModelAndView getUsers(@RequestParam(name = "limit", defaultValue = "5") int limit){
        System.out.println("Limit=" + limit);
        return new ModelAndView("users"); //Not Implemented
    }

    @PostMapping(path = "/users")
    public String signUpFormSubmit(@ModelAttribute User user){
        return "signUp-result";
    }

    @GetMapping(path = "/signUp")
    public String signUpForm(){
        return "signUp";
    }


    @PostMapping(path = "/createUser")
    @ResponseBody
    public ResponseEntity createUser(@RequestBody User user){
        return new ResponseEntity(
                new UserRest(UUID.randomUUID().toString(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail()), HttpStatus.OK);
    }


}
