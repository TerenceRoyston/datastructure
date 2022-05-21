import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChickNums {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str=bf.readLine())!=null){
            Integer.parseInt(str);
            calChickNums();
        }

    }

    public static void calChickNums() {
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j < 34; j++) {
                for (int k = 0; k <= 300; k++) {
                    if (15 * i + 9 * j + k == 300) {
                        if (i + j + k == 100) {
                            System.out.println(i + " " + j + " " + k);
                        }
                    }
                }
            }
        }
    }
}
