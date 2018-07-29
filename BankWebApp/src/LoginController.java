

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.Customer;
import com.bankDAO.*;

@SuppressWarnings("serial")
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userid");
		String password = request.getParameter("password");
		
		System.out.println(username);
		
		if(username.equals("admin") || username.equals("Admin")) {
			if(password.equals("admin")) {
				
				HttpSession session = request.getSession(); 
				session.setAttribute("customerid", "admin");
				response.sendRedirect("Branch.jsp");
			}
			else {
				
			}
		}
		else {
			CustomerDAO customerdao = new CustomerDAO();
			if(!customerdao.validateCustomerPassword(Integer.parseInt(username), password)) {
				
				request.setAttribute("message", "Invalid Username/Password");
				RequestDispatcher rd = request.getRequestDispatcher("CustomerLogin.jsp");
				rd.forward(request, response);
			}
			else {
			Customer logginCustomer = customerdao.getCustomerDetails(Integer.parseInt(username));
			
			HttpSession session = request.getSession(); 
			session.setAttribute("customerid", username);
			session.setAttribute("customerfname", logginCustomer.getCustomerFirstName());
			session.setAttribute("customerlname", logginCustomer.getCustomerLastName());
			
			response.sendRedirect("CustomerDashboard.jsp");
			}
		}
		
	}

}
