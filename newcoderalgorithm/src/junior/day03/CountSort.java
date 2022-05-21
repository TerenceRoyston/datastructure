package junior.day03;

import java.util.Arrays;

/**
 * @author XuBowen
 * @date 2021/1/15 22:18
 */
public class CountSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countSort(int[] arr) {   //经典桶排序思想，将数组中所有的数都映射成一个新数组的下标，对应的值为相同数字的个数
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        int[] bucket = new int[max + 1];
        for (int i : arr) {
            bucket[i]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j] != 0) {
                arr[i++] = j;
                bucket[j]--;
            }
        }
    }
}
