package sortingalgorithm;

import java.util.Arrays;

/**
 * @author XuBowen
 * @date 2020/12/29 16:39
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 0, 9, 7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }*/

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        boolean flag = false;
        for (int i = arr.length - 1; i > 0; i--) {  //外循环仅标志循环的次数，具体不参与逻辑
            for (int j = 0; j < i; j++) {  //内循环为相邻的两元素相互比较
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    swap(arr, j, j + 1);
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
