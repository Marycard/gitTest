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
    public static ListNode reverseList_doublePointer(ListNode head) {
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


//递归方法
    public static ListNode reverseList_recursion(ListNode head) {
            ListNode res = reverse(null, head);

            return res;
    }
    public static ListNode reverse(ListNode pre, ListNode cur) {
            if (cur == null) {
                return pre;
            }
            ListNode tmp = cur.next;
            cur.next = pre;
            return reverse(cur, tmp);
    }

    public static void main(String[] args) {
//        new LinkedList<>();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reverseList = reverseList_doublePointer(head);

        while (reverseList != null) {
            System.out.println(reverseList.val);
            reverseList = reverseList.next;
        }

    }
    }
}

