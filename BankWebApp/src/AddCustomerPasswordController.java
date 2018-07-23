

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankDAO.CustomerDAO;

/**
 * Servlet implementation class AddCustomerPasswordController
 */
@WebServlet("/AddCustomerPasswordController")
public class AddCustomerPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerID = request.getParameter("customerid");
		String customerPassword = request.getParameter("customerpassword");
		
		CustomerDAO customerdao = new CustomerDAO();
		
		String message = null;
		
		if(customerdao.validateCustomerInCustomerPassword(Integer.parseInt(customerID))){
			System.out.println("In validate cus in pass tabe");
			if(!customerdao.updateCustomerPassword(Integer.parseInt(customerID), customerPassword)) {
				 System.out.println("Adding Customer Password Falied");
				 return;
			}
			message = "Successfully Updated Customer Password";
		}
		
		else if(customerdao.validateCustomerID(Integer.parseInt(customerID))) {
			System.out.println("In validate cust id");
			if(!customerdao.addCustomerPassword(Integer.parseInt(customerID), customerPassword)) {
				 System.out.println("Adding Customer Password Falied");
				 return;
			 }
			 message = "Successfully Set Customer Password";
		}
		else {
			System.out.println("all if failed");
			message = "Customer ID Not available";
		}
		
		response.sendRedirect("AddCustomerPassword.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	}

}
