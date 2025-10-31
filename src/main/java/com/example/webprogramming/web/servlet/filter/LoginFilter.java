package com.example.webprogramming.web.servlet.filter;

import com.example.webprogramming.model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        User loggedInUser = (User) request.getSession().getAttribute("user");
        String path = request.getServletPath();

        if (loggedInUser == null && !path.equals("/login")) {
            response.sendRedirect("/login");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
