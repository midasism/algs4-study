/**
 * Steque 基于队列的栈
 */
package homework.one.three;

public class Steque<Item> {
    private class Node {
        public Item item;
        public Node next;

        Node() {
            next = null;
        }

        Node(Item item) {
            this.item = item;
            next = null;
        }
    }

    private Node first;
    private Node last;
    private int n;

    Steque() {
        first = last = null;
        n = 0;
    }

    Steque(Item[] items) {
        n = items.length;
        if (items.length == 0) return;
        first = new Node(items[0]);
        Node temp = first;
        for (int i = 1; i < items.length; i++) {
            temp.next = new Node(items[i]);
            temp = temp.next;
        }
        last = temp;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Steque:[");
        Node temp = first;
        while (temp != null) {
            s.append(temp.item);
            if (temp.next != null) s.append("->");
            temp = temp.next;
        }
        s.append("]");
        return s.toString();
    }

    //入栈
    public void push(Item item) {
        if (n == 0) {
            first = last = new Node(item);
        } else {
            Node temp = first;
            first = new Node(item);
            first.next = temp;
        }
        n++;
    }

    //出栈
    public Item pop() {
        if (n == 0) throw new IllegalArgumentException("Steque is empty");
        Item res = null;
        if (first == last) {
            res = first.item;
            first = last = null;
        } else {
            res = first.item;
            Node temp = first.next;
            first.next = null;
            first = temp;
        }
        n--;
        return res;
    }

    //入队
    public void enqueue(Item item) {
        if (n == 0) {
            first = last = new Node(item);
        } else {
            last.next = new Node(item);
            last = last.next;
        }
        n++;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        Steque<Integer> s = new Steque<>(arr);
        System.out.println(s.toString());
        s.enqueue(5);
        System.out.println(s.toString());
        s.push(6);
        System.out.println(s.toString());
        System.out.println(s.pop());
        System.out.println(s.toString());
    }
}
