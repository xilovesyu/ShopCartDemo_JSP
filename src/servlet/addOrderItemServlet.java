package servlet;

import bean.OrderItem;
import bean.Product;
import dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xijiaxiang on 5/15/16.
 */
@WebServlet(name = "addOrderItemServlet", urlPatterns = "/addOrderItem")
public class addOrderItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
        int num = Integer.parseInt(req.getParameter("num"));
        int pid = Integer.parseInt(req.getParameter("pid"));
        Product p = new ProductDAO().getProduct(pid);

        OrderItem orderItem = new OrderItem();
        orderItem.setNum(num);
        orderItem.setProduct(p);

        List<OrderItem> orderItemList = (List<OrderItem>) req.getSession().getAttribute("ois");
        if (null == orderItemList) {
            orderItemList = new ArrayList<>();
            req.getSession().setAttribute("ois", orderItemList);
        }
        orderItemList.add(orderItem);
        resp.sendRedirect("/listOrderItem");
    }
}
