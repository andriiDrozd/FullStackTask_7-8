package ua.drozdAndrii.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.drozdAndrii.app.dao.UserDao;
import ua.drozdAndrii.app.model.User;
import ua.drozdAndrii.app.validator.LoginValidator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;

@Controller
@RequestMapping("/login")
public class LoginController {
    LoginValidator loginValidator;
    private UserDao userDao;

    public LoginController(LoginValidator loginValidator, UserDao userDao) {
        this.loginValidator = loginValidator;
        this.userDao = userDao;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/loginCheck")
    public String checkLogin(@RequestParam("email") String email,
                             @RequestParam("password") String password,
                             Model model, HttpServletRequest request) {
        User user = userDao.getUserByEmailAndPassword(email, password);

        loginValidator.validFields(email, password, model);

        User userFields = new User(email, password);
        model.addAttribute("user", userFields);

        if (!model.getAttribute("emailError").equals("") || !model.getAttribute("passwordError").equals("")) {
            return "login";
        }

        if (user == null) {
            model.addAttribute("ErrorInvalidUser", "There is no user with such email or password, please check it!");
            return "login";
        }
        model.addAttribute("user", user);

        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);

        return "menu";

    }
}
