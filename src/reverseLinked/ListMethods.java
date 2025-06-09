package reverseLinked;

import java.util.ArrayList;
import java.util.Arrays;

public class ListMethods {
    public SinglyNode mergeTwoLists(SinglyNode list1, SinglyNode list2) {
//        if (list1 == null && list2 ==null) {
//            return null;
//        } else if (list2 == null) {
//            return list1;
//        } else if (list1 == null ) {
//            return list2;
//        }
        // 可以改进为三元表达式
//        SinglyNode cur_1 = list1;
//        SinglyNode cur_2 = list2;
//        while (cur_1.next != null) {
//            cur_1 = cur_1.next;
//        }
//        cur_1.next = list2;

//        //固定一端
//        while (cur_2 != null) {
//            if (cur_2.val >= cur_1.val) {
//                SinglyNode temp = cur_1.next;
//                cur_1.next =cur_2;
//                cur_1.next.next = temp;
//                cur_2 = cur_2.next;
//                cur_1 = temp;
//            }else {
//                SinglyNode temp = cur_2.next;
//                cur_2.next = cur_1;
//            }
//
//        }
        SinglyNode target = new SinglyNode(-1);
        SinglyNode pre = target;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            }else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = (list1 == null? list2:list1);
        return target.next;
    }
    public static SinglyNode addTwoNumbers(SinglyNode l1, SinglyNode l2) {
        SinglyNode target = new SinglyNode(0);
        SinglyNode cur = target;
        long num_1 = getNumFromList(l1);
        long num_2 = getNumFromList(l2);
        long targetNum = num_1+num_2;
        if (targetNum == 0) {
            return target;
        }
        long res = targetNum;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (res != 0) {
            long num = (long) res % 10;
            res = res / 10;
            arrayList.add((int)num);
        }
        for (Integer num: arrayList) {
            SinglyNode newNode = new SinglyNode(num);
            cur.next = newNode;
            cur =newNode;
        }
        return target.next;
    }
    static long getNumFromList(SinglyNode list) {
        long num=0;
        ArrayList<Integer> array = new ArrayList<>();
        while (list != null) {
            array.add(list.val);
            list = list.next;
        }
        for (int i =0; i<array.size();i++) {
            num += (long) (array.get(i) * Math.pow(10,i));
        }
        return num;
    }

    public static SinglyNode addTwoNumbers_1(SinglyNode l1,SinglyNode l2) {
        SinglyNode dummyHead = new SinglyNode(0);
        SinglyNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new SinglyNode(sum % 10);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
//        SinglyNode l1 = new SinglyNode(9);
//        SinglyNode l2 = new SinglyNode(0);
        Integer [] array1 = {5,6,4};
        ArrayList<Integer> listA = new ArrayList<>(Arrays.asList(array1));
        SinglyNode l1 = SinglyNode.createLinkedList(listA);
        Integer [] array2 = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        ArrayList<Integer> listB = new ArrayList<>(Arrays.asList(array2));
        SinglyNode l2 = SinglyNode.createLinkedList(listB);
        SinglyNode target =  addTwoNumbers(l1, l2);
    }
}


class SinglyNode {
    Integer val;
    SinglyNode next;
    SinglyNode (Integer val) {
        this.val = val;
    }
    SinglyNode () {

    }
    SinglyNode (Integer val,SinglyNode next) {
        this.val =val;
        this.next = next;
    }
    public static SinglyNode createLinkedList(ArrayList<Integer> list) {
        SinglyNode head = new SinglyNode();
        SinglyNode tail = head;
        for (int i : list) {
            SinglyNode cur = new SinglyNode(i);
            tail.next = cur;
            tail = cur;
        }
        return head.next;
    }
}
