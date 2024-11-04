/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Model.ExpressionProcess;

import calculator.Model.ExpressionProcess.Expression;
import javax.script.ScriptException;

/**
 *
 * @author anhpv
 */
public class Sovel {

    static double _A = 0;
    static double _B = 0;
    static double _C = 0;
    static double _D = 0;
    public Expression expr = new Expression();

    public String giai_ptt_1(StringBuilder[] arr_he_so) throws ScriptException {
        String[] arr = new String[arr_he_so.length];
        for (int i = 0; i < arr_he_so.length; i++) {
            System.out.println("String builder == " + arr_he_so[i]);
            arr[i] = arr_he_so[i].toString();
        }
        if (arr_he_so.length == 0) {
            return "";
        }
        _A = expr.evalJs(arr[0]);
        _B = expr.evalJs(arr[1]);
        if (_A == 0) {
            if (_B == 0) {
                return "Phương trình có vô số nghiệm";
            } else {
                return "Phương trình vô nghiệm";
            }
        } else {
            return "X = " + String.valueOf((double) (-1.0) * _B / _A);
        }
    }

    public String giai_ptt_2(StringBuilder[] arr_he_so) throws ScriptException {
        String result = "";
        String[] arr = new String[arr_he_so.length];
        for (int i = 0; i < arr_he_so.length; i++) {
            System.out.println("String builder == " + arr_he_so[i]);
            arr[i] = arr_he_so[i].toString();
        }
        if (arr_he_so.length == 0) {
            return result;
        }
        _A = expr.evalJs(arr[0]);
        _B = expr.evalJs(arr[1]);
        _C = expr.evalJs(arr[2]);
        if (_A == 0) {
            StringBuilder[] arr_he_so1 = new StringBuilder[2];
            arr_he_so1[0] = arr_he_so[1];
            arr_he_so1[1] = arr_he_so[2];
            return giai_ptt_1(arr_he_so1);
        } else {
            double delta = _B * _B - 4 * _A * _C;
            System.out.println("delta === " + delta);
            if (delta < 0) {
                return "Phương trình vô nghiệm";
            } else if (delta == 0) {
                return "X1 = X2 = " + String.valueOf((double) (-1.0) * _B / 2 * _A);
            }
            result = "X1 = " + ((double) (-1.0) * _B + Math.sqrt(delta)) / 2 * _A + "\n" + "X2 = " + ((double) (-1.0) * _B - Math.sqrt(delta)) / 2 * _A;
            System.out.println("re == " + result);
            return result;
        }
    }

    public String giai_ptt_3(StringBuilder[] arr_he_so) throws ScriptException {
        String[] arr = new String[arr_he_so.length];
        for (int i = 0; i < arr_he_so.length; i++) {
            System.out.println("String builder == " + arr_he_so[i]);
            arr[i] = arr_he_so[i].toString();
        }
        String result = "";
        if (arr_he_so.length == 0) {
            return result;
        }
        _A = expr.evalJs(arr[0]);
        _B = expr.evalJs(arr[1]);
        _C = expr.evalJs(arr[2]);
        _D = expr.evalJs(arr[3]);
        if (_A == 0) {
            if (_B == 0) {
                if (_C == 0) {
                    if (_D == 0) {
                        return "Phương trình có vô số nghiệm";
                    } else {
                        return "Phương trình vô nghiệm ";
                    }
                } else {
                    return "X = " + String.valueOf((double) (-1.0) * _D / _C);
                }
            } else {
                StringBuilder[] arr_he_so1 = new StringBuilder[3];
                arr_he_so1[0] = arr_he_so[1];
                arr_he_so1[1] = arr_he_so[2];
                arr_he_so1[2] = arr_he_so[3];
                return giai_ptt_2(arr_he_so1);
            }
        } else {
            double delta = _B * _B - 3 * _A * _C;
            double k = (9 * _A * _B * _C - 2 * Math.pow(_B, 3) - 27 * Math.pow(_A, 2) * _D) / (2 * Math.sqrt(Math.pow(Math.abs(delta), 3)));
            if (delta > 0) {
                if (Math.abs(k) <= 1) {
                    double x1 = (2 * Math.sqrt(delta) * Math.cos(Math.acos(k) / 3) - _B) / (3.0 * _A);
                    double x2 = (2 * Math.sqrt(delta) * Math.cos(Math.acos(k) / 3 - 2 * Math.PI / 3) - _B) / (3.0 * _A);
                    double x3 = (2 * Math.sqrt(delta) * Math.cos(Math.acos(k) / 3 + 2 * Math.PI / 3) - _B) / (3.0 * _A);
                    return "X1 = " + x1 + "\n" + "X2 = " + x2 + "\n" + "X3 = " + x3;
                } else {
                    double x1 = (Math.sqrt(delta) * Math.abs(k) / 3 * _A * k) * (Math.pow(Math.abs(k) + Math.sqrt(k * k - 1), 1.0 / 3) + Math.pow(Math.abs(k) - Math.sqrt(k * k - 1), 1.0 / 3)) - (double) _B / (3 * _A);
                    return "X = " + x1;
                }
            } else if (delta == 0) {
                double x = ((-1) * _B + Math.pow(_B * _B * _B - 27 * _A * _A * _D, 1.0 / 3)) / (3.0 * _A);
                return "X = " + x;
            } else {
                double r = k - Math.sqrt(k * k + 1);
                double e = 1.0 / 3;
                double x = (Math.sqrt(Math.abs(delta)) / 3 * _A) * (Math.pow(k + Math.sqrt(k * k + 1), 1.0 / 3) + Math.pow(k - Math.sqrt(k * k + 1), 1.0 / 3)) - (double) _B / (3 * _A);
                return "X = " + x;
            }
        }
    }

    public double[][] addMatrix(StringBuilder[][] a, StringBuilder[][] b) throws ScriptException {
        if (a.length == 0 || b.length == 0) {
            return null;
        }
        double[][] convert_m1 = convert(a);
        double[][] convert_m2 = convert(b);
        double[][] resultMatrix = new double[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                resultMatrix[i][j] = convert_m1[i][j] + convert_m2[i][j];
            }
        }
        return resultMatrix;
    }

    public double[][] multyMatrix(StringBuilder[][] a, StringBuilder[][] b) throws ScriptException {
        if (a.length == 0 || b.length == 0) {
            return null;
        }
        double[][] convert_m1 = convert(a);
        double[][] convert_m2 = convert(b);
        double[][] resultMatrix = new double[convert_m1.length][convert_m2[0].length];
        for (int i = 0; i < convert_m1.length; i++) {
            for (int k = 0; k < resultMatrix[0].length; k++) {
                for (int j = 0; j < convert_m2.length; j++) {
                    resultMatrix[i][k] += convert_m1[i][j] * convert_m2[j][k];
                }
            }
        }
        return resultMatrix;
    }

    public double[][] convert(StringBuilder[][] a) throws ScriptException {
        if (a.length == 0) {
            return null;
        }
        double[][] matrixConvert = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                matrixConvert[i][j] = expr.evalJs(a[i][j].toString());
            }
        }
        return matrixConvert;
    }

    public static void main(String[] args) {
        System.out.println("nnnnnnnn " + Math.pow(-6.7555, 5.1));
    }
}
