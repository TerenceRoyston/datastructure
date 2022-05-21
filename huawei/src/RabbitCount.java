import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RabbitCount {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str=bf.readLine())!=null){
            int month = Integer.parseInt(str);
            System.out.println(rabbitCount(month));
        }
    }

    public static int rabbitCount(int month){
        if (month==1||month==2){
            return 1;
        }
        return rabbitCount(month-1)+rabbitCount(month-2);
    }
}
