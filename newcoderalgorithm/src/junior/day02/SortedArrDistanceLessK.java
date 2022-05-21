package junior.day02;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author XuBowen
 * @date 2021/1/11 16:59
 */
public class SortedArrDistanceLessK {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        sortedArrDistanceLessK(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortedArrDistanceLessK(int[] arr, int k) {   //优先队列，类似于小根堆结构。以黑盒的形式，放入一个数，出来一个数
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index < k; index++) {    //for循环第一个位置用于赋予初始值，若变量已在外部赋值，则此处可以留空
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; index++, i++) {
            heap.add(arr[index]);   //优先队列中元素默认按自然顺序排列，也就是数字默认是小的在队列头，字符串则按字典序排列。
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}
