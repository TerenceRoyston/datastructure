import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcCapital {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            System.out.println(calcCapital(str));
        }
    }

    public static int calcCapital(String str) {
        int upperCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 65 && c <= 90) {
                upperCount++;
            }
        }
        return upperCount;
    }
}
