import java.util.Stack;

public class Q06 {

    public static void main(String[] args) {
//        stackStudy1();
        stackStudy2();
    }

    private static void stackStudy2() {
        Stack<Integer> stack = new Stack<>();
        stack.push(6);
        stack.push(5);

        System.out.println("stack.peek() = " + stack.peek());
        System.out.println(stack.pop());

        System.out.println("stack.size() = " + stack.size());
        stack.push(7);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("stack.size() = " + stack.size());
    }

    private static void stackStudy1() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(3);
        System.out.println("stack.isEmpty() = " + stack.isEmpty());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("stack.isEmpty() = " + stack.isEmpty());
    }
}
