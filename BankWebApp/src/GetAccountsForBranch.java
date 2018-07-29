

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.Account;
import com.bankDAO.AccountDAO;


@WebServlet("/GetAccountsForBranch")
public class GetAccountsForBranch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String branchID = request.getParameter("Branchid");
		HttpSession session = request.getSession();
		String customerID = (String)session.getAttribute("customerid");
		
		//session.setAttribute("branchid", branchID);
		
		ArrayList<Account> accountList = AccountDAO.getAccountsForCustomer(Integer.parseInt(customerID), Integer.parseInt(branchID));
		
		request.setAttribute("accountList", accountList);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("CustomerAccounts.jsp");
		rd.include(request, response);

	}

}
