package SQL;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "jdbc:mysql://localhost:3306/jspdemosql";
        String username = "root";
        String password = "";

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM student";
            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);

            PrintWriter out = response.getWriter();
            while (myRs.next()) {
                String email = myRs.getString("email");
                out.println(email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng các đối tượng ResultSet, Statement và Connection
            try {
                if (myRs != null) {
                    myRs.close();
                }
                if (myStmt != null) {
                    myStmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
