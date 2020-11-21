package homework.one.three;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

public class fifteen {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        int k = StdIn.readInt();
        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }
        while (queue.size() > k) queue.dequeue();
        System.out.println(queue.dequeue());
    }
}
