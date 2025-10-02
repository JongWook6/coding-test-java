import java.util.Arrays;

public class Greedy_Boat {

    private static int mySol(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int currentWeight = 0;

        for (int person : people) {
            if (currentWeight + person <= limit) {
                currentWeight += person;
                continue;
            }
            count++;
            currentWeight = person;
        }
        return ++count;
    }

    private static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int count = 0;
        int i = 0;
        int j = people.length - 1;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i += 1;
            }
            j -= 1;
            count += 1;
        }

        return count;
    }

    public static void main(String[] args) {
//        int[] people = {70, 50, 80, 50};
//        int limit = 100;
        int[] people = {70, 80, 50};
        int limit = 100;

        int result = solution(people, limit);
        System.out.println("result = " + result);
    }

}
