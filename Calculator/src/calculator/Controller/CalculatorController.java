package calculator.Controller;

import calculator.MenuData.ActionMenu;
import calculator.MenuData.ActionMenuItem;
import calculator.MenuData.MenuItem;
import calculator.View.CalculatorView;
import calculator.Model.CalculatorModel;
import calculator.View.Screen.Screen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The Controller coordinates interactions
// between the View and Model
public class CalculatorController {

    private CalculatorView theView;
    private CalculatorModel theModel;

    public CalculatorController(CalculatorView theView, CalculatorModel theModel) {

        this.theModel = theModel;
        this.theView = theView;

    }

}
