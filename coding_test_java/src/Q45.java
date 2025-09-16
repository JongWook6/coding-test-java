import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q45 {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(1);

        System.out.println(pq);

        System.out.println(pq.poll());
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq);
        System.out.println();

        PriorityQueue<String> pqs = new PriorityQueue<>(Comparator.comparingInt(o -> o.charAt(1)));

        pqs.add("hello");
        pqs.add("car");

        System.out.println(pqs);
        System.out.println(pqs.poll());
        System.out.println(pqs.poll());
        System.out.println();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(20);
        list.add(1);

        PriorityQueue<Integer> pql = new PriorityQueue<>(list);
        System.out.println(pql.poll());
        System.out.println(pql.poll());
        System.out.println(pql);

    }
}
