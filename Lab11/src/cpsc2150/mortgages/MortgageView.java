package cpsc2150.mortgages;

import java.util.*;
//created by Zach Lindler and Paul Marcella on 4/2/2020

public class MortgageView implements IMortgageView {
    private Scanner scanner;
    private IMortgageController controller;

    public MortgageView(){
        scanner = new Scanner(System.in);
    }

    public void setController(IMortgageController c){
        controller = c;
    }

    public double getHouseCost(){
        System.out.println("How much does the house cost?");
        return scanner.nextDouble();
    }

    public void houseCostError(){
        System.out.println("Cost must be greater than 0.");
    }

    public double getDownPayment(){
        System.out.println("How much is the down payment?");
        return scanner.nextDouble();
    }

    public void downPaymentError(){
        System.out.println("Down payment must be greater than 0 and less than the cost of the house.");
    }

    public int getYears(){
        System.out.println("How many years?");
        return scanner.nextInt();
    }

    public void yearsError(){
        System.out.println("Years must be greater than 0.");
    }

    public double getMonthlyDebt(){
        System.out.println("How much are your monthly debt payments?");
        return scanner.nextDouble();
    }

    public void monthlyDebtError(){
        System.out.println("Debt must be greater than or equal to 0.");
    }

    public double getYearlyIncome(){
        System.out.println("How much is your yearly income?");
        return scanner.nextDouble();
    }

    public void yearlyIncomeError(){
        System.out.println("Income must be greater than 0.");
    }

    public int getCreditScore(){
        System.out.println("What is your credit score?");
        return scanner.nextInt();
    }

    public void creditScoreError(){
        System.out.println("Credit score must be greater than 0 and less than 850.");
    }

    public String getName(){
        System.out.println("What's your name?");
        String toReturn = scanner.next();
        scanner.nextLine();
        return toReturn;
    }

    public void printToUser(String s){
        System.out.print(s);
    }

    public void displayPayment(double p){
        System.out.println("Monthly Payment: " + p);
    }

    public void displayRate(double r){
        System.out.println("Interest Rate: " + r + "%");
    }

    public void displayApproved(boolean a){
        if(a) System.out.println("Loan approved.");
        else System.out.println("Loan denied.");
    }

    public boolean getAnotherMortgage(){
        System.out.println("Would you like to apply for another mortgage? Y/N");
        String choice = scanner.next();
        while(!choice.toLowerCase().equals("n") && !choice.toLowerCase().equals("y")){
            System.out.println("Would you like to apply for another mortgage? Y/N");
            //scanner.nextLine();
            choice = scanner.next();
        }
        return choice.toLowerCase().equals("y");
    }

    public boolean getAnotherCustomer(){
        System.out.println("Would you like to consider another customer? Y/N");
        String choice = scanner.next();
        while(!choice.toLowerCase().equals("n") && !choice.toLowerCase().equals("y")){
            System.out.println("Would you like to consider another customer? Y/N");
            scanner.nextLine();
            choice = scanner.next();
        }
        return choice.toLowerCase().equals("y");
    }
}
