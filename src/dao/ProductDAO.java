package dao;

import bean.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xijiaxiang on 5/15/16.
 */
public class ProductDAO {
    public List<Product> listProduct() {
        List<Product> products = new ArrayList<>();
        Connection connection = JDBCconnection.getConnection();
        String sql = "select * from product order by id desc";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                float price = resultSet.getFloat(3);
                Product product = new Product(id, name, price);
                products.add(product);
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getProduct(int id) {
        Product result = null;
        Connection c = JDBCconnection.getConnection();

        String sql = "select * from product where id = ?";

        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = new Product();
                result.setId(id);

                String name = rs.getString(2);
                float price = rs.getFloat(3);

                result.setName(name);
                result.setPrice(price);

            }
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
