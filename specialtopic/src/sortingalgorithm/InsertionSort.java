package sortingalgorithm;

import java.util.Arrays;

/**
 * @author XuBowen
 * @date 2020/12/29 22:38
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 0, 9, 7};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
