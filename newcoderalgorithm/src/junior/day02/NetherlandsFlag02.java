package junior.day02;

import java.util.Arrays;

public class NetherlandsFlag02 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 3, 4, 7, 1, 0};
        netherlandsFlag(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void netherlandsFlag(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int lessArea = left - 1;
        int moreArea = right + 1;
        while (left < moreArea) {
            if (arr[left] < num) {
                swap(arr, left, lessArea + 1);
                lessArea++;
                left++;
            } else if (arr[left] > num) {
                swap(arr, left, moreArea - 1);
                moreArea--;
            } else {
                left++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
