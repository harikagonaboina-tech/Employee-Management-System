package employee_management_system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String username = req.getParameter("un");
        String password = req.getParameter("pw");
        String action = req.getParameter("action");

        if ("create".equals(action)) {
            resp.sendRedirect("createAccount.html");
            return;
        }

        if ("login".equals(action))
        {
	        try
	        {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management?user=root&&password=root");
	            String query = "SELECT * FROM login_credentials WHERE username=? AND password=?";
	            PreparedStatement ps = con.prepareStatement(query);
	
	            ps.setString(1, username);
	            ps.setString(2, password);
	
	            ResultSet rs = ps.executeQuery();
	
	            if(rs.next())
	            {
	            	RequestDispatcher rd = req.getRequestDispatcher("/details");
	                rd.forward(req, resp);
	            }
	            else
	            {
	                resp.getWriter().println("Invalid Login Credentials");
	            }
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
        }
    }
}
