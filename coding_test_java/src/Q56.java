import java.util.Arrays;

public class Q56 {

    private static int[] solution(String s) {

        s = s.substring(0, s.length() - 2).replace("{", "");
        System.out.println("s = " + s);

        String[] arr = s.split("}, ");
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        System.out.println(Arrays.toString(arr));

        return null;
    }

    public static void main(String[] args) {
        String s = "{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}";
        int[] result = solution(s);
    }
}
