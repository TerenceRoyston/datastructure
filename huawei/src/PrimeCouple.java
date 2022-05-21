import java.util.*;

public class PrimeCouple {
    public static void main(String[] args) {
        //calPrimeCouple(20);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            calPrimeCouple(num);
        }
    }

    public static void calPrimeCouple(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {         //先将num以内的质数全部放到一个list中
            if (isPrimeNumber(i)) {
                list.add(i);
            }
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int j = 0; j < list.size(); j++) {         //双层for循环遍历，找出和是num的数，放入到集map中
            Integer x = list.get(j);
            if (x + x == num) hashMap.put(x, x);
            for (int k = j + 1; k < list.size(); k++) {
                Integer y = list.get(k);
                if (x + y == num) {
                    hashMap.put(x, y);
                }
            }
        }

        Set<Integer> set = hashMap.keySet();        //遍历map，找到最小差值
        Iterator<Integer> it = set.iterator();
        int numDiff = 20;
        while (it.hasNext()) {
            Integer prime1 = it.next();
            Integer prime2 = hashMap.get(prime1);
            numDiff = Math.min(Math.abs(prime1 - prime2), numDiff);
        }

        Iterator<Integer> it2 = set.iterator();     //再次遍历，找到差值对应的那一对，注意，要重新new一个迭代器，因为上一个已经到最后了
        while (it2.hasNext()) {
            Integer prime1 = it2.next();
            Integer prime2 = hashMap.get(prime1);
            if (Math.abs(prime1 - prime2) == numDiff) {
                System.out.println(prime1);
                System.out.println(prime2);
                break;
            }
        }
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
