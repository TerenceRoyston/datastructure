import java.util.*;

public class HJ45NameBeauty {
    public static void main(String[] args) {
        //System.out.println(getNameBeauty("lisi"));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            while (num != 0) {
                String name = scanner.next();
                System.out.println(getNameBeauty(name));
                num--;
            }
        }
    }

    public static int getNameBeauty(String name) {
        HashMap<Character, Integer> hashMap = new HashMap<>();      //统计每个字母出现的次数
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer value : hashMap.values()) {
            list.add(value);
        }
        Collections.sort(list);
        Collections.reverse(list);              //取出次数的集合从大到小排序
        int beauty = 0;
        for (int j = 26; j > 26 - list.size(); j--) {     //出现次数从大到小依次与26-0开始相乘
            beauty += j * list.get(26 - j);
        }
        return beauty;
    }
}
