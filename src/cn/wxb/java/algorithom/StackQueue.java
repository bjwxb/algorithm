package cn.wxb.java.algorithom;

import java.util.Stack;

public class StackQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node){
        //实现队列的push直接将元素放到第一个栈中
        stack1.push(node);
    }
    public int pop(){
        //如果第2个栈是空的，需要将第一个栈的数据依次取出来
        if(stack2.empty()){
            //直到第一个栈中的数据取完了
            while(!stack1.empty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StackQueue list = new StackQueue();
        list.push(1);
        list.push(2);
        list.push(3);

        System.out.println(">>> " + list.pop());
        System.out.println(">>> " + list.pop());
        System.out.println(">>> " + list.pop());
        list.push(4);
    }
}
