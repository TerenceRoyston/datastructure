package pending;

import java.util.Arrays;

public class Offer17PrintNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers2(1)));
    }

    public static int[] printNumbers(int n) {
        String num = "1";
        while (n != 0) {
            num += "0";
            n--;
        }
        int length = Integer.parseInt(num) - 1;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public static int[] printNumbers2(int n) {
        int num = (int) Math.pow(10, n) - 1;
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}
