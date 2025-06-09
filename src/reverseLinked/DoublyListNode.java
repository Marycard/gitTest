package reverseLinked;

public class DoublyListNode {

    DoublyNode head;

    static class DoublyNode {
        Integer val;
        DoublyNode prev,next;

        DoublyNode (Integer val) {
            this.val = val;
        }
    }

    public Integer getSize(DoublyNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public int get(int index) {
        for (int i =0;i < index;i++) {
            head=head.next;
        }
        return head.val;
    }

    public void addAtHead (int val) {
        DoublyNode newNode = new DoublyNode(val);
        newNode.next = head;
        if(head != null) {
        head.prev = newNode;
        }
        head = newNode;
    }

    public void addAtTail (int val) {
        DoublyNode cur = head;
        DoublyNode newNode = new DoublyNode(val);
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
    }

    public void addAtIndex (int index, int val) {
        DoublyNode cur = head;
        DoublyNode newNode = new DoublyNode(val);
        for (int i = 0; i < index-1;i++) {
            cur = cur.next;
        }
        newNode.prev = cur;
        newNode.next = cur.next;
        cur.next.prev = newNode;
        cur.next = newNode;
    }
    public void deleteAtIndex (int index) {
        DoublyNode cur = head;
        for (int i = 0; i<index;i++) {
            cur = cur.next;
        }
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;

    }

    public static void main(String[] args) {
//        DoublyNode head = new DoublyNode();  //不需要实例化DoublyNode方法,DoublyNode的生命周期都由doulyListNode容器类管理
        DoublyListNode myLinkedList = new DoublyListNode();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        myLinkedList.get(1);              // 返回 2
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        myLinkedList.get(1);
    }
}
