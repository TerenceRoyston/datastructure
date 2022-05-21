package junior.day02;

import java.util.Arrays;

/*给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，
大于num的数放在数组的右边。要求额外空间复杂度O(1)，时间复杂度O(N)*/
public class NetherlandsFlag01 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 4, 7, 1, 0};
        netherlandsFlag(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void netherlandsFlag(int[] arr, int num) {
        int area = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                swap(arr, i, area + 1);
                area++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
