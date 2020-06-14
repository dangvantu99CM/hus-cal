/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Model.Da;

import calculator.Model.Interface.BinaryTreeInterface;


/**
 *
 * @author tudv
 */
public class LinkedBinaryTree<T> implements BinaryTreeInterface {

    public static class Node<T> {

        private T element; // an element stored at this node
        private Node<T> parent; // a reference to the parent node (if any)
        private Node<T> left; // a reference to the left child
        private Node<T> right; // a reference to the right child

        // Constructs a node with the given element and neighbors. ∗/
        public Node(T e, Node<T> above, Node<T> leftChild, Node<T> rightChild) {
            this.element = e;
            this.left = leftChild;
            this.right = rightChild;
            this.parent = above;
        }

        public Node<T> getLeft() {
            return left;
        }

        public Node<T> getRight() {
            return right;
        }

        public Node<T> getParent() {
            return parent;
        }

        public T getElement() {
            return element;
        }

        public void setLeft(Node node) {
            this.left = node;
        }

        public void setRight(Node node) {
            this.right = node;
        }

        public void setParent(Node node) {
            this.parent = node;
        }

        public void setElement(T element) {
            this.element = element;
        }

    }
    //update methods
    public Node root = null;

    public Node<T> addRoot(T element) {
        // Add element to root of an empty tree
        if (size() == 0) {
            root = new Node(element, null, null, null);
            return root;
        }
        return null;
    }

    public Node<T> addLeft(Node p, T element) {
        // Add element to left child node of p if empty
        if (p == null) {
            return null;
        }
        Node node_left = new Node(element, p, null, null);
        p.left = node_left;
        return node_left;
    }

    public Node<T> addRight(Node p, T element) {
        // Add element to right child node of p if empty
        if (p == null) {
            return null;
        }
        Node node_right = new Node(element, p, null, null);
        p.right = node_right;
        return node_right;
    }

    public void set(Node p, T element) {
        // set element to nnode p
        p.element = element;
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public int size() {
        if (root == null) {
            return 0;
        }
        return getSize((Node) root());
    }

    public int getSize(Node node) {
        if (node == null) {
            return 0;
        }
        int sizeLeft = getSize(node.left);
        int sizeRight = getSize(node.right);
        int size = 1 + sizeLeft + sizeRight;
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root() == null;
    }

    @Override
    public int numChildren(Object p) {
        int count = 0;
        if (p == null) {
            return 0;
        }
        if (left(p) != null) {
            count++;
        }
        if (right(p) != null) {
            count++;
        }
        return count;
    }

    public Node getParent(Node p) {
        return (Node) parent(p);
    }

    @Override
    public Object parent(Object p) {
        Node node = (Node) p;
        if (node == null || node.equals(root)) {
            return null;
        }
        return node.parent;
    }

    @Override
    public Object left(Object p) {
        if (p == null) {
            return null;
        }
        Node node = (Node) p;
        return node.left;
    }

    @Override
    public Object right(Object p) {
        if (p == null) {
            return null;
        }
        Node node = (Node) p;
        return node.right;
    }

    @Override
    public Object sibling(Object p) {
        Node node = (Node) p;
        if (p == null) {
            return null;
        }
        return sibling(node, (Node) root(), null);
    }

    public Node sibling(Node p, Node node, Node sibling) {
        if (p == null || p.equals(root) || node == null) {
            return sibling;
        }
        if (p.equals(node.left)) {
            sibling = node.right;
            return sibling;
        }
        if (p.equals(node.right)) {
            sibling = node.left;
            return sibling;
        }
        if (node.left != null) {
            sibling = sibling(p, node.left, sibling);
        }
        if (node.right != null) {
            sibling = sibling(p, node.right, sibling);
        }
        return sibling;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);
        builder = toString(root, builder, 0, null);
        return builder.toString();
    }

    // bien dien cay nhi phan tu node vao builder
    public StringBuilder toString(Node node, StringBuilder builder, int height,
            String text) {
        if (node == null) {
            return builder;
        }
        addSpaceToBuilder(height, builder);
        builder.append('[');
        if (text != null) {
            builder.append(text);
        }
        builder.append(node.element.toString()).append("\n");
        builder = toString(node.left, builder, height + 1, "left== ");
        builder = toString(node.right, builder, height + 1, "right== ");
        addSpaceToBuilder(height, builder);
        builder.append(']').append('\n');
        return builder;
    }

    // them number ky tu sapce vao builder
    private void addSpaceToBuilder(int number, StringBuilder builder) {
        for (int i = 0; i < number; i++) {
            builder.append("\t");
        }
    }

    public StringBuilder printTree(Node root, StringBuilder buider) {
        if (root == null) {
            return buider;
        }
        printTree(root.left, buider);
        if (root.left.element != null) {
            buider.append(root.left.element);
        }
        buider.append("\n");
        printTree(root.right, buider);
        if(root.right.element != null){
            buider.append(root.right.element);
        }
        return buider;
    }

    public static void main(String[] args) {
        LinkedBinaryTree<String> lbt = new LinkedBinaryTree<>();

        lbt.addRoot("1");

        lbt.addLeft(lbt.root, "2");
        lbt.addRight(lbt.root, "3");

        lbt.addLeft(lbt.root.left, "4");
        lbt.addRight(lbt.root.left, "5");

        lbt.addLeft(lbt.root.right, "6");
        lbt.addRight(lbt.root.right, "7");

        lbt.addLeft(lbt.root.right.right, "8");
        lbt.addRight(lbt.root.right.right, "9");

        System.out.println("root === " + lbt.root.element);
        System.out.println("left=== " + lbt.root.left.element);
        System.out.println("right === " + lbt.root.right.element);

        System.out.println("size === " + lbt.size());

        System.out.println("get parent==" + ((Node) lbt.parent(lbt.root.right)).element);

        System.out.println(lbt.toString());

        System.out.println(((Node) lbt.sibling(lbt.root.right.right.right)).element);

        System.out.println(lbt.printTree(lbt.root, new StringBuilder()));

    }

}
