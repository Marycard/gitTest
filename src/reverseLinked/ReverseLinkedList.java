package reverseLinked;

public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }

//双指针方法
    public static ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
    }
    public static void main(String[] args) {
//        new LinkedList<>();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reverseList = reverseList(head);
//        System.out.println(reverseList);
        while (reverseList != null) {
            System.out.println(reverseList.val);
            reverseList = reverseList.next;
        }

    }
    }
}

