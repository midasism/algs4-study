import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) ;
            else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {//右括号 操作数和运算符出栈进行计算
                String op = ops.pop();
//                double v = vals.pop();
                if (op.equals("+")) vals.push(vals.pop() + vals.pop());
                else if (op.equals("-")) vals.push(vals.pop() - vals.pop());
                else if (op.equals("*")) vals.push(vals.pop() * vals.pop());
                else if (op.equals("/")) vals.push(vals.pop() / vals.pop());
                else if (op.equals("sqrt")) vals.push(Math.sqrt(vals.pop()));
            }
            else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }
}
