package ua.drozdAndrii.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.regex.Pattern;
@Component
public class LoginValidator {

    public void validFields(String email, String password, Model model) {
        emailValidator(email, model);
        passwordValidator(password, model);
    }

    private void emailValidator(String emailAddress, Model model) {
        StringBuilder emailError = new StringBuilder();

        if (emailAddress.trim().isEmpty()) {
            emailError.append("Email cannot be empty. ");
        }
        model.addAttribute("emailError", emailError.toString());
    }

    private void passwordValidator(String password, Model model) {
        StringBuilder passwordError = new StringBuilder();
        if (password.trim().isEmpty()) {
            passwordError.append("Password cannot be empty. ");
        }
        model.addAttribute("passwordError", passwordError.toString());
    }
}
