public class Simulation_teleportation {

    private static int mySolution(int n) {
        int position = n;
        int jumpCnt = 0;

        while (position != 0) {
            if (position % 2 == 0) {
                position /= 2;
            } else {
                position -= 1;
                jumpCnt++;
            }
        }
        return jumpCnt;
    }

    private static int answer(int n) {
        return Integer.toBinaryString(n).replace("0", "").length();
    }

    public static void main(String[] args) {
        int result = answer(5000);
        System.out.println("result = " + result);
    }
}
