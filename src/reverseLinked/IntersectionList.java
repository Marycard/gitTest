package reverseLinked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static reverseLinked.Node.getSize;
//import javafx.util.Pair;

public class IntersectionList {
    public static void main(String[] args) {
        Integer[] arrayA = {1,9,1,2,4};
        Integer[] arrayB = {3,2,4};
        ArrayList<Integer> listA = new ArrayList<>(Arrays.asList(arrayA));
        ArrayList<Integer> listB = new ArrayList<>(Arrays.asList(arrayB));
        Pair heads = IntersectionNode.ceateInterNode(listA, listB, 2,3,1);
        System.out.println(heads.headA);
        System.out.println(heads.headB);
//        Node intersect = IntersectionNode.getInterStart(heads.headA, heads.headB);
        Node intersect = IntersectionNode.getInterStart2(heads.headA, heads.headB);
        System.out.println(intersect);
    }
}
class IntersectionNode {
    public static Node createLinkedList(ArrayList<Integer> list, int skip) {
        Node head = new Node(list.get(0));
        Node tail = head;
        for (int i =1; i<skip;i++) {
            Node cur = new Node(list.get(i));
            tail.next = cur;
            tail = cur;
        }
        return head;
    }
    public static Pair ceateInterNode(ArrayList<Integer> listA, ArrayList<Integer> listB, int intersectVal, int skipA, int skipB) {
        Node headA = createLinkedList(listA,skipA);
        Node headB= createLinkedList(listB,skipB);

        if (skipA < listA.size() && skipB <listB.size() && listA.get(skipA) ==listB.get(skipB)) {
            int j = skipA;
            int restLen = listA.size() - skipA;
            ArrayList<Integer> restVal = new ArrayList<>();
            while ( j < listA.size()) {
                restVal.add(listA.get(j));
                j++;
            }
            Node rest = createLinkedList(restVal,restLen);
            Node tailA = headA;
            while (tailA.next != null) {
                tailA = tailA.next;
            }
            tailA.next = rest;
            Node tailB = headB;
            while (tailB.next != null) {
                tailB = tailB.next;
            }
            tailB.next = rest;
            return new Pair(headA, headB);
        }
        return new Pair(headA, headB);
    }
    //byhash
    public static Node getInterStart(Node headA,Node headB) {
        HashSet<Node> nodeSet = new HashSet<>();
        while (headA !=null) {
            nodeSet.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (nodeSet.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    //byDoublePointer
    public static Node getInterStart2(Node headA, Node headB) {
        Integer lenA = getSize(headA);
        Integer lenB = getSize(headB);
        if (lenB.equals(lenA)) {
            while (headA != null) {
                if (headA.equals(headB)) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
        } else if (lenB > lenA) {
            for (int i =0; i < lenB-lenA;i++) {
                headB = headB.next;
            }
            while (headA != null) {
                if (headA.equals(headB)) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
        } else if (lenA > lenB) {
            for (int i =0; i < lenA - lenB;i++) {
                headA = headA.next;
            }
            while (headA != null) {
                if (headA.equals(headB)) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

}


class Pair {
    public Node headA;
    public Node headB;
    public Pair(Node headA,Node headB) {
        this.headA = headA;
        this.headB = headB;
    }
}
