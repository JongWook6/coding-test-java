import java.util.Arrays;
import java.util.Scanner;

public class Simulation_rotation {

    private static Scanner sc;

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        sc = new Scanner(System.in);
        System.out.print("시계 방향 회전 수 : ");
        int cnt = sc.nextInt();


        for (int i = 0; i < cnt; i++) {
            arr = solution(arr);
        }

        // 확인
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int[][] solution(int[][] arr) {
        int N = arr.length;
        int[][] rotated = new int[N][N];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
//                rotated[i][j] = arr[j][(N - 1) - i];
                 rotated[j][(N - 1) - i] = arr[i][j];
            }
        }
        return rotated;
    }


}
