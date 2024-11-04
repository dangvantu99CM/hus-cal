/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Model.AppConst;

/**
 *
 * @author anhpv
 */
public class AppConst {

    // input
    static String[] tokens = {"(","1", "+", "2", ")", "*", "3"};
    /*
         Đặt mức độ ưu tiên cho từng toán tử
    */
    public static int rank(char ch) {
        switch (ch) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
}
