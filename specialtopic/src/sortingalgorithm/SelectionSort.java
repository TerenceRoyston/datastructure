package sortingalgorithm;

import java.util.Arrays;

/**
 * @author XuBowen
 * @date 2020/12/29 15:15
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 0, 9, 7};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {  //外循环，遍历数组中的第1~n-1个数
            for (int j = i + 1; j < arr.length; j++) {  //内循环，以外循环中的数为基点，与后面的每一个数相比较，如果大，则交换
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }*/

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
