package cpsc2150.banking;

/**
 * Created by Paul Marcella and Zach Lindler on 2/27/20.
 */
public class Mortgage extends AbsMortgage{

  private int monthPerYear = 12;
  private double cost;
  private double downPayment;
  private int years;
  private ICustomer customer;

    /**
     *
     * @return Decimal value of down over cost
     * @pre cost > 0
     * @post percentDown = percent down
     */
  private double percentDown() { return (downPayment/cost); }

    /**
     *
     * @return Number of payments required to pay the full cost
     * @pre getPayment > 0
     * @post getNumberOfPayments = number of payments
     */
  private int getNumberOfPayments() { return years * monthPerYear ; }

    /**
     *
     * @return The amount of debt as a percentage of income
     * @pre income > 0
     * @post getDebtRatio = debt income ratio
     */
  private double getDebtRatio(){
      double income = customer.getIncome() / monthPerYear;
      double debt = customer.getMonthlyDebtPayments() + getPayment();

      return (debt / income);
  }

    /**
     *
     * @param homeCost The total cost of the house
     * @param down The original payment by the customer
     * @param numYears Number of years to pay the total cost
     * @param Customer The customer that is purchasing
     * @requires homeCost > 0 and down >= 0 and numYears > 0 and Customer != NULL
     * @ensures cost = homeCost and downPayment = down and years = numYears and customer = Customer
     */
    public Mortgage(double homeCost, double down, int numYears, ICustomer Customer){
        cost = homeCost;
        downPayment = down;
        years = numYears;
        customer = Customer;
    }

    public boolean loanApproved(){
        if((getRate()) >= RATETOOHIGH)
            return false;
        if(percentDown() < MIN_PERCENT_DOWN)
            return false;
        if(getDebtRatio() > DTOITOOHIGH)
            return false;

        return true;
    }

    public double getPayment(){
        double payment = ((getRate() / monthPerYear) * getPrincipal()) / (1 - Math.pow((1 + (getRate() / monthPerYear)), -(getNumberOfPayments())));
        return payment;
    }

    public double getRate(){
        double Rate = BASERATE;
        if(years < MAX_YEARS) {Rate += GOODRATEADD;}
        else {Rate += NORMALRATEADD;}

        if(percentDown() < PREFERRED_PERCENT_DOWN) {Rate += GOODRATEADD;}

        int creditScore = customer.getCreditScore();
        if(creditScore < BADCREDIT){Rate += VERYBADRATEADD;}
        else if(creditScore >= BADCREDIT && creditScore < FAIRCREDIT) {Rate += BADRATEADD;}
        else if(creditScore >= FAIRCREDIT && creditScore < GOODCREDIT) {Rate += NORMALRATEADD;}
        else if(creditScore >= GOODCREDIT && creditScore < GREATCREDIT) {Rate += GOODRATEADD;}

        return Rate;
    }

    public double getPrincipal(){
        return (cost - downPayment);
    }

    public int getYears(){
        return years;
    }
}
