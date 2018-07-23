

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.Account;
import com.bankDAO.AccountDAO;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String branchID = request.getParameter("Branchid");
		String customerID = request.getParameter("Customerid");
		String accountType = request.getParameter("Accounttype");
		double accountBalance = 0;
		
		String message = null;
		
		if(accountType.equals("1")) {
			accountBalance = 1000;
		}
		
		 Account newAccount = new Account(Integer.parseInt(branchID), Integer.parseInt(customerID), Integer.parseInt(accountType), accountBalance);
		 AccountDAO accountdao = new AccountDAO();
		 
		 if(!accountdao.addcustomerAccount(newAccount)) {
			 System.out.println("Account Creation failure!!");
			 return;
		 }
		message = "Succefully Created Account";
		response.sendRedirect("CreateAccount.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	}

}
