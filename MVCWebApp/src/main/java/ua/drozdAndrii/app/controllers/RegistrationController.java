package ua.drozdAndrii.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.drozdAndrii.app.dao.UserDao;
import ua.drozdAndrii.app.model.User;
import ua.drozdAndrii.app.validator.RegistrationValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/registration")
public class RegistrationController {
    RegistrationValidator registrationValidator;
    UserDao userDao;

    public RegistrationController(RegistrationValidator registrationValidator, UserDao userDao) {
        this.registrationValidator = registrationValidator;
        this.userDao = userDao;
    }

    @GetMapping
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping
    public String registerNewUser(@RequestParam("name") String name,
                                  @RequestParam("email") String email,
                                  @RequestParam("password") String password,
                                  Model model, HttpServletRequest request) {

        registrationValidator.validFields(email, password, name, model);

        if (!model.getAttribute("emailError").equals("") || !model.getAttribute("passwordError").equals("") || !model.getAttribute("nameError").equals("")) {
            model.addAttribute("name", name);
            model.addAttribute("email", email);
            model.addAttribute("password", password);
            return "registration";
        }
        User user = new User(userDao.getUSER_ID() + 1, email, password, name);
        userDao.addUser(user);

        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        return "menu";
    }
}
