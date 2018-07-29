

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.Beneficiary;
import com.bankDAO.BeneficiaryDAO;


@WebServlet("/AddBeneficiaryController")
public class AddBeneficiaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String btype = request.getParameter("beneficiaryType");
		 String beneficiaryAccountNumber = request.getParameter("beneficiaryAccountNumber");
		 String IFSCcode = request.getParameter("IFSCcode");
		 
		 HttpSession session = request.getSession();
		 String stringCustomerID = (String)session.getAttribute("customerid");
		 int customerID = Integer.parseInt(stringCustomerID);
		 int beneficiaryType = Integer.parseInt(btype);
		 String message = null;
		 
		 Beneficiary newBeneficiary = new Beneficiary(customerID, beneficiaryType, Integer.parseInt(beneficiaryAccountNumber), IFSCcode);
			BeneficiaryDAO beneficiarydao = new BeneficiaryDAO();
			if(!beneficiarydao.addBeneficiary(newBeneficiary)) {
				System.out.println("Could not add Beneficiary");
				return;
			}
		message = "Succefully Added Beneficiary!!!";
			
		response.sendRedirect("AddBeneficiary.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	}

}
