/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Model.AppConst;

import java.util.*;

/**
 *
 * @author anhpv
 */
public class RegexApp {

    public static final String regex_ngoac = "([\\(|\\)]*)";
    // check % charactor
    public static final String regex_percent = "([0-9|.|0-9]+%)";
    //check sin
    public static final String regex_sin = "(sin\\([0-9|+|/|*|-|.|!|%|ln\\(.*\\)|log\\(.*\\)|sqrt\\(.*\\)]*\\))";
    
   // static final String regex_sin = "(sin\\([0-9|+|-|*|/|.|!|%]+\\))";
    //check cos
    public static final String regex_cos = "(cos\\([0-9|+|/|*|-|.|!|%|ln\\(.*\\)|log\\(.*\\)|sqrt\\(.*\\)]*\\))";
    // check tan
    public static final String regex_tan = "(tan\\([0-9|+|/|*|-|.|!|%|ln\\(.*\\)|log\\(.*\\)|sqrt\\(.*\\)]*\\))";
    // check x!
  //  static final String regex_factorial = "(\\(?[0-9|.|0-9|+|-|*|/]+\\)?!)";
    public static final String regex_factorial = "([0-9|.|0-9]+!)";
    // check sqrt
    public static final String regex_sqrt = "(sqrt\\([0-9|+|-|*|/|.|!|%]+\\))";
    // check log
    public static final String regex_ln = "(ln\\([0-9|+|-|*|/|.|!|%]+\\))";
    // check log
    public static final String regex_log = "(log\\([0-9|+|-|*|/|.|!|%]+\\))";
    // check log
    public static final String regex_e_mu = "(e\\^[0-9|.|0-9|\\(|\\)|+|-|*|/|!|%]*)";

    //static final String sub_regex_sin = "([0-9|.|+|-|*|/|%|!|ln\\(.*\\)]+)";
    public static final String sub_regex_sin = "sin(.*)";
    public static final String sub_regex_cos= "cos(.*)";
    public static final String sub_regex_tan = "tan(.*)";
    public static final String sub_regex_factorial = "([0-9|.|0-9]+)";
    public static final String sub_regex_percent = "([0-9|.|0-9]+)";
    public static final String sub_regex_log = "log(.*)";
   // static final String sub_regex_ln = "([0-9|.|+|-|*|/|%|!]+)";
    public static final String sub_regex_ln = "ln(.*)";
    public static final String sub_regex_sqrt = "sqrt(.*)";
    public static final String sub_regex_e_mu = "e\\^([0-9|.|\\(|\\)|+|-|*|/|!|%]*)";

    public static final int _percent = 0;
    public static final int _factorial = 1;
    public static final int _sin = 2;
    public static final int _cos = 3;
    public static final int _tan = 4;
    public static final int _ln = 5;
    public static final int _sqrt = 6;
    public static final int _log = 7;
     public static final int _e_mu = 8;
    

}
