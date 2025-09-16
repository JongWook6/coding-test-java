import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class Q19 {

    public static void main(String[] args) {
        String[] all = {"leo", "kiki", "eden"};
        String[] complete = {"eden", "kiki"};
        String result = solution(all, complete);
        System.out.println("result = " + result);
    }

    private static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s : participant) {
            if (!hashMap.containsKey(s)) {
                hashMap.put(s, 1);
            } else {
                Integer past = hashMap.get(s);
                hashMap.put(s, ++past);
            }
        }

        for (String s : completion) {
            if (hashMap.containsKey(s) && hashMap.get(s) == 1) {
                hashMap.remove(s);
            } else {
                Integer past = hashMap.get(s);
                hashMap.put(s, --past);
            }
        }

        return hashMap.keySet().stream().collect(Collectors.toList()).getFirst();
    }
}
