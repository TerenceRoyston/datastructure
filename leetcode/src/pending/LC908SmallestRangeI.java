package pending;

import java.util.Arrays;

public class LC908SmallestRangeI {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6};
        System.out.println(smallestRangeI(arr, 3));
    }

    public static int smallestRangeI(int[] A, int K) {
        if (A.length == 1) {
            return 0;
        }
        Arrays.sort(A);
        int min = A[0];
        int max = A[A.length - 1];
        if (max - min > 2 * K) {
            return max - min - 2 * K;
        } else {
            return 0;
        }
    }
}
