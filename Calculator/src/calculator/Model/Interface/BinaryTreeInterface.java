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
public interface BinaryTreeInterface<E> {
    E root();
    int size(); // number of node in tree
    boolean isEmpty();
    int numChildren(E p); // nmber of children of element p;
    E parent(E p); //return parent of p
    E left(E p); //return left child of p
    E right(E p); //return right child of p
    E sibling(E p); //return sibling of p
    //print tree
}
