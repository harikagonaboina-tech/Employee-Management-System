package employee_management_system;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EmployeeDetailsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        pw.println("<html><body>");
        pw.println("<h2 align='center'>Employee Details</h2>");

        pw.println("<form method='post' action='EmployeeActionServlet'>");

        pw.println("<table border='1' width='80%' align='center'>");
        pw.println("<tr>");
        pw.println("<th>ID</th><th>Name</th><th>Address</th><th>Salary</th><th>Gender</th>");
        pw.println("</tr>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee_management?user=root&password=root");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employee ORDER BY emp_id");

            while (rs.next()) {
                pw.println("<tr onclick='selectRow(this)'>");
                pw.println("<td>" + rs.getInt("emp_id") + "</td>");
                pw.println("<td>" + rs.getString("name") + "</td>");
                pw.println("<td>" + rs.getString("address") + "</td>");
                pw.println("<td>" + rs.getDouble("salary") + "</td>");
                pw.println("<td>" + rs.getString("gender") + "</td>");
                pw.println("</tr>");
            }

            con.close();
        } catch (Exception e) {
            pw.println("<h3 align='center'>ERROR FETCHING DATA</h3>");
            e.printStackTrace(pw);
        }

        pw.println("</table><br>");

        // Hidden fields for Edit/Delete
        pw.println("<input type='hidden' name='emp_id' id='emp_id'>");
        pw.println("<input type='hidden' name='name' id='name'>");
        pw.println("<input type='hidden' name='address' id='address'>");
        pw.println("<input type='hidden' name='salary' id='salary'>");
        pw.println("<input type='hidden' name='gender' id='gender'>");

        pw.println("<center>");
        pw.println("<button type='submit' name='action' value='edit'>Edit</button>");
        pw.println("<button type='submit' name='action' value='delete'>Delete</button>");
        pw.println("</center>");

        pw.println("</form>");

        // JavaScript to populate hidden fields
        pw.println("<script>");
        pw.println("function selectRow(row){");
        pw.println("document.getElementById('emp_id').value = row.cells[0].innerHTML;");
        pw.println("document.getElementById('name').value = row.cells[1].innerHTML;");
        pw.println("document.getElementById('address').value = row.cells[2].innerHTML;");
        pw.println("document.getElementById('salary').value = row.cells[3].innerHTML;");
        pw.println("document.getElementById('gender').value = row.cells[4].innerHTML;");
        pw.println("}");
        pw.println("</script>");

        pw.println("</body></html>");
    }

    // Forward POST to GET so reload works
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doGet(req, res);
    }
}
