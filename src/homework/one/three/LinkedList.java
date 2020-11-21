package homework.one.three;

public class LinkedList<Item> {
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
    private int n;

    LinkedList() {
        n = 0;
        first = null;
    }

    LinkedList(Item[] items) {
        n = items.length;
        if (items.length == 0) return;
        first = new Node(items[0]);
        Node cur = first;
        for (int i = 1; i < items.length; i++) {
            cur.next = new Node(items[i]);
            cur = cur.next;
        }
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void deleteLast() {
        if (isEmpty()) throw new IllegalArgumentException("first is null");
        if (n == 1) first = null;
        else {
            Node cur = first;
            while (cur.next.next != null)
                cur = cur.next;
            cur.next = null;
        }
        n--;
    }

    //1.3.20 删除第k个节点
    public void delete(int k) {
        if (k < 1 || k > n) throw new IllegalArgumentException("index is illegal.");
        Node cur = first;
        for (int i = 0; i < k - 2; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        n--;
    }

    //1.3.21
    public boolean find(LinkedList<Item> list, Item key) {
        Node cur = list.first;
        while (cur != null) {
            if (cur.item == key) return true;
        }
        return false;
    }

    //1.3.24
    private void removeAfter(Node node) {
        if (node == null || node.next == null) return;
        node.next = node.next.next;
    }

    //1.3.25
    private void insertAfter(Node first, Node last) {
        if (first == null || last == null) return;
        Node temp = first.next;
        first.next = last;
        last.next = temp;
    }

    //1.3.26
    public void remove(LinkedList<Item> list, Item key) {
        Node cur = new Node();
        cur.next = list.first;
        while (cur.next != null) {
            if (cur.next.item == key) {
                Node temp = cur.next;
                cur.next = cur.next.next;
                //待删除节点若为头节点，删除后需要更新list.first的值
                if (temp == list.first) {
                    list.first = cur.next;
                }
                temp.next = null;
                temp = null;
            } else {
                cur = cur.next;
            }
        }
    }

    //1.3.27
//    public int max() {
//        if (first == null) throw new IllegalArgumentException("linkedlist is empty");
//    }

    //1.3.28

    //1.3.29

    //1.3.30

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("LinkedList[");
        Node cur = first;
        while (cur != null) {
            s.append(cur.item);
            if (cur.next != null) s.append("->");
            cur = cur.next;
        }
        s.append("]");
        return s.toString();
    }

    public static void main(String[] args) {
        Integer[] a = {1, 3, 4, 5};
        Integer[] b = {1, 1, 1, 3, 1, 4};
        LinkedList<Integer> list = new LinkedList<>(a);
        System.out.println(list.toString());
        list.deleteLast();
        System.out.println(list.toString());
        list.delete(2);
        System.out.println(list.toString());
        LinkedList<Integer> list2 = new LinkedList<>(b);
        list.remove(list2, 1);
        System.out.println(list2);
    }
}
