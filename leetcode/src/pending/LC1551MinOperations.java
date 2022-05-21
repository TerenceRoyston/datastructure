package pending;

public class LC1551MinOperations {

    public int minOperations(int n) {
        int minNum=0;
        for (int i=0;i<n;i++){
            int diff=2*i+1-n;
            minNum+=diff>0?diff:0;
        }
        return minNum;
    }
}
