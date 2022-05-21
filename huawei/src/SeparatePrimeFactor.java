import java.util.ArrayList;
import java.util.Scanner;

public class SeparatePrimeFactor {
    public static void main(String[] args) {
        //System.out.println(separatePrimeFactor(45L));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long num = scanner.nextLong();
            System.out.println(separatePrimeFactor(num));
        }
    }

    public static String separatePrimeFactor(Long num) {
        if (isPrimeNumber(num)) return num + " ";           //递归，如果是质数则到了底层，返回
        ArrayList<Long> tmpList = new ArrayList<>();
        for (long i = 2; i < num / 2; i++) {                //将一个数所有的因数且是质数放到一个集合中
            if (num % i == 0 && isPrimeNumber(i)) tmpList.add(i);
        }

        String str = "";
        for (int j = 0; j < tmpList.size(); j++) {      //遍历集合，如果参数能整除，则整除后递归
            Long factor = tmpList.get(j);
            if (num % factor == 0) {
                str += factor + " " + separatePrimeFactor(num / factor);
                return str;
            }
        }
        return null;
    }

    public static boolean isPrimeNumber(long num) {      //判断质数
        if (num == 2) return true;
        if (num < 2 || num % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
