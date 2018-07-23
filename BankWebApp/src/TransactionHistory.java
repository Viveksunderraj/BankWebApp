

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.Transaction;
import com.bank.TransactionReportHeader;
import com.bankDAO.TransactionDAO;


@WebServlet("/TransactionHistory")
public class TransactionHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String customerID = (String)session.getAttribute("customerid");
		String branchID = (String)session.getAttribute("branchid");
		String accountNumber = request.getParameter("Accountnumber");
		
		TransactionDAO transactiondao = new TransactionDAO();
		
		TransactionReportHeader transactionReportHeader = transactiondao.getTransactionHeader(Integer.parseInt(accountNumber));
		
		ArrayList<Transaction> transactionHistory = transactiondao.getTransactionHistory(Integer.parseInt(customerID), Integer.parseInt(accountNumber), Integer.parseInt(branchID));
		
		
		request.setAttribute("transactionReportHeader", transactionReportHeader);
		request.setAttribute("transactionHistory", transactionHistory);
		
		RequestDispatcher rd = request.getRequestDispatcher("TransactionHistory.jsp");
		rd.forward(request, response);
	}

}
