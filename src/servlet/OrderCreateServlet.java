package servlet;

import bean.Consumer;
import bean.Order;
import bean.OrderItem;
import dao.OrderDAO;
import dao.OrderItemDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xijiaxiang on 5/15/16.
 */
@WebServlet(name = "OrderCreateServlet", urlPatterns = "/createOrder")
public class OrderCreateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
        Consumer u = (Consumer) req.getSession().getAttribute("consumer");
        if (null == u) {
            resp.sendRedirect("/login.jsp");
            return;
        }

        Order o = new Order();
        o.setUser(u);

        new OrderDAO().insert(o);

        List<OrderItem> ois = (List<OrderItem>) req.getSession().getAttribute("ois");
        for (OrderItem oi : ois) {
            oi.setOrder(o);
            new OrderItemDAO().insert(oi);
        }

        ois.clear();

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("订单创建成功");

    }
}
