package dao;

import bean.Consumer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xijiaxiang on 5/15/16.
 */
public class ConsumerDAO {
    public Consumer getConsumer(String name, String password) {
        Connection connection = JDBCconnection.getConnection();
        Consumer consumer = null;
        String sql = "select * from Consumer where name=? and password=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String Cname = rs.getString(2);
                String Cpassword = rs.getString(3);
                consumer = new Consumer(id, Cname, Cpassword);
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consumer;
    }
}
