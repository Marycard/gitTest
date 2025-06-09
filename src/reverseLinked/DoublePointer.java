package reverseLinked;


import java.util.HashSet;

public class DoublePointer {

    public static void main(String[] args) {
        int[] array = {3,2,0,-4};
        Node head = Node.createCycle(array,1);
//        System.out.println(Node.hasCycle(head));
//        System.out.println(Node.getStartCycle(head));
        System.out.println(Node.getStartNode2(head));
    }
}


class Node{
    int val;
    Node next;
    Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
    Node(int val) {
        this.val = val;
    }

    public static Node createCycle(int [] array, int pos) {
    Node head =new Node(array[0]);
    Node tail =head;
        if(pos<0) {
            return head;
        }
        for (int i = 1;i<array.length;i++) {
            Node cur = new Node(array[i]);
            tail.next=cur;
            tail = cur;
        }

        Node cycleStart = head;
        for (int i =0;i<pos;i++) {
            cycleStart = cycleStart.next;
        }
        tail.next = cycleStart;
    return head;
}

    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null) {
            if( fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    public static int getSize(Node head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    //byHash
    public static Integer getStartCycle(Node head) {
        HashSet<Node> nodeSet = new HashSet<>();
        Node node = head;
        while (node.next != null) {
            nodeSet.add(node);
            node = node.next;
            if (nodeSet.contains(node)) {
                return node.val;
            }
        }
        return null;
    }
    //byFastLowPointer
    public static Integer getStartNode2(Node head) {
        if (!Node.hasCycle(head)) {
            return null;
        }
        Node fast = head;
        Node low = head;
        while (fast.next !=null) {
            fast = fast.next.next;
            low = low.next;
            if (fast==low) {
                System.out.println("相遇的节点："+fast.val+" "+ low.val);
                //为了清楚逻辑，又新增两个节点，可简化代码
                Node newNode = fast;
                Node newNode2 = head;
                while (newNode != newNode2) {
                    newNode = newNode.next;
                    newNode2 = newNode2.next;
                }
                System.out.println("入环的第一个节点" +newNode.val + " " + newNode2.val);
                return newNode.val;
            }
        }
        return null;

    }
}
