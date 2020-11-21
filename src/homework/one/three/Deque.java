package homework.one.three;

public class Deque<Item> {
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

    Deque() {
        first = last = null;
        n = 0;
    }

    Deque(Item[] items) {
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
        s.append("Deque:[");
        Node temp = first;
        while (temp != null) {
            s.append(temp.item);
            if (temp.next != null) s.append("->");
            temp = temp.next;
        }
        s.append("]");
        return s.toString();
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    //队首（最左边）入队
    public void pushLeft(Item item) {
        if (n == 0) {
            first = last = new Node(item);
        } else {
            Node temp = first;
            first = new Node(item);
            first.next = temp;
        }
        n++;
    }

    //队首（最左边）出队
    public Item popLeft() {
        if (n == 0) throw new IllegalArgumentException("Deque is empty");
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

    //队尾（最右边）入队
    public void pushRight(Item item) {
        if (n == 0) {
            first = last = new Node(item);
        } else {
            last.next = new Node(item);
            last = last.next;
        }
        n++;
    }

    //队尾（最右边）出队
    public Item popRight() {
        if (n == 0) throw new IllegalArgumentException("Deque is empty");
        Item res = null;
        if (first == last) {
            res = first.item;
            first = last = null;
        } else {
            res = last.item;
            Node temp = first;
            while (temp.next != last) {
                temp = temp.next;
            }
            temp.next = null;
            last = temp;
        }
        n--;
        return res;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        Deque<Integer> s = new Deque<>(arr);
        System.out.println(s.toString());
        s.pushLeft(5);
        System.out.println(s.toString());
        System.out.println(s.popLeft());
        System.out.println(s.toString());
        s.pushRight(8);
        System.out.println(s.toString());
        System.out.println(s.popRight());
        System.out.println(s.toString());
    }
}
