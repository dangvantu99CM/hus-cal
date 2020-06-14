/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.MenuData;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author tudv
 */
public class MenuData {

    private ArrayList<MenuItem> dicButtons = new ArrayList<>();
    private ActionMenu actionMenu = null;
    private ArrayList<MenuItem> dicDataMenuBar = new ArrayList<>();

    private static final String CONST_URL_IMAGE = ".././Resource/Image/";

    public MenuData(ActionMenu actionMenu) {
        this.actionMenu = actionMenu;
        initMenuItem();
    }

    public ArrayList<MenuItem> initMenuItem() {
        if (dicButtons.size() > 0) {
            return dicButtons;
        }

        dicButtons.add(new MenuItem("Enter", null, "230,230,230", actionMenu.click_enter, null));
        dicButtons.add(new MenuItem("Sovel", setImgIcon(CONST_URL_IMAGE + "x^2.png"), "230,230,230", actionMenu.click_solve, null));
        dicButtons.add(new MenuItem("x!", null, "230,230,230", actionMenu.click_factory_button, null));
        dicButtons.add(new MenuItem("(", null, "240,245,245", actionMenu.click_open_parent_button, null));
        dicButtons.add(new MenuItem(")", null, "240,245,245", actionMenu.click_close_parent_button, null));
        dicButtons.add(new MenuItem("DEL", null, "240,245,245", actionMenu.click_del_button, null));
        dicButtons.add(new MenuItem("AC", null, "255,255,255", actionMenu.click_ac_button, null));

        dicButtons.add(new MenuItem("1/x", null, "230,230,230", actionMenu.click_1_x, null));
        dicButtons.add(new MenuItem("sin", null, "230,230,230", actionMenu.click_sin_button, null));
        dicButtons.add(new MenuItem("ln", null, "230,230,230", actionMenu.click_ln_button, null));
        dicButtons.add(new MenuItem("7", null, "240,245,245", actionMenu.click_number_7, null));
        dicButtons.add(new MenuItem("8", null, "240,245,245", actionMenu.click_number_8, null));
        dicButtons.add(new MenuItem("9", null, "240,245,245", actionMenu.click_number_9, null));
        dicButtons.add(new MenuItem("/", null, "255,255,255", actionMenu.click_divide_button, null));

        dicButtons.add(new MenuItem("PI", setImgIcon(CONST_URL_IMAGE + "pi.png"), "230,230,230", actionMenu.click_PI_button, null));
        dicButtons.add(new MenuItem("cos", null, "230,230,230", actionMenu.click_cos_button, null));
        dicButtons.add(new MenuItem("log", null, "230,230,230", actionMenu.click_log_button, null));
        dicButtons.add(new MenuItem("4", null, "240,245,245", actionMenu.click_number_4, null));
        dicButtons.add(new MenuItem("5", null, "240,245,245", actionMenu.click_number_5, null));
        dicButtons.add(new MenuItem("6", null, "240,245,245", actionMenu.click_number_6, null));
        dicButtons.add(new MenuItem("*", null, "255,255,255", actionMenu.click_multyply_button, null));

        dicButtons.add(new MenuItem("e", null, "230,230,230", actionMenu.click_number_e_button, null));
        dicButtons.add(new MenuItem("tan", null, "230,230,230", actionMenu.click_tan_button, null));
        dicButtons.add(new MenuItem("sqrt", setImgIcon(CONST_URL_IMAGE + "sqrt.png"), "230,230,230", actionMenu.click_sqrt_button, null));
        dicButtons.add(new MenuItem("1", null, "240,245,245", actionMenu.click_number_1, null));
        dicButtons.add(new MenuItem("2", null, "240,245,245", actionMenu.click_number_2, null));
        dicButtons.add(new MenuItem("3", null, "240,245,245", actionMenu.click_number_3, null));
        dicButtons.add(new MenuItem("-", null, "255,255,255", actionMenu.click_subtract_button, null));

        dicButtons.add(new MenuItem("ANS", null, "230,230,230", actionMenu.click_ans_button, null));
        dicButtons.add(new MenuItem("EXP", null, "230,230,230", actionMenu.click_exp_button, null));
        dicButtons.add(new MenuItem("%", null, "230,230,230", actionMenu.click_percent_button, null));
        dicButtons.add(new MenuItem("0", null, "240,245,245", actionMenu.click_number_0, null));
        dicButtons.add(new MenuItem(".", null, "240,245,245", actionMenu.click_point_button, null));
        dicButtons.add(new MenuItem("=", null, "255,255,255", actionMenu.click_equal_button, null));
        dicButtons.add(new MenuItem("+", null, "255,255,255", actionMenu.click_add_button, null));

        return dicButtons;
    }

    public ArrayList<MenuItem> setListDataMenuBar() {
        if (dicDataMenuBar.size() > 0) {
            return dicDataMenuBar;
        }
        dicDataMenuBar.add(new MenuItem("Nâng cao", null, "", null, new ArrayList<MenuItem>() {
            {
                add(new MenuItem("Giải phương trình", null, "", null, new ArrayList<MenuItem>() {
                    {
                        add(new MenuItem("AX + B = 0", null, "", actionMenu.click_ptb1, null));
                        add(new MenuItem("AX2 + BX + C = 0", null, "", actionMenu.click_ptb2, null));
                        add(new MenuItem("AX3 + BX2 + CX + D = 0", null, "", actionMenu.click_ptb3, null));
                    }
                }));
//                add(new MenuItem("Hệ phương trình", null, "", null, new ArrayList<MenuItem>() {
//                    {
//                        add(new MenuItem("AX + B = 0", null, "", actionMenu.click_ptb1, null));
//                        add(new MenuItem("AX2 + BX + C = 0", null, "", actionMenu.click_ptb2, null));
//                        add(new MenuItem("AX3 + BX2 + CX + D = 0", null, "", actionMenu.click_ptb3, null));
//                    }
//                }));
                add(new MenuItem("Ma trận", null, "", null, new ArrayList<MenuItem>() {
                    {
                        add(new MenuItem("[A]*[B]", null, "", null, new ArrayList<MenuItem>() {
                            {
                                add(new MenuItem("(2,2)*(2,2)", null, "", actionMenu.click_multy_matrix_22, null));
                                add(new MenuItem("(3,3)*(3,3)", null, "", actionMenu.click_multy_matrix_33, null));
                                add(new MenuItem("(1,2)*(2,1)", null, "", actionMenu.click_multy_matrix_1221, null));
                                add(new MenuItem("(2,1)*(1,2)", null, "", actionMenu.click_multy_matrix_2112, null));
                                add(new MenuItem("(2,3)*(3,2)", null, "", actionMenu.click_multy_matrix_2332, null));
                                add(new MenuItem("(3,2)*(2,3)", null, "", actionMenu.click_multy_matrix_3223, null));
                                add(new MenuItem("(1,3)*(3,1)", null, "", actionMenu.click_multy_matrix_1331, null));
                                add(new MenuItem("(3,1)*(1,3)", null, "", actionMenu.click_multy_matrix_3113, null));
                            }
                        }));
                        add(new MenuItem("[A]+[B]", null, "", null, new ArrayList<MenuItem>() {
                            {
                                add(new MenuItem("(2,2)", null, "", actionMenu.click_add_matrix_22, null));
                                add(new MenuItem("(3,3)", null, "", actionMenu.click_add_matrix_33, null));
                            }
                        }));
                    }
                }));
            }
        }));
        dicDataMenuBar.add(new MenuItem("Trợ giúp", null, "", actionMenu.click_tro_giup, null));
        dicDataMenuBar.add(new MenuItem("Lịch sử", null, "", actionMenu.click_lich_su, null));
        return dicDataMenuBar;
    }

    private ImageIcon setImgIcon(String url) {
        return new ImageIcon(url);
    }
}
