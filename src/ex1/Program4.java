package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program4 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        int id = 273;

        String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
        String sql = "DELETE NOTICE where ID=?";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
        //Statement st = con.createStatement();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);

        int result = st.executeUpdate();

        System.out.println(result);

        st.close();
        con.close();
    }
}
