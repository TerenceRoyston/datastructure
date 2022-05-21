import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetSequeOddNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            int M = Integer.parseInt(str);
            String resStr = getSequeOddNum(M);
            System.out.println(resStr.substring(0, resStr.length() - 1));
        }
    }

    public static String getSequeOddNum(int M) {
        int a1 = M * M - M + 1;
        String str = "";
        for (int i = 0; i < M; i++) {
            str += a1 + "+";
            a1 += 2;
        }
        return str;
    }
}
