import java.util.HashMap;
import java.util.Set;

public class Q20 {

    public static void main(String[] args) {

    }

    private static int solution(String[] want, int[] number, String[] discount) {

        // 쇼핑목록
        HashMap<String, Integer> shoppingMap = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            shoppingMap.put(want[i], number[i]);
        }

        int answer = 0;

        // 할인목록
        for(int i = 0; i < discount.length - 9; i++){

            HashMap<String, Integer> discountMap = new HashMap<>();
            for(int j = i; j < i + 10; j++){
                if(discountMap.containsKey(discount[j])){
                    discountMap.put(discount[j], discountMap.get(discount[j]) + 1);
                } else {
                    discountMap.put(discount[j], 1);
                }
            }

            if(shoppingMap.equals(discountMap)){
                answer++;
            }
        }

        return answer;
    }
}
