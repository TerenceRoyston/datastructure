import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FindSymbolNum {
    public static void main(String[] args) throws IOException {
        /*BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = sb.readLine()) != null){

        }*/
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char sym = scanner.nextLine().charAt(0);
            System.out.println(findSymNum(str, sym));
        }
    }

    public static int findSymNum(String str, char sym) {
        if (!str.contains(String.valueOf(sym))) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equalsIgnoreCase(String.valueOf(sym))) {
                count++;
            }
        }
        return count;
    }
}
