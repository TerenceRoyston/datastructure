import java.util.*;

public class DeleteLastString {
    public static void main(String[] args) {
        //System.out.println(deleteString("abcdd"));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(deleteString(str));
        }
    }

    public static String deleteString(String str) {
        int[] arr = new int[26];
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            arr[c - 97]++;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                hashMap.put(String.valueOf((char) (i + 97)), arr[i]);
            }
        }

        int minTimes = 100;
        for (Integer value : hashMap.values()) {
            minTimes = Math.min(minTimes, value);
        }

        String resString = "";
        for (char c : charArray) {
            if (hashMap.get(String.valueOf(c)) != minTimes) {
                resString += c;
            }
        }
        return resString;
    }
}


/*import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class DeleteLastString {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(deleteString(str));
        }
    }

    public static String deleteString(String str){
        LinkedHashMap<Character,Integer> linkedHashMap = new LinkedHashMap<>();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            linkedHashMap.put(c,linkedHashMap.getOrDefault(c,0)+1);
        }

        int min=Integer.MAX_VALUE;
        for (Character key : linkedHashMap.keySet()) {
            if (min>linkedHashMap.get(key)){
                min=linkedHashMap.get(key);
            }
        }

        String resStr="";
        for (char c : arr) {
            if (linkedHashMap.get(c)!=min) resStr+=c;
        }
        return resStr;
    }
}*/

