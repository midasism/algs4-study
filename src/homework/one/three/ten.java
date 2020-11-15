/**
 * 1.3.10 中序表达式转化为后序表达式
 * 思路：按输入顺序尾插入链表，当输入右括号)时，从链表尾弹出符号和右操作数两个元素（这里的元素可以是单个数字、符号，也可以是一对括号包裹起来的整体），再逆置尾插入链表
 * （1+1 ')' --> 弹出 + 1 -->  逆序尾插入链表  --> （11 --> （11+ --> （11+）
 */
package homework.one.three;

import edu.princeton.cs.algs4.StdIn;

import java.util.LinkedList;

public class ten {
    public static void InfixToPostfix() {
        LinkedList<Character> list = new LinkedList<>();
        while (!StdIn.isEmpty()) {
            char c = StdIn.readChar();
            if (c != ')') list.addLast(c);
            else {//逆序读出两个元素
                LinkedList<LinkedList<Character>> temp = new LinkedList<>();
                for (int i = 0; i < 2; i++) {
                    temp.addLast(new LinkedList<>());
                    if (list.getLast() != ')') temp.get(i).addFirst(list.removeLast());
                    else {
                        int rightN = 1;
                        temp.get(i).addFirst(list.removeLast());
                        while (rightN > 0) {
                            if (list.getLast() == ')') rightN++;
                            else if (list.getLast() == '(') rightN--;
                            temp.get(i).addFirst(list.removeLast());
                        }
                    }
                }
                //重新写入链表
                for (int i = 0; i < 2; i++) {
                    for (char c1 : temp.get(i)) {
                        list.addLast(c1);
                    }
                }
                list.addLast(')');//
            }
        }
        for (char c : list) System.out.print(c);
    }

    public static void main(String[] args) {
        InfixToPostfix();
    }
}
// ((1+2)*((3-4)*(5-6)))
