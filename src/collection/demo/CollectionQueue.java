package collection.demo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class CollectionQueue {
    public static void main(String[] args) {
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        // ���3��Ԫ�ص�����:
        q.offer(new User("Bob", "A2"));
        q.offer(new User("Alice", "A10"));
        q.offer(new User("Boss", "V1"));
        q.offer(new User("Boss2", "V2"));
        q.offer(new User("Boss3", "V10"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,��Ϊ����Ϊ��
        System.out.println(q.poll()); // null,��Ϊ����Ϊ��
        System.out.println(q.poll()); // null,��Ϊ����Ϊ��

    }
}

class UserComparator implements Comparator<User> {
    public int compare(User u1, User u2) {
        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            // ������˵ĺŶ���A��ͷ���߶���V��ͷ,�ȽϺŵĴ�С:
//            return u1.number.compareTo(u2.number);
            int num1 = Integer.parseInt(u1.number.substring(1));
            int num2 = Integer.parseInt(u2.number.substring(1));
            return Integer.compare(num1, num2);
        }
        if (u1.number.charAt(0) == 'V') {
            // u1�ĺ�����V��ͷ,���ȼ���:
            return -1;
        } else {
            return 1;
        }
    }
}

class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}