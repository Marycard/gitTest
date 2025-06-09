package reverseLinked;

public class MyLinkedList {
    Integer val;
    MyLinkedList next;

    MyLinkedList(int val) {
        this.val = val;
    }
    MyLinkedList (int val, MyLinkedList next) {
        this.val = val;
        this.next = next;
    }

    public MyLinkedList() {
    }


    static int getSize(MyLinkedList cur) {
        int size = 0;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }
    int get(int index) {
        int size = getSize(this);
        MyLinkedList cur = this;

        if (index < 0||index >= size) {
            return -1;
        }
        for(int i=0;i<index;i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    //没有影响原始对象
    void addAtHead(int val) {
//        MyLinkedList newNode = new MyLinkedList(val, next);
//        newNode.next = this;
        //由于java是值传递，所以不能通过修改局部变量来影响外部变量，而this不能用来被赋值。所以要不将该方法改为返回值方法，让外部感知到该变化
        //要不通过下面的方法，通过在当前节点伪装成插入新节点
        MyLinkedList newNode = new MyLinkedList(this.val, this.next);
        this.val = val;
        this.next = newNode;

    }
    void addAtTail(int val) {
        MyLinkedList newNode = new MyLinkedList(val);
        MyLinkedList cur = this;
        int size = getSize(cur);
        for (int i =0;i < size-1;i++) {
            cur = cur.next;
        }
        cur.next = newNode;
    }

    void addAtIndex(int index, int val) {
        int size = getSize(this);
        MyLinkedList cur = this;
        MyLinkedList newNode = new MyLinkedList(val,next);
        if (index > size) {
            return;
        } else if (index == size) {
            addAtTail(val);
        } else if (index <= 0) {
            addAtHead(val);
        } else {
            for (int i =0;i<index-1;i++) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }
    }
    void deleteAtIndex(int index) {
        int size = getSize(this);
        MyLinkedList cur = this;
        if (index < 0 || index >= size) {
            return;
        }
        for (int i =0; i <index-1; i++) {
            cur =cur.next;
        }
        cur.next = cur.next.next;
    }

    MyLinkedList removeNthFromEnd(MyLinkedList head, int n) {
        Integer size = getSize(head);
        if (size == 1) {
            head = null;
        } else {
            MyLinkedList fast = head.next.next;
            MyLinkedList slow = head;
            for (int i = 0;i<size-n-1;i++) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = fast;
        }
        return head;
    }

    static MyLinkedList removeElements(MyLinkedList head,int val) {
//        MyLinkedList pre = new MyLinkedList(0, head);
//        while (head.next != null) {
//            if (head.val == val) {
//                pre.next=head.next;
//            }
//            pre = head;
//            head = head.next;
//        }
//        if (head.val == val) {
//            pre.next =null;
//        }
//        return pre.next;

//        if (head == null) {
//            return null;
//        }
//        MyLinkedList pre = null;
//        MyLinkedList cur = head;
//        while (cur != null) {
//            if (cur.val == val) {
//                pre.next = cur.next;
//            }
//            pre = pre.next;
//            cur = cur.next;
//        }
//        return head;
        //头节点和尾结点比较难考虑到
        if (head == null) {
            return null;
        }
        MyLinkedList pre = new MyLinkedList(0,head);
        MyLinkedList cur = pre;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }

    static MyLinkedList oddEvenList(MyLinkedList head) {
//        MyLinkedList cur = head;
//        MyLinkedList oddIndex = new MyLinkedList();
//        MyLinkedList evenIndex = new MyLinkedList();
//        MyLinkedList oddCur = oddIndex;
//        MyLinkedList evenCur = evenIndex;
//        Integer len = getSize(head);
//        for (int  i = 0;i<len;i++) {
//            if (i % 2 ==0) {
//                evenCur.next = cur;
//                evenCur = evenCur.next;
//            } else {
//                oddCur.next = cur;
//                oddCur = oddCur.next;
//            }
//            cur = cur.next;
//        }
//        oddCur.next = null; //空链表错误，提前判断链表是否为空
//        evenCur.next = oddIndex.next;
//        return evenIndex.next;

//双指针
        if (head == null||head.next == null) {
            return head;
        }
        MyLinkedList slow = head;
        MyLinkedList temp = slow;
        MyLinkedList fast = head.next;
        MyLinkedList fast_cur = fast;

        while (fast_cur != null && fast_cur.next != null) {
            slow.next = slow.next.next;
            fast_cur.next = fast_cur.next.next;
            slow = slow.next;
            fast_cur = fast_cur.next;
            temp = slow;
        }
        temp.next =fast;
        return head;

    }


    public static void main(String[] args) {
//        MyLinkedList head = new MyLinkedList(6, new MyLinkedList(6, new MyLinkedList(6,new MyLinkedList(6))));
        MyLinkedList head = new MyLinkedList(1, new MyLinkedList(2, new MyLinkedList(3, new MyLinkedList(4, new MyLinkedList(5)))));
//        System.out.println(head.getSize(head));
//        System.out.println(head.get(2));
//        head.addAtTail(6);
//        head.addAtIndex(2, 100);
//        head.deleteAtIndex(2);
//        head.addAtHead(0);
//        System.out.println(head.removeNthFromEnd(head, 1));
//        MyLinkedList head = new MyLinkedList();
//        MyLinkedList res = removeElements(head,6);
        MyLinkedList res = oddEvenList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }



    }
}
