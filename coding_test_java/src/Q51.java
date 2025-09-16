import java.util.Arrays;

public class Q51 {

    private static int[] solution(int[] arr1, int[] arr2) {

        int[] merged = new int[arr1.length + arr2.length];
        int k = 0, i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            merged[k++] = arr1[i] <= arr2[j] ? arr1[i++] : arr2[j++];
        }

        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int[] result = solution(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
}
