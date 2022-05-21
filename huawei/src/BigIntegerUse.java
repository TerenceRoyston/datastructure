import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerUse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.next();
            String str2 = scanner.next();
            System.out.println(useBigInteger(str1, str2));
        }
    }

    public static String useBigInteger(String str1, String str2) {
        BigInteger big1 = new BigInteger(str1);
        BigInteger big2 = new BigInteger(str2);
        String resStr = big1.add(big2).toString();
        return resStr;
    }
}
