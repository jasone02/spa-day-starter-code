package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("user")
public class UserController {

    public UserController() {

    }

    @GetMapping
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        return "/user/add";
    }

    @PostMapping("submit")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("verify", verify);

        if (verify.equals(user.getPassword())) {
            return "/user/index";
        } else {
            return "/user/add";
        }
    }

}
