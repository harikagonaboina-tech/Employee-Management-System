package employee_management_system;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EmployeeActionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        String action = req.getParameter("action");
        String empIdStr = req.getParameter("emp_id");

        // Check if a row was selected
        if (empIdStr == null || empIdStr.isEmpty()) {
            pw.println("<html><body>");
            pw.println("<h3 style='color:red; text-align:center;'>Please select a row first!</h3>");
            pw.println("<center><a href='" + req.getContextPath() + "/details'>Back to Employee List</a></center>");
            pw.println("</body></html>");
            return;
        }

        int emp_id = Integer.parseInt(empIdStr);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee_management?user=root&password=root");

            if ("delete".equals(action)) {
                PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE emp_id=?");
                ps.setInt(1, emp_id);
                ps.executeUpdate();
                con.close();

                // Redirect back to details page after deletion
                res.sendRedirect(req.getContextPath() + "/details");
                return;

            } else if ("edit".equals(action)) {
                // Redirect to UpdateEmployeeServlet with all parameters
                String redirectURL = req.getContextPath() + "/UpdateEmployeeServlet?emp_id=" + emp_id
                        + "&name=" + req.getParameter("name")
                        + "&address=" + req.getParameter("address")
                        + "&salary=" + req.getParameter("salary")
                        + "&gender=" + req.getParameter("gender");

                con.close();
                res.sendRedirect(redirectURL);
                return;
            }

        } catch (Exception e) {
            pw.println("<h3 style='color:red; text-align:center;'>Error processing request!</h3>");
            e.printStackTrace(pw);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}
