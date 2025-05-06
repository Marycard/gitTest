package collection.demo;

import java.util.*;

/*public class CollectionMap {
    public static void main(String[] args) {
        List<Student> list = List.of(
                new Student("Bob", 78),
                new Student("Alice", 85),
                new Student("Brush", 66),
                new Student("Newton", 99));
        var holder = new Students(list);
        System.out.println(holder.getScore("Bob") == 78 ? "���Գɹ�!" : "����ʧ��!");
        System.out.println(holder.getScore("Alice") == 85 ? "���Գɹ�!" : "����ʧ��!");
        System.out.println(holder.getScore("Tom") == -1 ? "���Գɹ�!" : "����ʧ��!");
    }
}*/

public class CollectionMap {
    public static void main(String[] args) {
/*      //����ıȽ�������score
  Map<Student, Integer> map = new TreeMap<>(
        new Comparator<Student>() {
            public int compare(Student p1, Student p2) {
                return Integer.compare(p1.score, p2.score);
            }
        }); //�ڴ���TreeMapʱ��ͬʱ��дһ��Comparator����*/
        Map<Student, Integer> map = new TreeMap<>(
                new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.name.compareTo(o2.name);
                    }
                }
        );
        map.put(new Student("Tom", 77), 1);
        map.put(new Student("Bob", 66), 2);
        map.put(new Student("Lily", 99), 3);
        for (Student key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println(map.get(new Student("Bob", 66))); // null?
    }

}


class Student {
    public String name;
    public int score;
    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String toString() {
        return String.format("{%s: score=%d}", name, score);
    }
}
/*
//����hashMap
class Students {
    List<Student> list;
    Map<String, Integer> cache;

    Students(List<Student> list) {
        this.list = list;
        cache = new HashMap<>();
    }

    */
/**
     * ����name����score���ҵ�����score��δ�ҵ�����-1
     *//*

    int getScore(String name) {
        // ����Map�в���:
        Integer score = this.cache.get(name);
        if (score == null) {
            // TODO:
            score = findInList(name);
            this.cache.put(name,score);
            System.out.println(score);
        }
        return score == null ? -1 : score.intValue();
    }

    Integer findInList(String name) {
        for (var ss : this.list) {
            if (ss.name.equals(name)) {
                return ss.score;
            }
        }
        return null;
    }
}

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}*/
