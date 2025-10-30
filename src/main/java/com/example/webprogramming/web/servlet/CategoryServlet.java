package com.example.webprogramming.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "category-servlet", urlPatterns = "/servlet/category")
public class CategoryServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final List<Category> categories = new ArrayList<>();

    public CategoryServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        context.setVariable("ipAddress", req.getRemoteAddr());
        context.setVariable("userAgent", req.getHeader("user-agent"));
        context.setVariable("categories", categories);

        springTemplateEngine.process("categories.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        categories.add(new Category(name, description));
        resp.sendRedirect("/servlet/category");
    }

    @Getter
    @Setter
//    @AllArgsConstructor
    static class Category {
        private String name;
        private String description;

        public Category(String name, String description) {
            this.name = name;
            this.description = description;
        }
    }
}
