package cpsc2150.mortgages;

/**
 * Created by Zach Lindler and Paul Marcella on 4/11/2020
 */

public class MortgageApp {
    public static void main(String [] args){
        IMortgageView view = new MortgageView();
        IMortgageController controller = new MortgageController(view);
        view.setController(controller);
        controller.submitApplication();
    }
}
