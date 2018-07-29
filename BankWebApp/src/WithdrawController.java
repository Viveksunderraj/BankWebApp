

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.Withdraw;


@WebServlet("/WithdrawController")
public class WithdrawController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountNumber = request.getParameter("Accountnumber");
		String amount = request.getParameter("amount");
		String description = request.getParameter("description");
		
		HttpSession session = request.getSession();
		String customerID = (String)session.getAttribute("customerid");
		
		int transactionAccountNumber1 = Integer.parseInt(accountNumber);		
		double transactionAmount = Double.parseDouble(amount);
		double accountBalance = 0;
		int transactionAccountNumber2 = 0, transactionSubType = 0, transactionType = 2;
		String message = null;
		
		Withdraw newWithdrawal = new Withdraw(transactionAmount, accountBalance, Integer.parseInt(customerID), transactionAccountNumber1, transactionAccountNumber2, transactionType, transactionSubType, null, description);
		if(!newWithdrawal.withDraw()) {
			System.out.println("WithDraw Failed !!!!!!");
			return;
		}
		message = "Succefully Withdrawed!!!";
		
		response.sendRedirect("Withdraw.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		
		
	}

}
