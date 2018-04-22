package lundegaard.LoanCalculator;

import org.apache.log4j.Logger;
import org.junit.Before;

import org.junit.Test;

public class LoanCalculatorTest {


	LoanCalculator testCalc;
	private static final Logger log = Logger.getLogger(LoanCalculatorTest.class);

		
	@Before
	public void setUp() throws Exception {
		this.testCalc = new LoanCalculator(1000, 12);
		
		log.info(testCalc);
	}

	@Test
	public void shouldBeEqual() {
		this.testCalc.setInterestRate(12);
		assert(testCalc.getMonthlyPayment() == 88.85);
	}
	

}
