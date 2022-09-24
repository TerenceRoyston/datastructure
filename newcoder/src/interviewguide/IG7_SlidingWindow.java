package interviewguide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class IG7_SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7, 4};
        System.out.println(Arrays.toString(silding_2(arr, 3)));
    }


    public static int[] silding_1(int[] arr, int windowLength) {
        if (arr.length <= windowLength) {
            Arrays.sort(arr);
            return new int[]{arr[arr.length - 1]};
        }
        int[] res = new int[arr.length - windowLength + 1];
        int[] tmpArr = new int[windowLength];
        for (int i = 0; i <= arr.length - windowLength; i++) {
            for (int j = i; j < i + windowLength; j++) {
                tmpArr[j - i] = arr[j];
            }
            Arrays.sort(tmpArr);
            res[i] = tmpArr[tmpArr.length - 1];
            Arrays.fill(tmpArr, 0);
        }
        return res;
    }

    public static int[] silding_2(int[] arr, int windowLength) {
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            // when i is more than windowLength , take the first of Deque every step
            if (!deque.isEmpty() && i > windowLength - 1) {
                res.add(arr[deque.peekFirst()]);
            }

            // update the queue to clean items which are not in window range
            if (!deque.isEmpty() && deque.peekFirst() < i - windowLength + 1) {
                deque.pollFirst();
            }

            // use WHILE method to put i in the right position
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        // handle the rest situation of arr
        res.add(deque.pollFirst());

        // ArrayList<Integer> => Integer[] => int[]
        Integer[] resArr = res.toArray(new Integer[res.size()]);
        return Arrays.stream(resArr).mapToInt(Integer::valueOf).toArray();
    }
}