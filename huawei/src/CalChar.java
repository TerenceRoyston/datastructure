import java.util.HashSet;
import java.util.Scanner;

public class CalChar {
    public static void main(String[] args) {
        //System.out.println(calCharacter("abc"));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(calCharacter(str));
        }
    }

    public static int calCharacter(String str) {
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 0 && str.charAt(i) <= 127) {
                hashSet.add(str.charAt(i));
            }
        }
        return hashSet.size();
    }
}
