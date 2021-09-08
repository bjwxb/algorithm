package cn.wxb.java.listnode;

public class Node<T> {
    T value;
    Node<T> next;

    public Node() {
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}
