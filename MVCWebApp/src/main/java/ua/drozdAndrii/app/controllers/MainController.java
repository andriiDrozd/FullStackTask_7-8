package ua.drozdAndrii.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.drozdAndrii.app.dao.UserDao;
import ua.drozdAndrii.app.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MainController {
    UserDao userDao;

    public MainController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public String getUserTable(Model model){
         List<User> usersList=userDao.getAllUsers();
        model.addAttribute("usersList", usersList);
        return "usersTable";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "login";
    }
}
