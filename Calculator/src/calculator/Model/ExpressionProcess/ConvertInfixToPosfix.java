/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Model.ExpressionProcess;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tudv
 */
public class ConvertInfixToPosfix {

    public String convert = "(8+5)*(4-1)";

    public int setOperatorPriority(char c) {
        switch (c) {
            case '(':
                return 0;
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    public ArrayList<String> cutToken(String expr) {
        ArrayList<String> components = new ArrayList<String>();
        String re = "\\(|\\)|\\d+\\.?\\d*|[+-/%^!*]";
        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(expr);

        while (m.find()) {
            components.add(m.group());
        }
        return components;
    }

    public String convertInfixToPostFix(String expr) {
        ArrayList<String> components = cutToken(expr);
        Stack<String> stack = new Stack<>();
        String result = "";
        for (String s : components) {
            if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                if (!stack.isEmpty() && stack != null) {
                    while (!stack.isEmpty()) {
                        String _s = stack.pop();
                        if (!_s.equals("(")) {
                            result += _s + " ";
                        }
                    }
                }
            } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                while (stack.size() > 0 && setOperatorPriority(s.charAt(0)) <= setOperatorPriority(stack.peek().charAt(0))) {
                    result += stack.pop();
                }
                if (stack.isEmpty()) {
                    stack.push(s);
                }
                if (stack.size() > 0 && setOperatorPriority(s.charAt(0)) > setOperatorPriority(stack.peek().charAt(0))) {
                    stack.push(s);
                }
            } else {
                result += s + " ";
            }
        }
        while (stack.size() > 0) {
            result += stack.pop();
        }
        return result;
    }

    public String eval(String expr) {
        Stack<String> stack = new Stack<>();
        ArrayList<String> componens = cutToken(expr);
        for (String s : componens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                if (stack.size() >= 2) {
                    double s1 = 0;
                    double r1 = Double.parseDouble(stack.pop());
                    double r2 = Double.parseDouble(stack.pop());
                    if (s.equals("+")) {
                        s1 = r1 + r2;
                        stack.push(String.valueOf(s1));
                    } else if (s.equals("-")) {
                        s1 = r2 - r1;
                        stack.push(String.valueOf(s1));
                    } else if (s.equals("/")) {
                        s1 = r2 / r1;
                        stack.push(String.valueOf(s1));
                    } else {
                        s1 = r1 * r2;
                        stack.push(String.valueOf(s1));
                    }
                }
            } else {
                stack.push(s);
            }

        }
        if (stack.size() > 0) {
            return stack.pop();
        }
        return null;
    }

    public static void main(String[] args) {
        ConvertInfixToPosfix c = new ConvertInfixToPosfix();
        String convert = c.convertInfixToPostFix(c.convert);
        System.out.println(convert);
        System.out.println("result == " + c.eval(convert));
    }
}
