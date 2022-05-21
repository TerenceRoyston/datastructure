package pending;

import java.util.ArrayList;
import java.util.List;

public class LC728SelfDividingNumbers {

    public static void main(String[] args) {
        List<Integer> list = selfDividingNumbers(1, 22);
        StringBuffer sb = new StringBuffer();
        for (Integer i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumbers(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static boolean isSelfDividingNumbers(int num) {
        String str = String.valueOf(num);
        if (str.contains("0")) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            int m = Integer.parseInt(String.valueOf(str.charAt(i)));
            if (num % m != 0) {
                return false;
            }
        }
        return true;
    }
}
