

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.Customer;
import com.bankDAO.CustomerDAO;

/**
 * Servlet implementation class AddCustomerController
 */
@WebServlet("/AddCustomerController")
public class AddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerFName = request.getParameter("customerfname");
		String customerLName = request.getParameter("customerlname");
		String customerAddress = request.getParameter("customeraddress");
		String customerPhoneNumber = request.getParameter("customerphonenumber");
		String customerDateOfBirth = request.getParameter("dateofbirth");
		
		Customer newCustomer = new Customer(customerFName, customerLName, customerAddress, customerPhoneNumber, customerDateOfBirth);
		CustomerDAO customerdao = new CustomerDAO();
		if(!customerdao.addCustomer(newCustomer)) {
			 System.out.println("Adding Customer Falied");
			 return;
		 }
		String message = "Successfully Added Customer";
		response.sendRedirect("AddCustomer.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		
	}

}
