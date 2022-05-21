package pending;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LC942DiStringMatch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDID")));
    }

    public static int[] diStringMatch(String S) {
        int[] arr = new int[S.length() + 1];
        Deque<Integer> deque = new LinkedList<>(); //使用双端队列解题，需要最大的就从最后取一个数；需要最小的就从最前取一个数
        for (int i = 0; i <= S.length(); i++) {
            deque.add(i);
        }
        for (int i = 0; i < S.length(); i++) {
            String s = String.valueOf(S.charAt(i));
            if (s.equals("I")) {
                arr[i] = deque.pollFirst();
            } else {
                arr[i] = deque.pollLast();
            }
        }
        arr[S.length()] = deque.pollLast();  //到这里队列只剩一个数了，直接取出放到数组最后即可
        return arr;
    }
}
