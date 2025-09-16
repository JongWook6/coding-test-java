import java.util.ArrayDeque;

public class Q09 {

    public static void main(String[] args) {
        System.out.println("solution(10) = " + solution(10));
        System.out.println("solution(13) = " + solution(13));
        String binaryString = Integer.toBinaryString(10);
        System.out.println("binaryString = " + binaryString);
        String test = "hello";
        System.out.println("test.substring(0, -1) = " + test.substring(0, 0));

    }

    public static String solution(int decimal) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (decimal != 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
