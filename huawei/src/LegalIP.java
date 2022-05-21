import java.util.Scanner;

public class LegalIP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(judgeIP(str));
        }
    }

    public static String judgeIP(String str) {      //需要满足两个条件 1.共有四部分组成 2.每部分的数值在0-255之间
        String[] split = str.split("\\.");
        if (split.length != 4) return "NO";
        for (String s : split) {
            int part = Integer.parseInt(s);
            if (!(part >= 0 && part <= 255)) return "NO";
        }
        return "YES";
    }
}

