package com.ua.controllers;

import com.ua.converters.UserToUserDto;
import com.ua.dto.UserDto;
import com.ua.entities.User;
import com.ua.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;
    private UserToUserDto userToUserDto;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserToUserDto(UserToUserDto userToUserDto) {
        this.userToUserDto = userToUserDto;
    }

    @RequestMapping("/")
    public String redirectListOfUsers(){
        return "redirect:user/list";
    }

    @RequestMapping({"/user/list","/user"})
    public String listUsers(Model model){
        model.addAttribute("users", userService.listAll());
        return "user/list";
    }

    @RequestMapping("/user/show/{id}")
    public  String getUser(@PathVariable String id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "user/show";
    }

   @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        User user = userService.getById(id);
        UserDto userDto = userToUserDto.convert(user);

        model.addAttribute("userDto",userDto);
        return "user/userDto";

   }

   @RequestMapping("/user/new")
    public  String newUser(Model model){
        model.addAttribute("userDto", new UserDto());
        return "user/userDto";
   }

   @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveOrUpdateUser(@Valid UserDto userDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "user/userDto";
        }
        User savedUser = userService.saveOrUpdateUserDto(userDto);
        return "redirect:/user/show/" + savedUser.get_id();
   }

    @RequestMapping("/user/delete/{id}")
    public String delete(@PathVariable String id){
        userService.delete(id);
        return "redirect:/user/list";
    }





















}
