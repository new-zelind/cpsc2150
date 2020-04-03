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
                view.printToUser("Income must be greater than 0.\n");
                income = view.getYearlyIncome();
            }

            double debt = view.getMonthlyDebt();
            while (debt < 0) {
                view.printToUser("Debt must be greater than or equal to 0.\n");
                debt = view.getMonthlyDebt();
            }

            int creditScore = view.getCreditScore();
            while (creditScore <= 0 || creditScore >= 850) {
                view.printToUser("Credit score must be greater than 0 and less than 850.\n");
                creditScore = view.getCreditScore();
            }

            Customer customer = new Customer(debt, income, creditScore, name);
            newMortgage = true;

            while(newMortgage) {

                double cost = view.getHouseCost();
                while (cost <= 0) {
                    view.printToUser("Cost must be greater than 0.\n");
                    cost = view.getHouseCost();
                }

                double downPayment = view.getDownPayment();
                while (downPayment < 0 || downPayment > cost) {
                    view.printToUser("Down payment must be greater than 0 and less than the cost of the house.\n");
                    downPayment = view.getDownPayment();
                }

                int years = view.getYears();
                while (years < 0) {
                    view.printToUser("Years must be greater than 0.\n");
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
