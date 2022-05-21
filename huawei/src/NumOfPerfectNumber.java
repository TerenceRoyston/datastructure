import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NumOfPerfectNumber {
    public static void main(String[] args) throws IOException {
        //System.out.println(findPerfectNum(1000));
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = sb.readLine()) != null) {
            int n = Integer.parseInt(str);
            System.out.println(findPerfectNum(n));
        }
    }

    public static int findPerfectNum(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> tmplist = new ArrayList<>();
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    tmplist.add(j);
                }
            }
            int count = 0;
            for (Integer num : tmplist) {
                count += num;
            }
            if (count == i) {
                list.add(i);
            }
        }
        return list.size();
    }
}


