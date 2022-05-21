package junior.day02;

/**
 * @author XuBowen
 * @date 2021/1/7 14:29
 */
public class ReverseCouple {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5, 0};
        reverseCouple(arr);
    }

    /*public static void reverseCouple(int[] arr) {   //两层for循环，时间复杂度为O(n2)
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    System.out.println("(" + arr[i] + "," + arr[j] + ")");
                }
            }
        }
    }*/

    public static void reverseCouple(int[] arr) {   //经典归并排序
        if (arr == null || arr.length == 1) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            if (arr[p1] > arr[p2]) {        //因为左组和右组的数都是有序的。若p1指针大于p2指针，则p1指针后的所有数都大于p2指针，遍历一遍即可。
                for (int j = p1; j <= mid; j++) {
                    System.out.println("(" + arr[j] + "," + arr[p2] + ")");
                }
                help[i++] = arr[p2++];
            } else {
                help[i++] = arr[p1++];
            }
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}
