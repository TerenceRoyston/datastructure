import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HexToDec {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null)
            System.out.println(hexToDec(str));
    }

    public static long hexToDec(String str) {
        return Long.parseLong(str.substring(2), 16);    //测试用例中前两位是0x，要去掉
    }
}
