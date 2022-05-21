package junior.day02;

import java.util.Arrays;

/**
 * @author XuBowen
 * @date 2021/1/9 13:26
 * 快速排序1.0版，根据单边界荷兰国旗问题引申得到
 */

/*
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 0, 9, 7};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    public static int partition(int[] arr, int l, int r) {
        int area = l - 1;
        for (int i = l; i < r; i++) {
            if (arr[i] <= arr[r]) {
                swap(arr, i, area + 1);
                area++;
            }
        }
        swap(arr, r, area + 1);
        return area + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
*/

/**
 * 快速排序2.0版，根据双边界荷兰国旗问题引申得到
 */

/*
public class QuickSort {
    public static void main(String[] args) {
        //int[] arr = {2, 5, 1, 0, 9, 7};
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }

    }

    public static int[] partition(int[] arr, int l, int r) {
        int lessArea = l - 1;
        int moreArea = r;
        while (l < moreArea) {
            if (arr[l] < arr[r]) {
                swap(arr, l, lessArea + 1);
                lessArea++;
                l++;
            } else if (arr[l] > arr[r]) {
                swap(arr, l, moreArea - 1);
                moreArea--;
            } else {
                l++;
            }
        }
        swap(arr, moreArea, r);
        return new int[]{lessArea + 1, moreArea};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
*/

/**
 * 快速排序3.0版，随机选择标志位
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int lessArea = l - 1;
        int moreArea = r;
        while (l < moreArea) {
            if (arr[l] < arr[r]) {
                swap(arr, l, lessArea + 1);
                lessArea++;
                l++;
            } else if (arr[l] > arr[r]) {
                swap(arr, l, moreArea - 1);
                moreArea--;
            } else {
                l++;
            }
        }
        swap(arr, moreArea, r);
        return new int[]{lessArea + 1, moreArea};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
