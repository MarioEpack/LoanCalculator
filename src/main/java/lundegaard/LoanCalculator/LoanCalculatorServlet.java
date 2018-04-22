package lundegaard.LoanCalculator;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoanCalculatorServlet
 * @author Mario Alina
 */
@WebServlet("/LoanCalculatorServlet")
public class LoanCalculatorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private int loanSize;
	private int loanTime;
    
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.loanSize = Integer.parseInt(request.getParameter("size"));
		this.loanTime = Integer.parseInt(request.getParameter("time"));
		
		LoanCalculator loanCalc = new LoanCalculator(this.loanSize, this.loanTime);
		double monthlyPayment = loanCalc.getMonthlyPayment();
		
		PrintWriter out = response.getWriter();
		out.println("Monthly Payment of your selected loan would be: " + monthlyPayment + "$.");
	}

}
