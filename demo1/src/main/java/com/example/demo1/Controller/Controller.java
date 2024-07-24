package com.example.demo1.Controller;


import com.example.demo1.Model.User;
import com.example.demo1.Service.UserService;
import com.example.demo1.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
            private UserService userService;


    @GetMapping(value = "/")
    public String printWelcome(Model model) {
        List<User> userList = userService.getAllUsers();
        if(userList.isEmpty()) {
            model.addAttribute("emptyList", true);
        } else {
            model.addAttribute("userList", userList);
        }
        model.addAttribute("user", new User());
        return "index";
    }

    @GetMapping(value = "/addUser")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping(value = "/addUser")
    public String addUserSubmit(User user, Model model) {
        userService.addUser(user);
        model.addAttribute("message", "Добавлен");
        return "redirect:/";
    }

    @GetMapping(value = "/editUser")
    public String editUserForm(@RequestParam Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "/editUser")
    public String editUserSubmit(User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam Long id, Model model) {
        userService.deleteUser(id);
        model.addAttribute("message", "Пользователь успешно удален");
        return "redirect:/";
    }
        }