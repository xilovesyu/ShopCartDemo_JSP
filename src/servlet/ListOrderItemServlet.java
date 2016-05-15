package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xijiaxiang on 5/15/16.
 */
@WebServlet(name = "ListOrderItemServlet", urlPatterns = "/listOrderItem")
public class ListOrderItemServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
        req.getRequestDispatcher("listOrderItem.jsp").forward(req, resp);
    }
}
