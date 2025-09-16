import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Q21 {

    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
            "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        String[] result = solution(record);
        System.out.println(Arrays.toString(result));
    }

    private static String[] solution(String[] record) {

        HashMap<String, String> nicknameMap = new HashMap<>();
        ArrayList<String> answerList = new ArrayList<>();

        for(int i = 0; i < record.length; i++){
            String[] singleRecord = record[i].split(" ");
            String command = singleRecord[0];
            String id = singleRecord[1];

            if(command.equals("Enter")){
                nicknameMap.put(id, singleRecord[2]);
                answerList.add(id + "님이 들어왔습니다.");
            } else if (command.equals("Leave")){
                answerList.add(id + "님이 나갔습니다.");
            } else {
                nicknameMap.put(id, singleRecord[2]); // Change
            }
        }

        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            String sentence = answerList.get(i);

            for (String id : nicknameMap.keySet()) {
                if (sentence.contains(id)) {
                    String replaced = sentence.replace(id, nicknameMap.get(id));
                    answer[i] = replaced;
                }
            }
        }

        return answer;
    }
}
