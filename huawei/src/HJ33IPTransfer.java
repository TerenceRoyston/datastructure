import java.math.BigInteger;
import java.util.Scanner;

public class HJ33IPTransfer {
    public static void main(String[] args) {
        //System.out.println(IPtoDec("10.0.3.193"));
        //System.out.println(DectoIP("167969729"));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String IPAddress = scanner.nextLine();
            System.out.println(IPtoDec(IPAddress));
            String decAddress = scanner.nextLine();
            System.out.println(DectoIP(decAddress));

        }
    }

    public static String IPtoDec(String ipAddress) {
        String[] split = ipAddress.split("\\.");
        String decAddress = "";
        for (String s : split) {
            s = Integer.toBinaryString(Integer.parseInt(s));
            int diff = 8 - s.length();
            while (diff != 0) {
                decAddress += "0";
                diff--;
            }
            decAddress += s;
        }

        //String.valueOf(Integer.parseInt(decAddress,2));
        return new BigInteger(decAddress, 2).toString(10);      //最后拼接出的二进制数太大，对应十进制超出范围，使用BigInteger
    }

    public static String DectoIP(String decAddress) {
        String binAddress = new BigInteger(decAddress, 10).toString(2);
        String tmp = "";
        int diff = binAddress.length() % 8;
        if (diff != 0) {  //注意，这里如果刚好为32位，就不要再加0了
            while (diff != 8) {
                tmp += "0";
                diff++;
            }
        }
        binAddress = tmp + binAddress;

        String ipAddress = "";
        for (int i = 0; i < binAddress.length(); i++) {
            String binpart = binAddress.substring(i, i + 8);
            String decpart = String.valueOf(Integer.parseInt(binpart, 2));
            ipAddress += decpart + ".";
            i = i + 7;
        }
        ipAddress = ipAddress.substring(0, ipAddress.length() - 1);
        return ipAddress;
    }
}
