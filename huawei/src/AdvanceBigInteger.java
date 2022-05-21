import java.math.BigInteger;

public class AdvanceBigInteger {
    public static void main(String[] args) {
        System.out.println(calAdvanceBigInteger("-9876543210", "-1234567890")); //似乎在BigInteger中负数也能正常运算
    }


    public static String calAdvanceBigInteger(String str1,String str2){
        BigInteger big1 = new BigInteger(str1);
        BigInteger big2 = new BigInteger(str2);
        String resStr = big1.add(big2).toString();
        return resStr;
    }
}
