/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Model.Interface;

/**
 *
 * @author tudv
 */
public interface QueueInterface<E> extends  Iterable<E>{
    public void enqueue(E element);
    public E dequeue();
    public boolean isEmpty();
}
