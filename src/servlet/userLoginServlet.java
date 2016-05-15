package servlet;

import bean.Consumer;
import dao.ConsumerDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xijiaxiang on 5/15/16.
 */
@WebServlet(name = "UserLoginServlet", urlPatterns = "/login")
public class userLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Consumer consumer = new ConsumerDAO().getConsumer(name, password);
        if (consumer != null) {
            req.getSession().setAttribute("consumer", consumer);
            resp.sendRedirect("/productlist");
        } else {
            resp.sendRedirect("/userLogin.jsp");
        }
    }
}
