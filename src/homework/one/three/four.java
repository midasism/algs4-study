/**
 * 1.3.4 括号匹配
 */
package homework.one.three;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

public class four {
    public static boolean bracketMapping() {
        Stack<Character> s = new Stack<>();
        while (!StdIn.isEmpty()) {
            char bracket = StdIn.readChar();
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                s.push(bracket);
            } else if (bracket == ')' && s.pop().equals('(')) ;
            else if (bracket == ']' && s.pop().equals('[')) ;
            else if (bracket == '}' && s.pop().equals('{')) ;
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(bracketMapping());
        //[()]{}{[()()]()} true
        //[(]) false
    }
}
