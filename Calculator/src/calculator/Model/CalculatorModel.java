package calculator.Model;

import calculator.MenuData.ActionMenuItem;
import calculator.Model.Da.LinkedListQueue;
import calculator.Model.ExpressionProcess.Expression;
import calculator.Model.ExpressionProcess.Sovel;
import javax.script.ScriptException;

public class CalculatorModel {

    private Expression exception = new Expression();

    public Sovel solve = new Sovel();

    public LinkedListQueue<String> listResultQueue = new LinkedListQueue<>();

    public boolean isValidExpr(String expr) {
        return exception.isValidExpr(expr);
    }

    public double valueExpr(String expr) throws ScriptException {
        return exception.eval(expr);
    }

    public double evalJs(String expr) throws ScriptException {
        return exception.evalJs(expr);
    }

    public String getHistoryAnswer() {
        if (listResultQueue.isEmpty()) {
            return "";
        }
        return listResultQueue.dequeue();
    }

    public String giai_pt_1(StringBuilder[] arr_he_so) throws ScriptException {
        return solve.giai_ptt_1(arr_he_so);
    }

    public String giai_pt_2(StringBuilder[] arr_he_so) throws ScriptException {
        return solve.giai_ptt_2(arr_he_so);
    }

    public String giai_pt_3(StringBuilder[] arr_he_so) throws ScriptException {
        return solve.giai_ptt_3(arr_he_so);
    }

    public double[][] addMatrix(StringBuilder[][] a, StringBuilder[][] b) throws ScriptException {
        return solve.addMatrix(a,b);
    }

    public double[][] multyMatrix(StringBuilder[][] a, StringBuilder[][] b) throws ScriptException {
        return solve.multyMatrix(a,b);
    }
}
