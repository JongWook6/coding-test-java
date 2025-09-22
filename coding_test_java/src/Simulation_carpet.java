import java.util.Arrays;

public class Simulation_carpet {

    private static int[] mySolution(int red, int white) {

        int total = red + white;
        int height = 3;
        int width;

        while (true) {
            width = (red - 2 * height) / 2 + 2;
            if (height * width == total) {
                break;
            }
            height++;
        }

        return new int[]{width, height};
    }

    private static int[] answer(int red, int white) {

        int totalArea = red + white;
        double sqrt = Math.sqrt(totalArea);

        for (int vertical = 3; vertical <= sqrt ; vertical++) {
            if (totalArea % vertical == 0) {
                int horizontal = totalArea / vertical;
                if ((vertical + horizontal) * 2 - 4 == red) {
                    return new int[]{horizontal, vertical};
                }
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int red = 24, white = 24;
        int[] result = answer(red, white);
        System.out.println(Arrays.toString(result));
    }
}
