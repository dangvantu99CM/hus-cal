/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Model.ExpressionProcess;

import calculator.Model.AppConst.AppConst;
import calculator.Model.Da.LinkedBinaryTree;
import calculator.Model.Da.LinkedListStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tudv
 */
public class BuildTree<E> extends LinkedBinaryTree {

    // output : Là biểu thức dạng trung tố 
    // input : Dung cay nhi phann voi bieu thuc tuong ung
    //string 
    // 
    String[] tokens = {"(", "10", "/", "2", "+", "3", ")", "*", "(", "7", "-", "4", ")"}; // Mang lưu dữ liêu đầu vào
    Stack<String> stack = new Stack(); // Stack để lưu trang thái xử lý biểu thức khi chuyển đổi

    private LinkedListStack<String> lstack = new LinkedListStack<>(); // Stack kiểm tra tính hợp lệ của đau ngoặc

    /*
     Kiểm tra tính hợp lệ về dấu ngoặc của biểu thức
     */
    public boolean isValidExpr() {

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("(")) {
                lstack.push(tokens[i]);
            }
            if (tokens[i].equals(")")) {
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
    /* 
     Chuyển đổi biểu thức số học từ dạng trung tố sang dạng hậu tố
     */

    public String _convertInfixToPostFix(String expr) {
        Stack<String> stack = new Stack<>();
        String re = "\\(|\\)|\\d+\\.?\\d*|[+-/%^!*]";
        List<String> components = new ArrayList<String>();
        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(expr);
        String result = "";
        while (m.find()) {
            components.add(m.group());
        }
        boolean isValidExpress = isValidExpr();
        if (!isValidExpress) {
            return "Invalid Expresstion!";
        }
        for (String s : components) {
            if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                while (stack != null && stack.size() > 0) {
                    String _string = stack.pop();
                    if (!_string.equals("(")) {
                        result += _string + " ";
                    }
                }
            } else if (s.equals("+") ||s.equals("-") || s.equals("*") ||s.equals("/")) {
                while (stack.size() > 0 && stack != null && AppConst.rank(s.charAt(0)) < AppConst.rank(stack.peek().charAt(0))) {
                    result += stack.pop() + " ";
                }
                stack.push(s);
            } else {
                result += s + " ";
            }
        }
        return result;
    }
    /*
     Trả về cay nhi phân tương ứng với biểu thức số học
     */
//    public LinkedBinaryTree<String> buildTree() {
//        String[] tokens = _convertInfixToPostFix().split(" ");
//        LinkedBinaryTree<String> lbt = new LinkedBinaryTree<>();
//        Stack<Node<E>> stack = new Stack();
//        for(int i = 0; i < tokens.length; i++){
//            Node node = new Node(tokens[i], null, null,null);
//            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
//                if(stack.size() > 0 && stack != null){
//                    Node _nodeRight = stack.pop();
//                    Node _nodeLeft = stack.pop();
//                    node.setLeft(_nodeLeft);
//                    node.setRight(_nodeRight);
//                }
//            }
//            stack.push(node);
//        }
//        lbt.root = stack.pop();
//        return lbt;
//    }

    public static void main(String[] args) {
        BuildTree<Integer> bt = new BuildTree<>();
        System.out.println("Tree");
//        System.out.println(bt.buildTree().toString());
        String s = "(8+5)*2-4*3";
        System.out.println(bt._convertInfixToPostFix(s));
    }
}
