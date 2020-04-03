package cpsc2150.mortgages;


//created by Zach Lindler and Paul Marcella on 4/2/2020
public class MortgageController implements IMortgageController{

    IMortgageView view;

    public MortgageController(IMortgageView _view){
        view = _view;
    }

    public void submitApplication(){
        boolean newCustomer = true;
        boolean newMortgage = true;
        int monthsPerYear = 12;

        while(newCustomer) {

            String name = view.getName();

            double income = view.getYearlyIncome();
            while (income <= 0) {
                view.yearlyIncomeError();
                income = view.getYearlyIncome();
            }

            double debt = view.getMonthlyDebt();
            while (debt < 0) {
                view.monthlyDebtError();
                debt = view.getMonthlyDebt();
            }

            int creditScore = view.getCreditScore();
            while (creditScore <= 0 || creditScore >= 850) {
                view.creditScoreError();
                creditScore = view.getCreditScore();
            }

            Customer customer = new Customer(debt, income, creditScore, name);
            newMortgage = true;

            while(newMortgage) {

                double cost = view.getHouseCost();
                while (cost <= 0) {
                    view.houseCostError();
                    cost = view.getHouseCost();
                }

                double downPayment = view.getDownPayment();
                while (downPayment < 0 || downPayment > cost) {
                    view.downPaymentError();
                    downPayment = view.getDownPayment();
                }

                int years = view.getYears();
                while (years < 0) {
                    view.yearsError();
                    years = view.getYears();
                }

                Mortgage mortgage = new Mortgage(cost, downPayment, years, customer);

                view.printToUser(customer.toString());
                view.displayApproved(mortgage.loanApproved());
                if(mortgage.loanApproved()){
                    view.printToUser(mortgage.toString());
                }

                newMortgage = view.getAnotherMortgage();
                if(!newMortgage){
                    newCustomer = view.getAnotherCustomer();
                }
            }
        }
    }
}
