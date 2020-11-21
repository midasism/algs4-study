package homework.one.three;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>{
    private Node<Item> first;     // top of stack
    private int n;                // size of the stack

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }

    //1.3.7 peek()：返回栈中最近添加的元素-栈顶  ---------------
    public Item peek() {
        //if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        if(isEmpty()) throw new EmptyStackException();
        return first.item;
    }

    //1.3.12 copy()
    public static Stack<String> copy(Stack<String> s) {
        Stack<String> res = new Stack<>();
        for (String str : s) {
            res.push(str);
        }
        return res;
    }

    @Override
    public Iterator iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Stack.Node<Item> cur = first;

        @Override
        public boolean hasNext() {
            return cur == null;
        }

        @Override
        public Item next() {
            Item res = cur.item;
            cur = cur.next;
            return res;
        }
    }
}
