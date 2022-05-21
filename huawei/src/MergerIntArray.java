import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class MergerIntArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            int num1 = scanner.nextInt();
            while (num1 != 0) {
                treeSet.add(scanner.nextInt());
                num1--;
            }
            int num2 = scanner.nextInt();
            while (num2 != 0) {
                treeSet.add(scanner.nextInt());
                num2--;
            }
            Iterator<Integer> it = treeSet.iterator();
            while (it.hasNext()) {
                System.out.print(it.next());
            }
            System.out.println();
        }
    }
}
