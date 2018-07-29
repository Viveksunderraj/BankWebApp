

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.Deposit;
import com.bank.Withdraw;


@WebServlet("/TransferBetweenAccountsController")
public class TransferBetweenAccountsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fromAccountNumber = request.getParameter("FromAccountnumber");
		String ToAccountNumber = request.getParameter("ToAccountnumber");
		String amount = request.getParameter("amount");
		String description = request.getParameter("description");
		
		HttpSession session = request.getSession();
		String stringCustomerID = (String)session.getAttribute("customerid");
		int customerID = Integer.parseInt(stringCustomerID);
		
		int transactionAccountNumber1 = Integer.parseInt(fromAccountNumber);		
		int transactionAccountNumber2 = Integer.parseInt(ToAccountNumber);
		
		double transactionAmount = Double.parseDouble(amount);
		double accountBalance = 0;
		int transactionSubType = 0, transactionType = 3;
		
		String message = null;
		
		String description1 = description +" TR.To A\\c No: " + transactionAccountNumber2;
		String description2 = description +" TR.From A\\c No: " + transactionAccountNumber1;

		transactionSubType = 2;
		Withdraw transferWithdrawal = new Withdraw(transactionAmount, accountBalance, customerID, transactionAccountNumber1, transactionAccountNumber2, transactionType, transactionSubType, null, description1);
		if(!transferWithdrawal.withDraw()) {
			System.out.println("Transfer Failed !!!!!!");
			return;
		}
		
		transactionSubType = 1;
		description2 = description +" TR.From A\\c No: " + transactionAccountNumber1;
		Deposit transferDeposit = new Deposit(transactionAmount, accountBalance, customerID, transactionAccountNumber2, transactionAccountNumber1, transactionType, transactionSubType, null, description2);
		if(!transferDeposit.deposit()) {
			System.out.println("Transfer Failed !!!!!!");
			return;
		}
		
		message = "Succefully Transfered!!!";
		
		response.sendRedirect("TransferBetweenAccounts.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		

	}

}
