package mk.ukim.finki.wp.lab4.web.servlet;//package mk.ukim.finki.wp.lab.web.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.mk.ukim.finki.wp.lab.service.ChefService;
//
//@WebServlet(name = "ChefListServlet", urlPatterns = "/listChefs")
//public class ChefListServlet extends HttpServlet {
//    private final SpringTemplateEngine templateEngine;
//    private final ChefService chefService;
//
//    public ChefListServlet(SpringTemplateEngine templateEngine, ChefService chefService) {
//        this.templateEngine = templateEngine;
//        this.chefService = chefService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
//
//        WebContext webContext = new WebContext(webExchange);
//        webContext.setVariable("chefs", chefService.listChefs());
//
//        templateEngine.process("listChefs.html", webContext, resp.getWriter());
//    }
//}
