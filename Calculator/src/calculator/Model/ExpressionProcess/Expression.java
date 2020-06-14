/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Model.ExpressionProcess;

import calculator.Model.AppConst.RegexApp;
import calculator.Model.Da.LinkedListStack;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Expression {

    class Index {

        private int idx_start = 0;
        private int idx_end = 0;

        private String dataReplace = "";

        public Index(int idx_start, int idx_end) {
            this.idx_start = idx_start;
            this.idx_end = idx_end;
        }

        public Index(int idx_start, int idx_end, String dataReplace) {
            this.idx_start = idx_start;
            this.idx_end = idx_end;
            this.dataReplace = dataReplace;
        }

        public int getIdx_end() {
            return idx_end;
        }

        public int getIdx_start() {
            return idx_start;
        }

        public String getDataReplace() {
            return dataReplace;
        }

    }

    public boolean isValidExpr(String expr) {
        LinkedListStack<String> lstack = new LinkedListStack<>();
        char[] ch = expr.toCharArray();
        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] == '%') {
                if (isNumeric(String.valueOf(ch[i + 1]))) {
                    return false;
                }
            }
        }

        for (int i = 0; i < ch.length; i++) {
            if (Character.toString(ch[i]).equals("(")) {
                lstack.push(Character.toString(ch[i]));
            }
            if (Character.toString(ch[i]).equals(")")) {
                if (lstack.stack == null) {
                    return false;
                } else {
                    lstack.pop();
                }
            }
        }

        if (lstack.stack == null) {
            return true;
        } else {
            return false;
        }
    }

    public double eval(String formula) {
        LinkedListStack<String> operatorStack = new LinkedListStack<>();
        LinkedListStack<String> rankStack = new LinkedListStack<>();
        String re = "\\(|\\)|\\d+\\.?\\d*|[+-/%^!*]";
        List<String> components = new ArrayList<String>();
        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(formula);
        while (m.find()) {
            components.add(m.group());
        }
        double result = 0.0;
        for (String c : components) {
            if (c.equals("+")) {
                operatorStack.push(c);
            } else if (c.equals("-")) {
                operatorStack.push(c);
            } else if (c.equals("*")) {
                operatorStack.push(c);
            } else if (c.equals("/")) {
                operatorStack.push(c);
            } else if (isNumeric(c)) {
                rankStack.push(c);
            } else if (c.equals(")")) {
                double r1 = 0.0;
                double r2 = 0.0;
                try {
                    if (!rankStack.isEmpty() && rankStack.n >= 2) {
                        r1 = Double.parseDouble(rankStack.pop());
                        r2 = Double.parseDouble(rankStack.pop());
                    }
                } catch (NullPointerException nf) {
                    System.out.println("Bieu thuc khong hop le");
                }

                if (!operatorStack.isEmpty()) {
                    String o = operatorStack.pop();
                    if (o.equals("+")) {
                        result = r1 + r2;
                        rankStack.push(String.valueOf(result));
                    } else if (o.equals("-")) {
                        result = r2 - r1;
                        rankStack.push(String.valueOf(result));
                    } else if (o.equals("*")) {
                        result = r1 * r2;
                        rankStack.push(String.valueOf(result));
                    } else {
                        result = r2 / r1;
                        rankStack.push(String.valueOf(result));
                    }
                }
            }
        }
        return Double.parseDouble(rankStack.pop());
    }

    public double evalJs(String expr) throws ScriptException {
        System.out.println("exqr == " + expr);
        double result = 0.0;
        try {
            // convert %
            Pattern pate_percent = Pattern.compile(RegexApp.regex_percent);
            Matcher mat_percent = pate_percent.matcher(expr);

            // convert x!
            Pattern pate_factorial = Pattern.compile(RegexApp.regex_factorial);
            Matcher mat_factorial = pate_factorial.matcher(expr);

            Pattern pate_sin = Pattern.compile(RegexApp.regex_sin);
            Matcher mat_sin = pate_sin.matcher(expr);

//             convert cos!
            Pattern pate_cos = Pattern.compile(RegexApp.regex_cos);
            Matcher mat_cos = pate_cos.matcher(expr);

            //   convert tan!
            Pattern pate_tan = Pattern.compile(RegexApp.regex_tan);
            Matcher mat_tan = pate_tan.matcher(expr);

            //   convert log!
            Pattern pate_log = Pattern.compile(RegexApp.regex_log);
            Matcher mat_log = pate_log.matcher(expr);

            //   convert sqrt!
            Pattern pate_sqrt = Pattern.compile(RegexApp.regex_sqrt);
            Matcher mat_sqrt = pate_sqrt.matcher(expr);

            //   convert ln!
            Pattern pate_ln = Pattern.compile(RegexApp.regex_ln);
            Matcher mat_ln = pate_ln.matcher(expr);

            //   convert ln!
            Pattern pate_ngoac = Pattern.compile(RegexApp.regex_ngoac);
            Matcher mat_ngoac = pate_ngoac.matcher(expr);

            while (true) {

                if (mat_sin.find()) {
                    expr = convert(expr, RegexApp.regex_sin, RegexApp._sin, RegexApp.sub_regex_sin);
                }

                if (mat_percent.find()) {
                    expr = convert(expr, RegexApp.regex_percent, RegexApp._percent, RegexApp.sub_regex_percent);
                }

                if (mat_cos.find()) {
                    expr = convert(expr, RegexApp.regex_cos, RegexApp._cos, RegexApp.sub_regex_cos);
                }

                if (mat_factorial.find()) {
                    expr = convert(expr, RegexApp.regex_factorial, RegexApp._factorial, RegexApp.sub_regex_factorial);
                }

                if (mat_tan.find()) {
                    expr = convert(expr, RegexApp.regex_tan, RegexApp._tan, RegexApp.sub_regex_tan);
                }

                if (mat_ln.find()) {
                    System.out.println("lnlnnnnnnnnnnnnnnnnnnn");
                    expr = convert(expr, RegexApp.regex_ln, RegexApp._ln, RegexApp.sub_regex_ln);
                }

                if (mat_log.find()) {
                    System.out.println("lnlnnnnnnnnnnnnnnnnnnn");
                    expr = convert(expr, RegexApp.regex_log, RegexApp._log, RegexApp.sub_regex_log);
                }

                if (mat_sqrt.find()) {
                    System.out.println("lnlnnnnnnnnnnnnnnnnnnn");
                    expr = convert(expr, RegexApp.regex_sqrt, RegexApp._sqrt, RegexApp.sub_regex_sqrt);
                }

                if (!mat_percent.find() && !mat_factorial.find() && !mat_sin.find() && !mat_cos.find() && !mat_tan.find() && !mat_ln.find() && !mat_log.find() && !mat_sqrt.find()) {
                    break;
                }
            }
//            System.out.println("eeeeeeeeeeeeeeeeee" + expr);
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            result = Double.parseDouble(engine.eval(expr).toString());
            System.out.println(engine.eval(expr));
//            if(mat_ngoac.find()){
////                System.out.println("aaaaaaaaaaaaaaaa");
//                result = eval(expr);
//            }else{
//                result = compute(expr);
//            }
            System.out.println("result == " + result);
        } catch (Exception e) {
            System.out.println("Biểu thức không hợp lệ");
        }
        return result;
    }

    public String convert(String expr, String regular, int math, String subRegex) throws ScriptException {

        List<String> listdataFind = new ArrayList<String>();
        List<String> listdataReplace = new ArrayList<String>();
        ArrayList<Index> listIndex = new ArrayList<>();

        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(expr);

        Pattern pattern1 = Pattern.compile(subRegex);

        // create data start find
        while (matcher.find()) {
            listdataFind.add(matcher.group());
            Matcher matcher1 = pattern1.matcher(matcher.group());
            System.out.println("marcher == " + matcher.group());
            while (matcher1.find()) {
                System.out.println("marcher 111 == " + matcher1.group());
                System.out.println("math === " + math);
                switch (math) {
                    case 0:
                        listdataReplace.add(String.valueOf(Double.parseDouble(matcher1.group()) * Math.pow(10, -2)));
                        break;
                    case 1:
                        System.out.println("factorial == " + matcher1.group());
                        double result = evalJs(matcher1.group());
                        if (result < 0) {
                            System.out.println("ERR");
                        } else {
                            listdataReplace.add(String.valueOf(factorial(result)));
                        }
                        break;
                    case 2:
                        System.out.println("sinnnnnnnnnnnnnn ==== " + matcher1.group(1));
                        listdataReplace.add(String.valueOf(Math.sin(evalJs(matcher1.group(1)))));
                        break;
                    case 3:
                        System.out.println("sinnnnnnnnnnnnnn ==== " + matcher1.group(1));
                        listdataReplace.add(String.valueOf(Math.cos(evalJs(matcher1.group(1)))));
                        break;
                    case 4:
                        listdataReplace.add(String.valueOf(Math.tan(evalJs(matcher1.group(1)))));
                        break;
                    case 5:
                        System.out.println("math === " + math);
                        listdataReplace.add(String.valueOf(Math.log(evalJs(matcher1.group(1)))));
                        break;
                    case 6:
                        System.out.println("sqqqqqqqqqqqq == " + Math.sqrt(evalJs(matcher1.group(1))));
                        listdataReplace.add(String.valueOf(Math.sqrt(evalJs(matcher1.group(1)))));
                        break;
                    case 7:
                        listdataReplace.add(String.valueOf(Math.log10(evalJs(matcher1.group(1)))));
                        break;
                    default:
                        System.out.println("Not math");
                }
            }
            listIndex.add(new Index(matcher.start(), matcher.end()));
        }
        if (listdataFind.size() > 0) {
            String exprReplaced = expr.substring(0, listIndex.get(0).getIdx_start());
            for (int i = 0; i < listIndex.size() - 1; i++) {
                exprReplaced += listdataReplace.get(i) + expr.substring(listIndex.get(i).getIdx_end(), listIndex.get(i + 1).getIdx_start());
            }
            exprReplaced += listdataReplace.get(listdataReplace.size() - 1)
                    + expr.substring(listIndex.get(listIndex.size() - 1).getIdx_end(), expr.length());
            expr = exprReplaced;
        }
        System.out.println("expr === " + expr);
        return expr;
    }

    public double factorial(double n) {
        if (n == 0 || n == 1 || n < 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;

    }

    public static void main(String[] args) throws ScriptException {
        Expression expr = new Expression();
        String f = "1+sin(0.5+2+ln(4.5)+3!+sqrt(5))";
        String f2 = "sin(0.5+2-1+3!)";
        //expr.convert(f2, RegexApp.regex_factorial, RegexApp._factorial, RegexApp.sub_regex_factorial);
        String t1 = "1+sin(0.5)+3!+cos(2)";
        String t2 = "sin(0.5)";
        String t3 = "sqrt(4)";

        expr.evalJs(f);

//        System.out.println("ssssssssss =  " + expr.eval("(1-0.5+-2)"));
//        String expression = "1+2*6-7/2";
//        System.out.println("ssssss = "+expr.compute(expression));
    }
}
