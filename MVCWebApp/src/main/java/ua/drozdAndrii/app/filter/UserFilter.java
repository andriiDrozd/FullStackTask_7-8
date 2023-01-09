package ua.drozdAndrii.app.filter;

import org.springframework.stereotype.Component;
import ua.drozdAndrii.app.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns ={"/menu/*", "/logout/*"} )

public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        User loggedUser = (User) request.getSession().getAttribute("user");

        if(loggedUser == null) {
            response.setStatus(401);
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
