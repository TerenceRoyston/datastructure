import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArithmeticProgression {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str=br.readLine())!=null){
            int n=Integer.parseInt(str);
            if (n<=0){
                System.out.println(-1);
            }else {
                System.out.println(sumNTerms(n));
            }
        }
    }

    public static int sumNTerms(int n){
        int sum=2*n+n*(n-1)*3/2;
        return sum;
    }
}
