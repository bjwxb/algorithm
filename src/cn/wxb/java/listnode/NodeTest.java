package cn.wxb.java.listnode;

import java.util.List;
import java.util.Stack;

public class NodeTest {

    public static void main(String[] args) {
        Node node = initNodeList(5);
        printNode(node);
        System.out.println("================================");
        printNode(reverseNodeList(node));
//        printNode(reverseNodeListByRecursion(node));
    }

    /**
     * 递归反转
     * @param head node
     * @return
     * recursion [rɪˈkɜːrʒn] 递归
     * 递归条件：1.大问题可以拆解成两个子问题；2.子问题算法和大问题一样；3.存在最小子问题
     */
    private static Node reverseNodeListByRecursion(Node head){
        //最小子问题
        if (null == head || head.next == null){
            return head;
        }

        //递归过程，一次次拆解
        Node newHead = reverseNodeListByRecursion(head.next);
        //反转
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //迭代反转
    private static Node reverseNodeList(Node head){
        if (null == head || head.next == null){
            return head;
        }

        Node pre = null;
        while(null != head.next){
            Node next = head.next;//存储下一个节点
            head.next = pre;//将当前节点的next指向pre
            pre = head;//向后保存一个节点
            head = next;//向后动移动一个节点
        }
        head.next = pre;
        return head;
    }

    //init a node list
    private static Node initNodeList(int num){
        Node head = new Node(0, null);
        Node curr = head;
        for (int i = 1; i <= num; i++){
            curr.next = new Node(i, null);
            curr = curr.next;
        }

        return head.next;
    }

    private static void printNode(Node node){
        while (null != node){
            System.out.println("==== " + node.value);
            node = node.next;
        }
    }
}
