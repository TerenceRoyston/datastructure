package sortingalgorithm;

import java.util.Arrays;

/**
 * @author XuBowen
 * @date 2021/1/11 12:46
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {  //heapInsert方法是每新添加一个数，就重新调整堆结构，使其形成大根堆
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);   //所有数添加完成后，形成一个大根堆，第一个数为最大值。将第一个数与最后一个数交换，那么最大值到了最后
        while (size > 0) {          //将这个最大值与大根堆断开联系，就是--size，并使用hepify方法使得剩下的数重新形成大根堆。重复上述操作
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        while (left < size) {
            int largest = right < size && arr[right] > arr[left] ? right : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
