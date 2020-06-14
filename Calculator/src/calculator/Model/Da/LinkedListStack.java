/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Model.Da;

import calculator.Model.Interface.StackInterface;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author tudv
 */
public class LinkedListStack<E> implements StackInterface<E> {

    public class Node {
        E element;
        Node next;
        public Node(E element){
            this.element = element;
        }
    }
   
    public Node stack = null;
    public int n = 0;
    @Override
    public void push(E element) {
        // Thêm một phần tử vào stack
        Node p = stack;
        Node e = new Node(element);
        if(p != null){
            stack = e;
            stack.next = p;
        }else{
            stack = e;
            stack.next = null;
        }
        n++;
    }
    @Override
    public E pop() {
        // Lấy một phần tử khỏi stack
        if(n==0){
            return null;
        }
        Node  p = stack;
        if(p != null){
            stack = p.next;
            n--;
            return p.element;
        }
        return null;
    }
    @Override
    public boolean isEmpty() {
        // Kiểm tra stack rỗng
        return stack==null;
    }
    @Override
    public E top() {
        // Lấy giá trị phần tử đầu tiên của stack
        if(stack != null){
            return stack.element;
        }
        return null;
    }
    
    public E get(int i) {
        Stack<E> s1 = new Stack<>();
        Stack<E> s2 = new Stack<>();
        Node p = stack;
        while(!this.isEmpty()){
            s2.push(this.pop());
        }
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return s1.get(i);
    }
    
  
    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new StackIterator();
    }
    
    class StackIterator implements Iterator<E> {
        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return currentNode != null;
        }
        @Override
        public E next() {

            // TODO Auto-generated method stub
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }
   
    public static void main(String[] args) {
        LinkedListStack<Integer> lls = new LinkedListStack<Integer>();
        lls.push(10);
        lls.push(100);
        lls.push(10777);
        lls.push(104545);
//        lls.printObject();
//        System.out.println(lls.pop());
//        System.out.println(lls.pop());
//        System.out.println("after pop====");
//        lls.printObject();
        for(Integer item:lls){
            System.out.println(item);
        }
//        System.out.println("get top=="+lls.pop());
//        for(Integer item:lls){
//            System.out.println(item);
//        }
        System.out.println("gettttttttttttttttttt=="+lls.get(0));
        
        System.out.println(lls.iterator());;
    }
}
