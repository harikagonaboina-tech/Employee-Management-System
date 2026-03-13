package employee_management_system;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UpdateEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Read parameters from query string
        int emp_id = Integer.parseInt(req.getParameter("emp_id"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String gender = req.getParameter("gender");

        // Display a simple form to update employee
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        pw.println("<html><body>");
        pw.println("<h2 align='center'>Update Employee</h2>");
        pw.println("<form method='post' action='UpdateEmployeeServlet'>");
        pw.println("<input type='hidden' name='emp_id' value='" + emp_id + "'>");
        pw.println("<table align='center'>");
        pw.println("<tr><td>Name:</td><td><input type='text' name='name' value='" + name + "'></td></tr>");
        pw.println("<tr><td>Address:</td><td><input type='text' name='address' value='" + address + "'></td></tr>");
        pw.println("<tr><td>Salary:</td><td><input type='text' name='salary' value='" + salary + "'></td></tr>");
        pw.println("<tr><td>Gender:</td><td><input type='text' name='gender' value='" + gender + "'></td></tr>");
        pw.println("<tr><td colspan='2' align='center'><input type='submit' value='Update'></td></tr>");
        pw.println("</table>");
        pw.println("</form>");
        pw.println("</body></html>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int emp_id = Integer.parseInt(req.getParameter("emp_id"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String gender = req.getParameter("gender");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee_management?user=root&password=root");

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE employee SET name=?, address=?, salary=?, gender=? WHERE emp_id=?");

            ps.setString(1, name);
            ps.setString(2, address);
            ps.setDouble(3, salary);
            ps.setString(4, gender);
            ps.setInt(5, emp_id);

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Redirect back to employee list
        res.sendRedirect(req.getContextPath() + "/details");
    }
}
