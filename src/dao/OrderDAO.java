package dao;

import bean.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xijiaxiang on 5/15/16.
 */
public class OrderDAO {
    public void insert(Order o) {

        try {

            Connection c = JDBCconnection.getConnection();

            String sql = "insert into order_ values(null,?)";

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, o.getUser().getId());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                o.setId(id);
            }

            ps.close();

            c.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
