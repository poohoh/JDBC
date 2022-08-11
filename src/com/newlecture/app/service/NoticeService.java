package com.newlecture.app.service;

import com.newlecture.app.entity.Notice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeService {

    String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
    private String uid = "NEWLEC";
    private String pwd = "1234";
    private String driver = "oracle.jdbc.driver.OracleDriver";

    public List<Notice> getList() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM NOTICE";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uid, pwd);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        List<Notice> list = new ArrayList<Notice>();

        while (rs.next()) {
            int id = rs.getInt("ID");
            String title = rs.getString("TITLE");
            String writerId = rs.getString("WRITER_ID");
            Date regDate = rs.getDate("REGDATE");
            String content = rs.getString("CONTENT");
            int hit = rs.getInt("HIT");
            String files = rs.getString("FILES");

            Notice notice = new Notice(id, title, writerId, regDate, content, hit, files);

            list.add(notice);
        }

        rs.close();
        st.close();
        con.close();

        return list;
    }

    public int insert(Notice notice) throws ClassNotFoundException, SQLException {

        String title = notice.getTitle();
        String writerId = notice.getWriterId();
        String content = notice.getContent();
        String files = notice.getFiles();

        String sql = "INSERT INTO NOTICE (" +
                "TITLE," +
                "WRITER_ID," +
                "CONTENT," +
                "FILES" +
                ") VALUES (?,?,?,?)";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uid, pwd);
        //Statement st = con.createStatement();
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, title);
        st.setString(2, writerId);
        st.setString(3, content);
        st.setString(4, files);

        int result = st.executeUpdate();

        st.close();
        con.close();

        return result;
    }

    public int update(Notice notice) throws ClassNotFoundException, SQLException {

        String title = notice.getTitle();
        String content = notice.getContent();
        String files = notice.getFiles();
        int id = notice.getId();

        String sql = "update notice " +
                "set" +
                "            title=?," +
                "            CONTENT=?," +
                "            files=?" +
                "    where id=?";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uid, pwd);
        //Statement st = con.createStatement();
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, title);
        st.setString(2, content);
        st.setString(3, files);
        st.setInt(4, id);

        int result = st.executeUpdate();

        st.close();
        con.close();

        return result;
    }

    public int delete(int id) throws ClassNotFoundException, SQLException {

        String sql = "DELETE NOTICE where ID=?";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uid, pwd);
        //Statement st = con.createStatement();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);

        int result = st.executeUpdate();

        System.out.println(result);

        st.close();
        con.close();

        return result;
    }
}
