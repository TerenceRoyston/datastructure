import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RecordFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        /*
        ArrayList<String> list = new ArrayList<>();
        list.add("F:\\oteh\\ti\\urajfw\\tlrlr 636");
        list.add("C:\\crdp\\qwptjlorrmnv 642");
        list.add("D:\\kcl\\fqzs\\zlm\\pgdiwvceluyzft 640");
        list.add("G:\\faxpyhyznsssbo 639");
        list.add("D:\\swnhezhgdcwwbmkyqt 637");
        list.add("D:\\azo\\sry\\faxpyhyznsssbo 633");
        list.add("C:\\beqt\\eh\\dm\\dlhehjccfdgrrzyj 642");
        list.add("F:\\lepvz 635");
        handleRecord(list);
        */
        LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>();
        while (scanner.hasNext()){
            String fileName = scanner.next();
            int lineNum = scanner.nextInt();
            String[] split = fileName.split("\\\\");
            fileName= split[split.length - 1];
            if (fileName.length()>16){
                fileName=fileName.substring(fileName.length()-16);
            }
            String key=fileName+" "+lineNum;
            hashMap.put(key,hashMap.getOrDefault(key,0)+1);
        }
        /*Set<String> keySet = hashMap.keySet();
        Iterator<String> it = keySet.iterator();
        ArrayList<String> resList = new ArrayList<>();
        while (it.hasNext()){
            String key = it.next();
            Integer value = hashMap.get(key);
            resList.add(key+" "+value);
        }
        for (int i=resList.size()-8;i<resList.size();i++){
            String str = resList.get(i);
            System.out.println(str);
        }*/
        int count=0;
        for(String string:hashMap.keySet()){
            count++;
            if(count>(hashMap.keySet().size()-8)) //输出最后八个记录
                System.out.println(string+" "+hashMap.get(string));
        }
    }


}

