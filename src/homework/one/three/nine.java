/**
 * 思路：按输入顺序尾插入链表，当输入右括号)时，从链表尾弹出三个元素（这里的元素可以是单个数字、符号，也可以是一对括号包裹起来的整体），将弹出元素看做整体，左右分别添加括号，再重新尾插入链表
 */
package homework.one.three;

import edu.princeton.cs.algs4.StdIn;

import java.util.LinkedList;

public class nine {
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        while (!StdIn.isEmpty()) {
            char c = StdIn.readChar();
            if (c != ')') list.addLast(c);
            else {
                int rightN = 0;//右括号数量
                LinkedList<Character> temp = new LinkedList<>();
                for (int i = 0; i < 3; i++) {
                    if (list.getLast() != ')')
                        temp.addFirst(list.removeLast());
                    else {
                        rightN++;
                        temp.addFirst(list.removeLast());
                        while (rightN != 0) {
                            if (list.getLast() == '(') rightN--;
                            else if (list.getLast() == ')') rightN++;
                            temp.addFirst(list.removeLast());
                        }
                    }
                }
                list.addLast('(');
                for (char t : temp)
                    list.addLast(t);
                list.addLast(')');
            }
        }
        for (char c : list) System.out.print(c);
    }
}
//1+2)*3-4)*5-6)))
