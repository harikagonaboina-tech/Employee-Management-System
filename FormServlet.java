package employee_management_system;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

		String action = req.getParameter("action");

		if("create".equals(action))
		{
			RequestDispatcher rd=req.getRequestDispatcher("createAccount.html");
			rd.forward(req, resp);
		}
		if("login".equals(action))
		{
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.forward(req, resp);
		}
	}
}
