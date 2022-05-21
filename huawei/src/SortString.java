import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SortString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            int amount = Integer.parseInt(str);
            ArrayList<String> list = new ArrayList<>();
            while (amount != 0) {
                list.add(br.readLine());
                amount--;
            }
            Collections.sort(list);
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
