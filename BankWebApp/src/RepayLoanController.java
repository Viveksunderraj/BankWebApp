

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.Deposit;


@WebServlet("/RepayLoan")
public class RepayLoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountNumber = request.getParameter("Accountnumber");
		String amount = request.getParameter("amount");
		String description = request.getParameter("description");
		
		HttpSession session = request.getSession();
		String stringCustomerID = (String)session.getAttribute("customerid");
		int customerID = Integer.parseInt(stringCustomerID);
		
		int transactionAccountNumber1 = Integer.parseInt(accountNumber);		
		int transactionAccountNumber2 = 0;
		
		double transactionAmount = Double.parseDouble(amount);
		double accountBalance = 0;
		int transactionSubType = 0, transactionType = 7;
		
		String message = null;
		Deposit repayLoanDeposit = new Deposit(transactionAmount, accountBalance, customerID,transactionAccountNumber1, transactionAccountNumber2, transactionType, transactionSubType, null, description);
		if(!repayLoanDeposit.deposit()) {
			System.out.println("Repay Failed !!!!!!");
			return;
		}
		message ="Repay Success !!!!!!";
		response.sendRedirect("RepayLoan.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	}

}
