import java.util.*;

public class MergeTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int num = scanner.nextInt();
            int sum = num * 2;
            while (sum != 0) {
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                treeMap.put(key, treeMap.getOrDefault(key, 0) + value);
                sum -= 2;
            }

            Set<Integer> keySet = treeMap.keySet();
            Iterator<Integer> it = keySet.iterator();
            while (it.hasNext()) {
                Integer k = it.next();
                Integer v = treeMap.get(k);
                System.out.print(k + " " + v);
                System.out.println();
            }
        }
    }
}
