package employee_management_system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAccountServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
    	String action = req.getParameter("action");

        if ("login".equals(action)) {
            resp.sendRedirect("login.html");
            return;
        }

        if ("submit".equals(action))
        {
	        String id = req.getParameter("id");
	        String name = req.getParameter("en");
	        String address = req.getParameter("ad");
	        String salary = req.getParameter("sal");
	        String gender = req.getParameter("gn");
	        String username = req.getParameter("un");
	        String password = req.getParameter("pw");
	        
	        String empQuery ="INSERT INTO employee (emp_id, name, address, salary, gender) VALUES (?,?,?,?,?)";
	        String loginQuery ="INSERT INTO login_credentials (username, password) VALUES (?,?)";
	        
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management?user=root&&password=root");
				PreparedStatement ps1 = con.prepareStatement(empQuery);
				ps1.setString(1, id);
				ps1.setString(2, name);
				ps1.setString(3, address);
				ps1.setDouble(4, Double.parseDouble(salary));
				ps1.setString(5, gender);
				ps1.executeUpdate();
				PreparedStatement ps2 = con.prepareStatement(loginQuery);
				ps2.setString(1, username);
				ps2.setString(2, password);
				ps2.executeUpdate();
			
				RequestDispatcher rd = req.getRequestDispatcher("/form.html");
                rd.forward(req, resp);
	        } catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}
