public class Q50 {

    private static String solution(String s) {

        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        StringBuilder sortedStr = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sortedStr.append((char) ('a' + i));
            }
        }

        return sortedStr.toString();
    }

    public static void main(String[] args) {
        String result = solution("hello");
        System.out.println("result = " + result);
    }

}
