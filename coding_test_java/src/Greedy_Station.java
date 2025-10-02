public class Greedy_Station {

    private static boolean[] isInRange;
    private static int range;

    private static int mySol(int n, int[] stations, int w) {

        isInRange = new boolean[n + 1];
        isInRange[0] = true;
        range = w;

        for (int station : stations) {
            setTrueInRange(station);
        }

        int additional = 0;

        for (int i = 1; i < n + 1; i++) {
            if (isInRange[i]) {
                continue;
            }

            int position = getBestPosition(i);
            setTrueInRange(position);
            additional++;
        }

        return additional;
    }

    private static void setTrueInRange(int station) {
        for (int i = station - range; i <= Math.min(station + range, isInRange.length - 1); i++) {
            isInRange[i] = true;
        }
    }

    private static int getBestPosition(int now) {
        for (int i = Math.min(now + range, isInRange.length - 1); i >= now ; i--) {
            if (!isInRange[i]) {
                return i;
            }
        }
        return now;
    }

    private static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int location = 1;
        int idx = 0;

        while (location <= n) {
            if (idx < stations.length && location >= stations[idx] - w) {
                location = stations[idx] + w + 1;
                idx++;
            } else {
                location += 2 * w + 1;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 16;
        int[] stations = {9};
        int w = 2;
        int result = solution(n, stations, w);
        System.out.println("result = " + result);
    }
}
