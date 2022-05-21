import java.util.*;

/**
 * 此题原先是我误解题意了，应该为每输入一组数据完成后就立刻输出对应的排序结果，而不是多组数据输入最终得到一个排序结果
 */
public class HJ03RandomNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            int amount = scanner.nextInt();
            while (amount != 0) {
                int num = scanner.nextInt();
                treeSet.add(num);
                amount--;
            }
            Iterator<Integer> iterator = treeSet.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }
}