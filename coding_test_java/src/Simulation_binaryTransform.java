import java.util.Arrays;

public class Simulation_binaryTransform {

    public static int[] solution(String s) {
        int countTransform = 0;
        int countZero = 0;

        while (!s.equals("1")) {
            countTransform++;
            int zeros = s.replace("1", "").length();
            countZero += zeros;

            s = Integer.toBinaryString(s.length() - zeros);
        }

        return new int[]{countTransform, countZero};
    }

    public static void main(String[] args) {
        int[] result = solution("110010101001");
        System.out.println(Arrays.toString(result));
    }
}
