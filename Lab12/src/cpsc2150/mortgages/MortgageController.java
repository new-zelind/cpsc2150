package cpsc2150.mortgages;

/**
 * Created by Zach Lindler and Paul Marcella on 4/11/2020
 */

public class MortgageController implements IMortgageController {
    IMortgageView view;

    public MortgageController(IMortgageView _view){
        view = _view;
    }

    public void submitApplication(){
        String name = view.getName();

        double income = view.getYearlyIncome();
        if(income <= 0){
            view.printToUser("Income must be greater than 0.");
            return;
        }

        double debt = view.getMonthlyDebt();
        if(debt < 0){
            view.printToUser("Debt must be greater than or equal to 0.");
            return;
        }

        int creditScore = view.getCreditScore();
        if (creditScore <= 0){
            view.printToUser("Credit Score must be greater than 0.");
            return;
        }
        if(creditScore >= 850){
            view.printToUser("Credit Score must be less than 850.");
            return;
        }


        Customer customer = new Customer(debt, income, creditScore, name);

        double cost = view.getHouseCost();
        if(cost <= 0){
            view.printToUser("Cost must be greater than 0.");
            return;
        }

        double downPayment = view.getDownPayment();
        if(downPayment < 0){
            view.printToUser("Down payment must be greater than 0.");
            return;
        }
        if(downPayment > cost){
            view.printToUser("Down Payment must be less than the cost of the house.");
            return;
        }

        int years = view.getYears();

        Mortgage mortgage = new Mortgage(cost, downPayment, years, customer);

        if(mortgage.loanApproved()){
            view.displayApproved(true);
            view.displayPayment(mortgage.getPayment());
            view.displayRate(mortgage.getRate());
        }
        else{
            view.displayApproved(false);
            view.displayPayment(0);
            view.displayRate(0);
        }

    }
}
