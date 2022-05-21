import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HJ94CandidateName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int candidateNum = scanner.nextInt();
            ArrayList<String> list = new ArrayList<>();
            String candidateName = "";
            while (candidateNum != 0) {
                candidateName = scanner.next();
                list.add(candidateName);            //将候选人存为list
                candidateNum--;
            }
            int voterNum = scanner.nextInt();
            int count = voterNum;
            HashMap<String, Integer> hashMap = new HashMap<>();
            String voterName = "";
            while (voterNum != 0) {
                voterName = scanner.next();
                if (list.contains(voterName)) {
                    hashMap.put(voterName, hashMap.getOrDefault(voterName, 0) + 1); //将投票情况存入Map
                }
                voterNum--;
            }

            int valid = 0;
            for (String s : list) {     //注意这里遍历的是候选人列表，因为要按照此列表的名单顺序来
                if (hashMap.keySet().contains(s)/*&&hashMap.get(s)!=0*/) {
                    System.out.println(s + " : " + hashMap.get(s));
                    valid += hashMap.get(s);
                } else if (list.contains(s) && (!hashMap.keySet().contains(s))) {   //这里需要考虑在候选人名单里但是票数为0的情况
                    System.out.println(s + " : " + 0);
                }

            }
            int Invalid = count - valid;
            System.out.println("Invalid : " + Invalid);
        }
    }
}

