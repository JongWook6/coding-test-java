import java.util.ArrayList;
import java.util.Arrays;

public class Greedy_Knapsack {

    private static class Item {
        int weight;
        int value;
        double valuePerWeight;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.valuePerWeight = (double) value / weight;
        }
    }

    private static double mySol(int[][] items, int weight_limit) {

        ArrayList<Item> list = new ArrayList<>();

        for (int i = 0; i < items.length; i++) {
            list.add(new Item(items[i][0], items[i][1]));
        }

        list.sort(((o1, o2) -> Double.compare(o2.valuePerWeight, o1.valuePerWeight)));

        double answer = 0;

        for (int i = 0; i < list.size(); i++) {
            if (weight_limit == 0) {
                continue;
            }

            Item item = list.get(i);
            if (item.weight <= weight_limit) {
                answer += item.value;
                weight_limit -= item.weight;
            } else {
                answer += weight_limit * item.valuePerWeight;
                weight_limit = 0;
            }
        }

        return answer;
    }

    private static double solution(int[][] items, int weight_limit) {

        Item[] item = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            item[i] = new Item(items[i][0], items[i][1]);
        }

        Arrays.sort(item, ((o1, o2) -> Double.compare(o2.valuePerWeight, o1.valuePerWeight)));

        double totalValue = 0;
        int remainingWeight = weight_limit;

        for (Item i : item) {

            if (i.weight <= remainingWeight) {
                totalValue += i.value;
                remainingWeight -= i.weight;
            } else {
                totalValue += remainingWeight * i.valuePerWeight;
                remainingWeight = 0;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
//        int[][] items = {{10, 19}, {7, 10}, {6, 10}};
//        int weigh_limit = 15;
        int[][] items = {{10, 60}, {20, 100}, {30, 120}};
        int weigh_limit = 50;
        double result = solution(items, weigh_limit);
        System.out.println("result = " + result);
    }
}
