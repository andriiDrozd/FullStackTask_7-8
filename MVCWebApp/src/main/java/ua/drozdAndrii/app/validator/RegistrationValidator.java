package ua.drozdAndrii.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.regex.Pattern;

@Component
public class RegistrationValidator {
    public void validFields( String email, String password, String name, Model model) {
        emailValidator(email, model);
        passwordValidator(password, model);
        nameValidator(name, model);
    }
    private void emailValidator(String emailAddress, Model model) {
        StringBuilder emailError = new StringBuilder();

        if (!Pattern.compile("^(.+)@(\\S+)$")
                .matcher(emailAddress)
                .matches()) {
            emailError.append("Email should have @. ");
        }
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
        if (password.trim().length()<9) {
            passwordError.append("The length of password should more than 9 characters. ");
        }
        model.addAttribute("passwordError", passwordError.toString());
    }

    private void nameValidator(String name, Model model) {
        StringBuilder nameError = new StringBuilder();

        if (name.trim().isEmpty()) {
            nameError.append("The name cannot be empty. ");
        }
        if (!Pattern.compile("^[A-ZА-ЯЁ][^A-ZА-ЯЁ]+.*")
                .matcher(name)
                .matches()) {
            nameError.append("The name must start with a capital letter. ");
        }
        model.addAttribute("nameError", nameError.toString());
    }
}
