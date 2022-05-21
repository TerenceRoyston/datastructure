import java.util.*;

public class ExamScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int method = scanner.nextInt();
            LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
            ArrayList<Integer> list = new ArrayList<>();
            while (num != 0) {
                String name = scanner.next();
                int score = scanner.nextInt();
                list.add(score);
                linkedHashMap.put(name + " " + score, score);  //用姓名+分数作key
                num--;
            }
            if (method == 1) {
                Collections.sort(list);
            } else if (method == 0) {
                Collections.sort(list);  //先正序排序，再逆序排列
                Collections.reverse(list);
            }
            int cur = -1;
            for (Integer i : list) {
                if (cur == i) {
                    continue;
                }

                for (String s : linkedHashMap.keySet()) {
                    if (linkedHashMap.get(s) == i) {
                        System.out.println(s);
                    }
                }
                cur = i;        //如果分数重复，则此分数跳过，因为遍历时已经全部输出了
            }
        }
    }
}

