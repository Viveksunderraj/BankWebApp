

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.Branch;
import com.bankDAO.BranchDAO;


@SuppressWarnings("serial")
public class AddBranchController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		 PrintWriter out = response.getWriter();   
		 String branchName = request.getParameter("branchname");
		 String branchAddress = request.getParameter("branchaddress");
		 
		 
		 Branch newBranch = new Branch(branchName, branchAddress);
		 
		 BranchDAO branchdao = new BranchDAO();
		 
		 if(!branchdao.addBranch(newBranch)) {
			 System.out.println("Adding Branch Falied");
			 
		 }
		 
		 response.sendRedirect("Branch.jsp");
	}

}
