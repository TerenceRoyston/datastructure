import java.util.Scanner;

public class ReverseSentence {
    public static void main(String[] args) {
        //System.out.println(reverseSentence("I am a boy"));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(reverseSentence(str));
        }
    }

    public static String reverseSentence(String str) {
        String[] split = str.split(" ");
        String sentence = "";
        for (int i = split.length - 1; i >= 0; i--) {
            sentence += split[i] + " ";
        }
        return sentence.substring(0, sentence.length() - 1);
    }
}
