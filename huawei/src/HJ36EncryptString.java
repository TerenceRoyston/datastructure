import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HJ36EncryptString {
    public static void main(String[] args) {
        //System.out.println(encryptString("nihao", "ni"));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String key = scanner.next();
            String str = scanner.next();
            System.out.println(encryptString(key, str));
        }
    }

    public static String encryptString(String key, String str) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        ArrayList<Character> keyList = deDuplicate(key);
        int index = 0;
        for (int i = 0; i < keyList.size(); i++) {
            hashMap.put((char) (i + 65), keyList.get(i));
            index = i;             //秘钥与字母表逐一对应，index将第一次对应遍历完成的位置记录，交给下一次遍历的初始位置。
        }

        for (int j = index + 1 + 65; j <= 90; j++) {        //拿到index位置，从index+1位置处开始遍历
            for (int k = 65; k <= 90; k++) {                //从A开始，判断list中是否出现，如果没有出现过，拿出来与字母表逐一对应
                if (keyList.contains((char) k)) continue;
                hashMap.put((char) j, (char) k);
                j = j + 1;
            }
        }

        String resStr = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) {     //拿到数组，逐一判断，如果是小写，转成大写后找到对应密码再转成小写
                resStr += (char) (hashMap.get((char) (c - 32)) + 32);
            } else {                //是大写的话直接找到密码即可
                resStr += hashMap.get(c);
            }
        }
        return resStr;
    }

    public static ArrayList deDuplicate(String key) {    //字符串去重
        key = key.toUpperCase();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!list.contains(c)) {
                list.add(c);
            }
        }
        return list;
    }
}
