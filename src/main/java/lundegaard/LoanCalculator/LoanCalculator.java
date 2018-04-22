package lundegaard.LoanCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoanCalculator {

	
    private double loan;
    private double interestRate;
    private double monthlyRate;
    private int timePeriod; // in months

    
    public LoanCalculator(double loan, int timePeriod) {
        this.loan = loan;
        this.timePeriod = timePeriod;

        // Default interestRate
        this.interestRate = 12.0;
        // Convert interest rate into a decimal
        this.interestRate /= 100.0;
        this.calculateMonthlyRate();
    }

    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "LoanCalculator [loan=" + loan + ", interestRate=" + interestRate + ", monthlyRate=" + monthlyRate
                + ", timePeriod=" + timePeriod + ", monthlyPayment=" + this.getMonthlyPayment() + "]";
    }

    
    /**
     * @return the loan
     */
    public double getLoan() {
        return loan;
    }

    
    /**
     * @param loan
     *            the loan to set
     */
    public void setLoan(double loan) {
        this.loan = loan;
    }

    
    /**
     * @return the interestRate
     */
    public double getInterestRate() {
        return interestRate;
    }

    
    /**
     * @param interestRate
     *            the interestRate to set
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    
    /**
     * @return the timePeriod
     */
    public int getTimePeriod() {
        return timePeriod;
    }

    
    /**
     * @param timePeriod
     *            the timePeriod to set
     */
    public void setTimePeriod(int timePeriod) {
        this.timePeriod = timePeriod;
    }

    
    /**
     * @return Monthly payment for the specified loan
     */
    public double getMonthlyPayment() {
        double MonthlyPayment = (this.loan * this.monthlyRate)
                / (1 - Math.pow(1 + monthlyRate, -this.timePeriod));
        return new BigDecimal(MonthlyPayment).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    
    private void calculateMonthlyRate() {
        this.monthlyRate = this.interestRate / 12.0;
    }

}


