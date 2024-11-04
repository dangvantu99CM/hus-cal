/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Model.Da;

import calculator.Model.Interface.QueueInterface;
import java.util.Iterator;

/**
 *
 * @author anhpv
 */
public class LinkedListQueue<E> implements QueueInterface<E>{
    class Node {
        E element;
        Node next;
        public Node(E element){
            this.element = element;
        }
        public Node(){}
    }
    Node queue = null;
    Node top = null;
    Node bottom = null;
    int n = 0;
    @Override
    public void enqueue(E element) {
        Node oldBottom = bottom;
        Node e = new Node(element);
        if(!isEmpty()){
            bottom = e;
            oldBottom.next = bottom;
            bottom.next = null;
        }else{
            bottom = e;
            top = e;
        }
        n++;
    }

    @Override
    public E dequeue() {
       if(isEmpty()){
           return null;
       }
       Node t = top;
       top = top.next;
       n--;
       return t.element;
    }

    @Override
    public boolean isEmpty() {
        return top == null;    
    }

    @Override
    public Iterator<E> iterator() {
        return new linkedListQueue();
    }
    
    class linkedListQueue implements Iterator<E>{
        Node t = top;
        @Override
        public boolean hasNext() {
            return t != null;
        }

        @Override
        public E next() {
            E data = t.element;
            t = t.next;
            return data;
        }
         
    }
    
    public void _iterator(){
        LinkedListQueue<E> self = this;
        for(E i : self){
            System.out.println("----- "+i);
        }
    }
     
     
    public static void main(String[] args) {
        LinkedListQueue<Integer> llq = new LinkedListQueue<>();
        llq.enqueue(1);
        llq.enqueue(10);
        llq.enqueue(100);
        llq.enqueue(10000);
        llq.enqueue(12131);
        llq._iterator();
        System.out.println("dequeue==" + llq.dequeue());
        System.out.println("dequeue==" + llq.dequeue());
        llq._iterator();
    }
}
