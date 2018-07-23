

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.Deposit;


@WebServlet("/Deposit")
public class DepositController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String accountNumber = request.getParameter("Accountnumber");
		String amount = request.getParameter("amount");
		String description = request.getParameter("description");
		
		HttpSession session = request.getSession();
		String customerID = (String)session.getAttribute("customerid");
		String branchID = (String)session.getAttribute("branchid");
		
		int transactionAccountNumber1 = Integer.parseInt(accountNumber);		
		double transactionAmount = Double.parseDouble(amount);
		double accountBalance = 0;
		int transactionAccountNumber2 = 0, transactionSubType = 0, transactionType = 1;
		
		String message = null;
		
		Deposit newDeposit = new Deposit(transactionAmount, accountBalance, Integer.parseInt(customerID), Integer.parseInt(branchID),transactionAccountNumber1, transactionAccountNumber2, transactionType, transactionSubType, null, description);
		if(!newDeposit.deposit()) {
			System.out.println("Deposit Failed !!!!!!");
			return;
		}
		
		message = "Succefully Deposited!!!";
		
		response.sendRedirect("Deposit.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		
		
	}

}
