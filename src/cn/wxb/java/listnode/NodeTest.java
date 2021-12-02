package cn.wxb.java.listnode;

import java.util.List;
import java.util.Stack;

public class NodeTest {

    public static void main(String[] args) {
        Node<Integer> node = initNodeList(10);
        printNode(node);
        System.out.println("================================");
//        printNode(reverseNodeList(node));
//        printNode(reverseNodeListByRecursion(node));
        System.out.println(">>> " + findKthToTail(node, 2).value);
        System.out.println("====== isLoop = " + isLoop(node));
        Node<Integer> n = deleteNodeVal(node, 5);
        printNode(n);
    }

    /**
     * 删除链表中指定值，并返回剩余链表
     * @param head 链表
     * @param val value
     * @return node
     */
    private static Node deleteNodeVal(Node<Integer> head, int val){
        if(null == head) return null;
        if(head.value == val) return head.next;

        Node<Integer> current = head.next;
        while (current.next != null){
            Node<Integer> tmp = current.next;
            if (tmp.value == val){
                current.next = tmp.next;
                break;
            }
            current = tmp;
        }


        return head;
    }

    /**
     * 判断链表是不是环形链表
     * 定义个块的指针和慢的指针，如果两个再次相遇说明是环形链表
     * @param node node
     * @return true-是
     */
    private static boolean isLoop(Node node){
        Node fast = node.next;
        Node slow = node.next;
        while (null != fast && null != slow && null != fast.next){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     *
     * @param head node
     * @param k 倒数第kge节点
     * @return node
     */
    public static Node findKthToTail(Node head, int k) {
        Node second = head;
        Node first = head;
        //双指针的思想，让第一个指针先走，走到第k个结点后，第二个指针也跟着走，
        // 当第一个节点走到最后的时候，第二个节点位置就是倒数第k个结点的位置
        for (int i = 0; i < k; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
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
