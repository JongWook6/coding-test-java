import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Q24 {
    // 만들 수 있는 메뉴 구성 & 총 주문 수를 저장할 해시맵
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;

    public String[] solution(String[] orders, int[] course) {
        // 해시맵 초기화
        courseMap = new HashMap<>();
        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }

        // 코스를 배열로 만들고 오름차순 정렬해서 가능한 모든 메뉴 구성을 구함
        for (String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }

        ArrayList<String> answer = new ArrayList<>();

        // 모든 코스 후보에 대해서
        for (HashMap<String, Integer> count : courseMap.values()) {
            count.values()
                .stream()
                .max(Comparator.comparingInt(o -> o))
                .ifPresent(cnt -> count.entrySet()
                        .stream()
                        .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                        .forEach(entry -> answer.add(entry.getKey())));
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    // 만들 수 있는 모든 조합을 재귀 함수를 이용해서 구현
    private void combinations(int idx, char[] order, String result) {
        // 필요한 코스 메뉴의 수와 일치하는 것만 저장
        if (courseMap.containsKey(result.length())) {
            HashMap<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result, 0) + 1);
        }

        for (int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }
    }
}
