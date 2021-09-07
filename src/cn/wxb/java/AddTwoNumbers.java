package cn.wxb.java;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(7);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);

        ListNode ret = addTwoNumbers(l1, l2);
        while(ret != null){
            System.out.print(ret.value + " ,");
            ret = ret.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = null;
        ListNode tail = null;
        int flag = 0;
        while (l1 != null || l2 != null){
            int x = l1 == null?0:l1.value;
            int y = l2 == null?0:l2.value;
            int sum = x + y + flag;
            if (head == null){
                head = new ListNode(sum % 10);
                tail = head;
                head.next = tail;
            } else {
                tail.next = new ListNode(sum%10);
                tail = tail.next;

            }
            flag = sum/10;
            if (l1 !=null){
                l1 = l1.next;
            }
            if (l2 !=null){
                l2 = l2.next;
            }
        }
        if (flag != 0){
            tail.next = new ListNode(flag);
        }

        return head;
    }


    static class ListNode{
        public ListNode(int value) {
            this.value = value;
        }

        int value;
        ListNode next;
    }
}
