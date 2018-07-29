

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.Account;
import com.bank.Customer;
import com.bankDAO.AccountDAO;
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
		String customerPassword = request.getParameter("customerpassword");
		
		String branchID = request.getParameter("Branchid");
		String accountType = request.getParameter("Accounttype");
		
		
		
		
		Customer newCustomer = new Customer(customerFName, customerLName, customerAddress, customerPhoneNumber, customerDateOfBirth);
		CustomerDAO customerdao = new CustomerDAO();
		
		int customerID = customerdao.addCustomer(newCustomer);
		
		if(customerID == 0) {
			 System.out.println("Adding Customer Falied");
			 return;
		 }
		
		if(!customerdao.addCustomerPassword(customerID, customerPassword)) {
			 System.out.println("Adding Customer Password Falied");
			 return;
		 }
		
		double accountBalance = 0;
		
		
		if(accountType.equals("1")) {
			accountBalance = 1000;
		}
		
		 Account newAccount = new Account(Integer.parseInt(branchID), customerID, Integer.parseInt(accountType), accountBalance);
		 AccountDAO accountdao = new AccountDAO();
		 
		 if(!accountdao.addcustomerAccount(newAccount)) {
			 System.out.println("Account Creation failure!!");
			 return;
		 }
		
		String message = "Successfully Added Customer";
		response.sendRedirect("AddCustomer.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		
	}

}
