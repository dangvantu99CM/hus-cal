package calculator.View;

import GetTime.TimeSystem;
import calculator.MenuData.ActionMenu;
import calculator.MenuData.ActionMenuItem;
import calculator.MenuData.MenuData;
import calculator.MenuData.MenuItem;
import calculator.Model.CalculatorModel;
import calculator.View.HeaderComponent.HeaderComponent;
import calculator.View.Help.Help;
import calculator.View.MainComponent.MainComponent;
import calculator.View.Screen.Screen;
import calculator.View.StoreHistory.History;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridBagLayout;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author tudv
 */
public class CalculatorView extends JFrame {

    public ActionMenu actionMenu = new ActionMenu();
    private MenuData menuData = new MenuData(actionMenu);

    public String expression_By_User = "";
    public Screen scr = new Screen();
    public double result = 0.0;
    public CalculatorModel calModel = new CalculatorModel();

    public int countEnter = 0;
    public StringBuilder[] arr_he_so = null;

    public StringBuilder[][] A = null;
    public StringBuilder[][] B = null;

    public boolean isClickedAddMatrix = false;
    public boolean isClickedMultyMatrix = false;
    public boolean isClickedEnter = false;
    public boolean isClicked_GPT = false;
    public boolean isClicked_matrix = false;
    
    private History history = new History();
    
    private TimeSystem timeSystem = new TimeSystem();

    //public StringBuilder[][] B = null;
    public CalculatorView() {
        initFrame();
        this.setVisible(true);
    }

    public void initFrame() {
        this.setLayout(new BorderLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.pack();
        //this.setLocation(250, 50);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setTitle("HUS CALCULATOR");

        actionMenu.click_number_0 = click_number_0;
        actionMenu.click_number_1 = click_number_1;
        actionMenu.click_number_2 = click_number_2;
        actionMenu.click_number_3 = click_number_3;
        actionMenu.click_number_4 = click_number_4;
        actionMenu.click_number_5 = click_number_5;
        actionMenu.click_number_6 = click_number_6;
        actionMenu.click_number_7 = click_number_7;
        actionMenu.click_number_8 = click_number_8;
        actionMenu.click_number_9 = click_number_9;

        actionMenu.click_add_button = click_add_button;
        actionMenu.click_divide_button = click_divide_button;
        actionMenu.click_open_parent_button = click_open_parent_button;
        actionMenu.click_close_parent_button = click_close_parent_button;
        actionMenu.click_point_button = click_point_button;
        actionMenu.click_percent_button = click_percent_button;
        actionMenu.click_subtract_button = click_subtract_button;
        actionMenu.click_ac_button = click_ac_button;
        actionMenu.click_equal_button = click_equal_button;
        actionMenu.click_multyply_button = click_multyply_button;

        actionMenu.click_PI_button = click_PI_button;
        actionMenu.click_number_e_button = click_number_e_button;
        actionMenu.click_percent_button = click_percent_button;
        actionMenu.click_ans_button = click_ans_button;
        actionMenu.click_factory_button = click_factory_button;
        actionMenu.click_sin_button = click_sin_button;
        actionMenu.click_sin_button = click_sin_button;
        actionMenu.click_cos_button = click_cos_button;
        actionMenu.click_tan_button = click_tan_button;
        actionMenu.click_ln_button = click_ln_button;
        actionMenu.click_log_button = click_log_button;
        actionMenu.click_sqrt_button = click_sqrt_button;
        actionMenu.click_1_x = click_1_x;

        actionMenu.click_ptb1 = click_ptb1;
        actionMenu.click_ptb2 = click_ptb2;
        actionMenu.click_ptb3 = click_ptb3;

        actionMenu.click_tro_giup = click_tro_giup;
        actionMenu.click_lich_su = click_lich_su;

        actionMenu.click_enter = click_enter;
        actionMenu.click_solve = click_solve;
        
        actionMenu.click_del_button = click_del_button;

        // matrix
        actionMenu.click_multy_matrix_22 = click_multy_matrix_22;
        actionMenu.click_multy_matrix_33 = click_multy_matrix_33;
        actionMenu.click_multy_matrix_1221 = click_multy_matrix_1221;
        actionMenu.click_multy_matrix_2112 = click_multy_matrix_2112;
        actionMenu.click_multy_matrix_2332 = click_multy_matrix_2332;
        actionMenu.click_multy_matrix_3223 = click_multy_matrix_3223;
        actionMenu.click_multy_matrix_1331 = click_multy_matrix_1331;
        actionMenu.click_multy_matrix_3113 = click_multy_matrix_3113;
        actionMenu.click_add_matrix_22 = click_add_matrix_22;
        actionMenu.click_add_matrix_33 = click_add_matrix_33;
        
        

        this.setJMenuBar(new HeaderComponent(menuData));
        this.add(scr, BorderLayout.CENTER);
        this.add(new MainComponent(actionMenu), BorderLayout.PAGE_END);
    }

    public void _resetStatusButton() {
        isClicked_GPT = false;
        isClicked_matrix = false;
        isClickedAddMatrix = false;
        isClickedMultyMatrix = false;
        isClickedEnter = false;
        isClickedMultyMatrix = false;
        isClickedAddMatrix = false;
    }

    public void resetScreen() {
        expression_By_User = "";
        scr.taxt.setText(expression_By_User);
        scr.taxtResult.setText("");
    }

    ActionMenuItem click_number_0 = new ActionMenuItem() {
        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_number_1 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_number_2 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_number_3 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_number_4 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_number_5 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_number_6 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_number_7 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_number_8 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_number_9 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_add_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_multyply_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_divide_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_subtract_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_equal_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                return;
            }
            if (expression_By_User == "" || expression_By_User == null) {
                displayErrorMessage("Hãy nhập biểu thức cần tính toán !");
                return;
            }
            if (!calModel.isValidExpr(expression_By_User)) {
                displayErrorMessage("Biểu thức không hợp lệ !");
                return;
            }
            try {
                result = calModel.evalJs(expression_By_User);
                scr.taxtResult.setText(String.valueOf(result));
                String time=  timeSystem.getTimeInSystem()+ " " + timeSystem.getDateInSystem();
                history.stack.push(new History(scr.taxt.getText(), scr.taxtResult.getText(),time));
                while (!calModel.listResultQueue.isEmpty()) {
                    calModel.listResultQueue.dequeue();
                }
                calModel.listResultQueue.enqueue(String.valueOf(result));
                calModel.listResultQueue._iterator();

            } catch (ScriptException ex) {
                Logger.getLogger(CalculatorView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(CalculatorView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    ActionMenuItem click_ac_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            resetScreen();
            _resetStatusButton();
        }
    };

    ActionMenuItem click_percent_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_point_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_open_parent_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_close_parent_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text);
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_PI_button = new ActionMenuItem() {
        String pi = String.valueOf(Math.PI);

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(pi);
            } else {
                expression_By_User += pi;
                scr.taxt.setText(expression_By_User);
            }
        }
    };
    
    ActionMenuItem click_1_x = new ActionMenuItem() {
       
        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so("1/");
            } else {
                expression_By_User += "1/";
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_number_e_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            String e = String.valueOf(Math.E);
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(e);
            } else {
                expression_By_User += e;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_ans_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            expression_By_User = calModel.getHistoryAnswer();
            if (!isClicked_GPT && !isClicked_matrix) {
                scr.taxt.setText(expression_By_User);
                while (!calModel.listResultQueue.isEmpty()) {
                    calModel.listResultQueue.dequeue();
                }
                calModel.listResultQueue.enqueue(String.valueOf(expression_By_User));
                calModel.listResultQueue._iterator();
            }
        }
    };

    ActionMenuItem click_factory_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            String giai_thua = "!";
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(giai_thua);
            } else {
                expression_By_User += giai_thua;
                scr.taxt.setText(expression_By_User);
            }
        }
    };
    
    ActionMenuItem click_lich_su = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            history.run();
            
        }
    };

    ActionMenuItem click_sin_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text + "(");
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_cos_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text + "(");
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_tan_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text + "(");
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_ln_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text + "(");
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_log_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text + "(");
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };

    ActionMenuItem click_sqrt_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (isClicked_GPT || isClicked_matrix) {
                set_he_so(menuItem.text + "(");
            } else {
                expression_By_User += menuItem.text;
                scr.taxt.setText(expression_By_User);
            }
        }
    };
    
    ActionMenuItem click_del_button = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            System.out.println("ppppppppppp " );
//            if (isClicked_GPT || isClicked_matrix) {
//                set_he_so(menuItem.text + "(");
//            } else {
//                expression_By_User += menuItem.text;
//                scr.taxt.setText(expression_By_User);
//            }
        }
    };

    ActionMenuItem click_solve = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            if (!isClicked_GPT && !isClicked_matrix) {
                return;
            } else {
                if (isClicked_GPT) {
                    if (countEnter == 1) {
                        try {
                            String result = calModel.giai_pt_1(arr_he_so);
                            scr.taxtResult.append(result);
                        } catch (ScriptException ex) {
                            Logger.getLogger(CalculatorView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (countEnter == 2) {
                        try {
                            String result = calModel.giai_pt_2(arr_he_so);
                            scr.taxtResult.append(result);
                        } catch (ScriptException ex) {
                            Logger.getLogger(CalculatorView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (countEnter == 3) {
                        try {
                            String result = calModel.giai_pt_3(arr_he_so);
                            scr.taxtResult.append(result);
                        } catch (ScriptException ex) {
                            Logger.getLogger(CalculatorView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if (isClicked_matrix) {
                    if (countEnter == (A.length * A[0].length + B.length * B[0].length - 1)) {
                        if (isClickedAddMatrix) {
                            System.out.println("ssssssssssssssssss ==================");
                            try {
                                double[][] resultMatrix = calModel.addMatrix(A, B);
                                for (int i = 0; i < resultMatrix.length; i++) {
                                    for (int j = 0; j < resultMatrix[0].length; j++) {
                                        scr.taxtResult.append(String.valueOf(resultMatrix[i][j]) + "  ");
                                    }
                                    scr.taxtResult.append("\n");
                                }
                            } catch (ScriptException ex) {
                                Logger.getLogger(CalculatorView.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if (isClickedMultyMatrix) {
                            try {
                                double[][] resultMatrix = calModel.multyMatrix(A, B);
                                for (int i = 0; i < resultMatrix.length; i++) {
                                    for (int j = 0; j < resultMatrix[0].length; j++) {
                                        scr.taxtResult.append(String.valueOf(resultMatrix[i][j]) + "  ");
                                    }
                                    scr.taxtResult.append("\n");
                                }
                            } catch (ScriptException ex) {
                                Logger.getLogger(CalculatorView.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }
        }
    };

    public void printMatrix(StringBuilder[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j].toString() + " ");
            }
            System.out.println("");
        }
    }

    ActionMenuItem click_ptb1 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            setArrHeSo(2);
        }
    };

    ActionMenuItem click_ptb2 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            setArrHeSo(3);
        }
    };
    ActionMenuItem click_ptb3 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            setArrHeSo(4);
        }
    };

    // matrix
    ActionMenuItem click_multy_matrix_22 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            isClickedMultyMatrix = true;
            isClickedAddMatrix = !isClickedMultyMatrix;
            setTextScreenMatrix(menuItem.text);
        }
    };

    ActionMenuItem click_multy_matrix_33 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            isClickedMultyMatrix = true;
            isClickedAddMatrix = !isClickedMultyMatrix;
            setTextScreenMatrix(menuItem.text);
        }
    };

    ActionMenuItem click_multy_matrix_1221 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
            isClickedMultyMatrix = true;
            isClickedAddMatrix = !isClickedMultyMatrix;
            setTextScreenMatrix(menuItem.text);
            System.out.println("Aaaaaaaaaaaaaaaaa + " + "row " + A.length + "col" + A[0].length);
            System.out.println("bbbbbbbbbbbbbbb + " + "row " + B.length + "col" + B[0].length);
        }
    };

    ActionMenuItem click_multy_matrix_2112 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            isClickedMultyMatrix = true;
            isClickedAddMatrix = !isClickedMultyMatrix;
            setTextScreenMatrix(menuItem.text);
        }
    };

    ActionMenuItem click_multy_matrix_2332 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            isClickedMultyMatrix = true;
            isClickedAddMatrix = !isClickedMultyMatrix;
            setTextScreenMatrix(menuItem.text);
        }
    };

    ActionMenuItem click_multy_matrix_3223 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            isClickedMultyMatrix = true;
            isClickedAddMatrix = !isClickedMultyMatrix;
            setTextScreenMatrix(menuItem.text);
        }
    };

    ActionMenuItem click_multy_matrix_1331 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            System.out.println("1331");
            isClickedMultyMatrix = true;
            isClickedAddMatrix = !isClickedMultyMatrix;
            setTextScreenMatrix(menuItem.text);
        }
    };

    ActionMenuItem click_multy_matrix_3113 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            isClickedMultyMatrix = true;
            isClickedAddMatrix = !isClickedMultyMatrix;
            setTextScreenMatrix(menuItem.text);
        }
    };

    ActionMenuItem click_add_matrix_22 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            isClickedAddMatrix = true;
            isClickedMultyMatrix = !isClickedAddMatrix;
            setTextScreenMatrix(menuItem.text);
        }
    };

    ActionMenuItem click_add_matrix_33 = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            isClickedAddMatrix = true;
            isClickedMultyMatrix = !isClickedAddMatrix;
            setTextScreenMatrix(menuItem.text);
        }
    };

    public void setTextScreenMatrix(String matrixSize) {
        resetScreen();
        countEnter = 0;
        isClicked_matrix = true;
        isClicked_GPT = !isClicked_matrix;
        ArrayList<String> tokens = cutToken(matrixSize);
        if (tokens.size() == 2) {
            A = new StringBuilder[Integer.parseInt(tokens.get(0))][Integer.parseInt(tokens.get(1))];
            B = new StringBuilder[Integer.parseInt(tokens.get(0))][Integer.parseInt(tokens.get(1))];
        } else {
            A = new StringBuilder[Integer.parseInt(tokens.get(0))][Integer.parseInt(tokens.get(1))];
            B = new StringBuilder[Integer.parseInt(tokens.get(2))][Integer.parseInt(tokens.get(3))];
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] = new StringBuilder("");
            }
        }
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                B[i][j] = new StringBuilder("");
            }
        }
        if(isClickedMultyMatrix){
            scr.taxt.append("[A]*[B] \n");
        }else{
            scr.taxt.append("[A]+[B] \n");
        }
        scr.taxt.append("-----------------------\n");
        scr.taxt.append("A[0][0] = ");
    }

    public void setArrHeSo(int degree) {
        resetScreen();
        countEnter = 0;
        isClicked_GPT = true;
        isClicked_matrix = !isClicked_GPT;
        arr_he_so = new StringBuilder[degree];
        for (int i = 0; i < arr_he_so.length; i++) {
            arr_he_so[i] = new StringBuilder("");
        }
        scr.taxt.append("AX2 + BX + C = 0 \n");
        scr.taxt.append("-----------------------\n");
        scr.taxt.append("A = ");
    }

    ActionMenuItem click_tro_giup = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            Help vHelp = new Help();
        }
    };

    ActionMenuItem click_enter = new ActionMenuItem() {

        @Override
        public void onClick(MenuItem menuItem) {
            isClickedEnter = true;
            if (isClicked_GPT) {
                if (arr_he_so.length > 0 && countEnter == arr_he_so.length - 1) {
                    return;
                }
                countEnter += 1;
                scr.taxt.append("\n");
                if (countEnter == 1) {
                    scr.taxt.append("B = ");
                }
                if (countEnter == 2) {
                    scr.taxt.append("C = ");
                }
                if (countEnter == 3) {
                    scr.taxt.append("D = ");
                }
            }
            if (isClicked_matrix) {
                if (A.length > 0 && B.length > 0 && countEnter == (A.length * A[0].length + B.length * B[0].length - 1)) {
                    return;
                }
                countEnter += 1;
                scr.taxt.append("\n");

                // 2------------------2
                if (A.length == 2 && A[0].length == 2) {
                    if (countEnter == 1) {
                        scr.taxt.append("A[0][1] = ");
                    }
                    if (countEnter == 2) {
                        scr.taxt.append("A[1][0] = ");
                    }
                    if (countEnter == 3) {
                        scr.taxt.append("A[1][1] = ");
                    }
                }
                // 3------------------3
                if (A.length == 3 && A[0].length == 3) {
                    if (countEnter == 1) {
                        scr.taxt.append("A[0][1] = ");
                    }
                    if (countEnter == 2) {
                        scr.taxt.append("A[0][2] = ");
                    }
                    if (countEnter == 3) {
                        scr.taxt.append("A[1][0] = ");
                    }
                    if (countEnter == 4) {
                        scr.taxt.append("A[1][1] = ");
                    }
                    if (countEnter == 5) {
                        scr.taxt.append("A[1][2] = ");
                    }
                    if (countEnter == 6) {
                        scr.taxt.append("A[2][0] = ");
                    }
                    if (countEnter == 7) {
                        scr.taxt.append("A[2][1] = ");
                    }
                    if (countEnter == 8) {
                        scr.taxt.append("A[2][2] = ");
                    }
                }
                // 1------------------2
                if (A.length == 1 && A[0].length == 2) {
                    if (countEnter == 1) {
                        scr.taxt.append("A[0][1] = ");
                    }
                }
                // 2------------------1
                if (A.length == 2 && A[0].length == 1) {
                    if (countEnter == 1) {
                        scr.taxt.append("A[1][0] = ");
                    }
                }
                // 2------------------3
                if (A.length == 2 && A[0].length == 3) {
                    if (countEnter == 1) {
                        scr.taxt.append("A[0][1] = ");
                    }
                    if (countEnter == 2) {
                        scr.taxt.append("A[0][2] = ");
                    }
                    if (countEnter == 3) {
                        scr.taxt.append("A[1][0] = ");
                    }
                    if (countEnter == 4) {
                        scr.taxt.append("A[1][1] = ");
                    }
                    if (countEnter == 5) {
                        scr.taxt.append("A[1][2] = ");
                    }
                }
                // 3------------------2
                if (A.length == 3 && A[0].length == 2) {
                    if (countEnter == 1) {
                        scr.taxt.append("A[0][1] = ");
                    }
                    if (countEnter == 2) {
                        scr.taxt.append("A[1][0] = ");
                    }
                    if (countEnter == 3) {
                        scr.taxt.append("A[1][1] = ");
                    }
                    if (countEnter == 4) {
                        scr.taxt.append("A[2][0] = ");
                    }
                    if (countEnter == 5) {
                        scr.taxt.append("A[2][1] = ");
                    }
                }
                // 1------------------3
                if (A.length == 1 && A[0].length == 3) {
                    if (countEnter == 1) {
                        scr.taxt.append("A[0][1] = ");
                    }
                    if (countEnter == 2) {
                        scr.taxt.append("A[0][2] = ");
                    }
                }
                // 3------------------1
                if (A.length == 3 && A[0].length == 1) {
                    if (countEnter == 1) {
                        scr.taxt.append("A[1][0] = ");
                    }
                    if (countEnter == 2) {
                        scr.taxt.append("A[2][0] = ");
                    }
                }

                //////////////////////////// bbbbbbbbb
                // 2------------------2
                if (countEnter > 3 && B.length == 2 && B[0].length == 2) {
                    if (countEnter == 4) {
                        scr.taxt.append("B[0][0] = ");
                    }
                    if (countEnter == 5) {
                        scr.taxt.append("B[0][1] = ");
                    }
                    if (countEnter == 6) {
                        scr.taxt.append("B[1][0] = ");
                    }
                    if (countEnter == 7) {
                        scr.taxt.append("B[1][1] = ");
                    }
                }

                // 3------------------3
                if (countEnter > 8 && B.length == 3 && B[0].length == 3) {
                    if (countEnter == 9) {
                        scr.taxt.append("B[0][0] = ");
                    }
                    if (countEnter == 10) {
                        scr.taxt.append("B[0][1] = ");
                    }
                    if (countEnter == 11) {
                        scr.taxt.append("B[0][2] = ");
                    }
                    if (countEnter == 12) {
                        scr.taxt.append("B[1][0] = ");
                    }
                    if (countEnter == 13) {
                        scr.taxt.append("B[1][1] = ");
                    }
                    if (countEnter == 14) {
                        scr.taxt.append("B[1][2] = ");
                    }
                    if (countEnter == 15) {
                        scr.taxt.append("B[2][0] = ");
                    }
                    if (countEnter == 16) {
                        scr.taxt.append("B[2][1] = ");
                    }
                    if (countEnter == 17) {
                        scr.taxt.append("B[2][2] = ");
                    }
                }
                // 1------------------2
                if (countEnter > 1 && B.length == 1 && B[0].length == 2) {
                    if (countEnter == 2) {
                        scr.taxt.append("B[0][0] = ");
                    }
                    if (countEnter == 3) {
                        scr.taxt.append("B[0][1] = ");
                    }
                }
                // 2------------------1
                if (countEnter > 1 && B.length == 2 && B[0].length == 1) {
                    if (countEnter == 2) {
                        scr.taxt.append("B[0][0] = ");
                    }
                    if (countEnter == 3) {
                        scr.taxt.append("B[1][0] = ");
                    }
                }
                // 2------------------3
                if (countEnter > 5 && B.length == 2 && B[0].length == 3) {
                    if (countEnter == 6) {
                        scr.taxt.append("B[0][0] = ");
                    }
                    if (countEnter == 7) {
                        scr.taxt.append("B[0][1] = ");
                    }
                    if (countEnter == 8) {
                        scr.taxt.append("B[0][2] = ");
                    }
                    if (countEnter == 9) {
                        scr.taxt.append("B[1][0] = ");
                    }
                    if (countEnter == 10) {
                        scr.taxt.append("B[1][1] = ");
                    }
                    if (countEnter == 11) {
                        scr.taxt.append("B[1][2] = ");
                    }
                }
                // 3------------------2
                if (countEnter > 5 && B.length == 3 && B[0].length == 2) {
                    if (countEnter == 6) {
                        scr.taxt.append("B[0][0] = ");
                    }
                    if (countEnter == 7) {
                        scr.taxt.append("B[0][1] = ");
                    }
                    if (countEnter == 8) {
                        scr.taxt.append("B[1][0] = ");
                    }
                    if (countEnter == 9) {
                        scr.taxt.append("B[1][1] = ");
                    }
                    if (countEnter == 10) {
                        scr.taxt.append("B[2][0] = ");
                    }
                    if (countEnter == 11) {
                        scr.taxt.append("B[2][1] = ");
                    }
                }
                // 3------------------1
                if (countEnter > 2 && B.length == 3 && B[0].length == 1) {
                    if (countEnter == 3) {
                        scr.taxt.append("B[0][0] = ");
                    }
                    if (countEnter == 4) {
                        scr.taxt.append("B[1][0] = ");
                    }
                    if (countEnter == 5) {
                        scr.taxt.append("B[2][0] = ");
                    }
                }
                // 1------------------3
                if (countEnter > 2 && B.length == 1 && B[0].length == 3) {
                    if (countEnter == 3) {
                        scr.taxt.append("B[0][0] = ");
                    }
                    if (countEnter == 4) {
                        scr.taxt.append("B[0][1] = ");
                    }
                    if (countEnter == 5) {
                        scr.taxt.append("B[0][2] = ");
                    }
                }

            }
        }
    };

    public void set_he_so(String text) {
        if (isClicked_GPT) {
            if (countEnter == 0) {
                if (arr_he_so[0] != null) {
                    arr_he_so[0].append(text);
                    scr.taxt.append(text);
                }
            } else if (countEnter == 1) {
                if (arr_he_so[1] != null) {
                    arr_he_so[1].append(text);
                    scr.taxt.append(text);
                }
            } else if (countEnter == 2) {
                if (arr_he_so[2] != null) {
                    arr_he_so[2].append(text);
                    scr.taxt.append(text);
                }
            } else if (countEnter == 3) {
                if (arr_he_so[3] != null) {
                    arr_he_so[3].append(text);
                    scr.taxt.append(text);
                }
            }
        }
        if (isClicked_matrix) {
            // 2------------------2
            if (A.length == 2 && A[0].length == 2) {
                if (countEnter == 0) {
                    A[0][0].append(text);
                    scr.taxt.append(text);
                    System.out.println("aaaaaaaaaaaaaaaaaaaaaa" + A[0][0].toString());
                }
                if (countEnter == 1) {
                    A[0][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 2) {
                    A[1][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 3) {
                    A[1][1].append(text);
                    scr.taxt.append(text);
                }
            }

            // 3------------------3
            if (A.length == 3 && A[0].length == 3) {
                if (countEnter == 0) {
                    A[0][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 1) {
                    A[0][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 2) {
                    A[0][2].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 3) {
                    A[1][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 4) {
                    A[1][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 5) {
                    A[1][2].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 6) {
                    A[2][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 7) {
                    A[2][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 8) {
                    A[2][2].append(text);
                    scr.taxt.append(text);
                }
            }

            // 1------------------2
            if (A.length == 1 && A[0].length == 2) {
                if (countEnter == 0) {
                    A[0][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 1) {
                    A[0][1].append(text);
                    scr.taxt.append(text);
                }
            }

            // 2------------------1
            if (A.length == 2 && A[0].length == 1) {
                if (countEnter == 0) {
                    A[0][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 1) {
                    A[1][0].append(text);
                    scr.taxt.append(text);
                }
            }

            // 2------------------3
            if (A.length == 2 && A[0].length == 3) {
                if (countEnter == 0) {
                    A[0][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 1) {
                    A[0][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 2) {
                    A[0][2].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 3) {
                    A[1][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 4) {
                    A[1][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 5) {
                    A[1][2].append(text);
                    scr.taxt.append(text);
                }
            }

            // 3------------------2
            if (A.length == 3 && A[0].length == 2) {
                if (countEnter == 0) {
                    A[0][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 1) {
                    A[0][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 2) {
                    A[1][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 3) {
                    A[1][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 4) {
                    A[2][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 5) {
                    A[2][1].append(text);
                    scr.taxt.append(text);
                }
            }

            // 1------------------3
            if (A.length == 1 && A[0].length == 3) {
                if (countEnter == 0) {
                    A[0][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 1) {
                    A[0][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 2) {
                    A[0][2].append(text);
                    scr.taxt.append(text);
                }
            }
            // 3------------------1
            if (A.length == 3 && A[0].length == 1) {
                if (countEnter == 0) {
                    A[0][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 1) {
                    A[1][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 2) {
                    A[2][0].append(text);
                    scr.taxt.append(text);
                }
            }

            //////////////////////////// bbbbbbbbb
            // 2------------------2
            if (countEnter > 3 && B.length == 2 && B[0].length == 2) {
                if (countEnter == 4) {
                    B[0][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 5) {
                    B[0][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 6) {
                    B[1][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 7) {
                    B[1][1].append(text);
                    scr.taxt.append(text);
                }
            }
            // 3------------------3
            if (countEnter > 8 && B.length == 3 && B[0].length == 3) {
                if (countEnter == 9) {
                    B[0][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 10) {
                    B[0][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 11) {
                    B[0][2].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 12) {
                    B[1][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 13) {
                    B[1][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 14) {
                    B[1][2].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 15) {
                    B[2][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 16) {
                    B[2][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 17) {
                    B[2][2].append(text);
                    scr.taxt.append(text);
                }
            }
            // 1------------------2
            if (countEnter > 1 && B.length == 1 && B[0].length == 2) {
                System.out.println("Bbbbbbbbbbbbbbbbbbbb 1111111111111");
                if (countEnter == 2) {
                    B[0][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 3) {
                    B[0][1].append(text);
                    scr.taxt.append(text);
                }
            }
            // 2------------------1
            if (countEnter > 1 && B.length == 2 && B[0].length == 1) {
                System.out.println("Bbbbbbbbbbbbbbbbbbbb");
                if (countEnter == 2) {
                    B[0][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 3) {
                    B[1][0].append(text);
                    scr.taxt.append(text);
                }
            }
            // 2------------------3
            if (countEnter > 5 && B.length == 2 && B[0].length == 3) {
                if (countEnter == 6) {
                    B[0][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 7) {
                    B[0][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 8) {
                    B[0][2].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 9) {
                    B[1][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 10) {
                    B[1][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 11) {
                    B[1][2].append(text);
                    scr.taxt.append(text);
                }
            }
            // 3------------------2
            if (countEnter > 5 && B.length == 3 && B[0].length == 2) {
                if (countEnter == 6) {
                    B[0][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 7) {
                    B[0][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 8) {
                    B[1][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 9) {
                    B[1][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 10) {
                    B[2][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 11) {
                    B[2][1].append(text);
                    scr.taxt.append(text);
                }
            }
            // 3------------------1
            if (countEnter > 2 && B.length == 3 && B[0].length == 1) {
               
                if (countEnter == 3) {
                    B[0][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 4) {
                    B[1][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 5) {
                    B[2][0].append(text);
                    scr.taxt.append(text);
                }
            }
            // 1------------------3
            if (countEnter > 2 && B.length == 1 && B[0].length == 3) {
                if (countEnter == 3) {
                    B[0][0].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 4) {
                    B[0][1].append(text);
                    scr.taxt.append(text);
                }
                if (countEnter == 5) {
                    B[0][2].append(text);
                    scr.taxt.append(text);
                }
            }
        }
    }

    public ArrayList<String> cutToken(String expr) {
        ArrayList<String> components = new ArrayList<String>();
        String re = "([0-9])";
        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(expr);

        while (m.find()) {
            components.add(m.group());
        }
        return components;
    }

    void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public static void main(String[] args) {
        CalculatorView mf = new CalculatorView();
    }
}
