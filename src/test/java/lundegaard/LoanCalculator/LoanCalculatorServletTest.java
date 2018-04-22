package lundegaard.LoanCalculator;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoanCalculatorServletTest extends Mockito {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String POSTMSG = "Monthly Payment of your selected loan is: 88.85$.";
	
	@Before
	public void setUp() throws Exception {
		this.request = mock(HttpServletRequest.class);
		this.response = mock(HttpServletResponse.class);
	}

	@Test
	public void testMonthlyPayment() throws IOException, ServletException {
		when(request.getParameter("size")).thenReturn("1000");
	    when(request.getParameter("time")).thenReturn("12");
	    
	    
	    StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    	         
	    when(response.getWriter()).thenReturn(pw);
	    
	    LoanCalculatorServlet servlet = new LoanCalculatorServlet();
	    servlet.doPost(request, response);
	    
	    String result = sw.getBuffer().toString().trim();
	 // TO DO, rework this test   
	    
	    assertEquals(result, this.POSTMSG);
	    
	   
	}

}
