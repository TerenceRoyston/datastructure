package pending;

public class Interview1601SwapNumbers {

    public int[] swapNumbers(int[] numbers) {
        numbers[0]=numbers[0]^numbers[1];
        numbers[1]=numbers[0]^numbers[1];
        numbers[0]=numbers[0]^numbers[1];
        return numbers;
    }
}
