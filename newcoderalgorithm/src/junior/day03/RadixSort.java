package junior.day03;

import java.util.Arrays;

/**
 * @author XuBowen
 * @date 2021/1/16 13:00
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int bit = maxbits(arr);
        radixSort(arr, bit);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        int[] bucket = new int[arr.length];
        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix]; //代表十进制下各个数，包括0~9
            for (i = 0; i < arr.length; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {  //将count数组改为前缀和的形式
                count[i] = count[i] + count[i - 1];
            }
            for (i = arr.length - 1; i >= 0; i--) { //从右边往左边遍历，将数按照此轮循环中的目标位大小放入bucket数组中
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = 0; i < bucket.length; i++) {   //再将bucket数组中的数导出到arr原数组中
                arr[i] = bucket[i];
            }
        }
    }

    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        int bit = 0;  //bit指的是max一共有几位
        while (max != 0) {
            bit++;
            max = max / 10;
        }
        return bit;
    }

    public static int getDigit(int x, int d) {    //取出一个整数各个位上的数，重要方法，必须记住！！！
        int res = (x / (int) Math.pow(10, d - 1)) % 10;
        return res;
    }

}
