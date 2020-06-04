package datastructure;

import java.util.LinkedList;

public class IStack<T> {
    Node<T> top;
    Node<T> bottom;
    class Node<T>{
        T element;
        Node<T> next;
        public Node(T element){
            this.element = element;
        }
    }

    public <T> IStack(){};

    //出栈
    public T pop(){
        if(this.top == null){
            throw new RuntimeException("stack is empty");
        }
        T element = this.top.element;
        this.top = top.next;
        return element;
    }

    public T push(T element){
        if(element == null){
            throw new RuntimeException("element can't be null");
        }

        Node<T> node = new Node<T>(element);
        node.next = this.top;
        this.top = node;
        if(this.top.next == null){
            this.bottom = node;
        }
        return element;
    }

    boolean isEmpty(){
        return this.top == null;
    }
}
