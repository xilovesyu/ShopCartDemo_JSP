package servlet;

import bean.Product;
import dao.ProductDAO;

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
@WebServlet(name = "ProductListServlet", urlPatterns = "/productlist")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        List<Product> productList = new ProductDAO().listProduct();
        req.setAttribute("products", productList);
        req.getRequestDispatcher("listProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        List<Product> productList = new ProductDAO().listProduct();
        req.setAttribute("products", productList);
        req.getRequestDispatcher("listProduct.jsp").forward(req, resp);
    }
}
