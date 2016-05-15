package dao;

import bean.OrderItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by xijiaxiang on 5/15/16.
 */
public class OrderItemDAO {
    public void insert(OrderItem oi) {

        try {

            Connection c = JDBCconnection.getConnection();

            String sql = "insert into orderitem values(null,?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, oi.getProduct().getId());
            ps.setInt(2, oi.getNum());
            ps.setInt(3, oi.getOrder().getId());

            ps.execute();

            ps.close();

            c.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
