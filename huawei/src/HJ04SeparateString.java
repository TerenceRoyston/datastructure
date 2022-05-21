import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ04SeparateString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null)
            separateString(str);
    }

    public static void separateString(String str) {
        if (str == null) return;    //如果为空，直接返回
        if (str.length() % 8 == 0) {    //如果字符串为8的整数倍，遍历分割
            int n = str.length() / 8;
            for (int i = 0; i < n; i++) {
                System.out.println(str.substring(i * 8, (i + 1) * 8));
            }
        } else {                                //如果字符串不是8的整数倍，先补0后再遍历分割
            int m = 8 - (str.length() % 8);
            while (m != 0) {
                str += "0";
                m--;
            }
            int n = str.length() / 8;
            for (int i = 0; i < n; i++) {
                System.out.println(str.substring(i * 8, (i + 1) * 8));
            }
        }
    }
}
