package KAKAO2020BLIND;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class q4 {
    public static int[] solution(String[] words, String[] queries) {
        HashMap<Integer, ArrayList<String>> prefix = new HashMap<>();
        HashMap<Integer, ArrayList<String>> suffix = new HashMap<>();

        for (String w: words){
            StringBuffer sb = new StringBuffer(w);
            String reverse = sb.reverse().toString();
            ArrayList<String> preList = prefix.getOrDefault(w.length(),new ArrayList<>());
            ArrayList<String> sufList = suffix.getOrDefault(w.length(),new ArrayList<>());
            preList.add(reverse);
            sufList.add(w);
            prefix.put(w.length(), preList);
            suffix.put(w.length(), sufList);
        }

        for (Integer key : prefix.keySet()){
            ArrayList<String> list = prefix.get(key);
            Collections.sort(list);
            prefix.put(key,list);
        }
        for (Integer key : prefix.keySet()){
            ArrayList<String> list = suffix.get(key);
            Collections.sort(list);
            suffix.put(key,list);
        }
        // ?abc 접두사
        // abc? 접미사
        List<Integer> answer = new ArrayList<>();

        for(String q : queries){
            int len = q.length();
            int hiden = 0;

            for(char c :q.toCharArray()){ if(c=='?') hiden++; }
            if(!prefix.containsKey(len)){ answer.add(0); continue; }
            if(hiden==len){ answer.add(prefix.get(len).size()); continue; }

            boolean isPrefix = q.charAt(0) == '?';
            if (isPrefix){
                ArrayList<String> list = prefix.get(len);
                StringBuffer sb = new StringBuffer(q).reverse();
                String preQuery = sb.substring(0,len-hiden);
                answer.add(upperBound(list,preQuery+"z".repeat(hiden))-lowerBound(list,preQuery));
            }
            else{
                ArrayList<String> list = suffix.get(len);
                String sufQuery = q.substring(0,len-hiden);
                System.out.println("suffix: "+ sufQuery);
                System.out.println(list);
                answer.add(upperBound(list,sufQuery+"z".repeat(hiden))-lowerBound(list,sufQuery));
            }
        }
        System.out.println(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    // 특정 값 이상인 첫 위치
    public static int lowerBound(ArrayList<String> list, String value){
        int max = list.size();
        int min = 0;
        while(min<max){
            int mid = (min+max)/2;
            if(value.compareTo(list.get(mid))>0){
                min = mid+1;
            }else{
                max = mid;
            }
        }
        return min;
    }
    // 특정 값을 초과하는 첫위치
    public static int upperBound(ArrayList<String> list, String value){
        int max = list.size();
        int min = 0;
        while(min<max){
            int mid = (min+max)/2;
            if(value.compareTo(list.get(mid))<0){
                max = mid;
            }else{
                min = mid+1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"}, new String[]{"fro??", "????o", "fr???", "fro???", "pro?"});
//        solution(new String[]{"abcde","adbcde","abcddd","abdbcz"}, new String[]{"ab???"});
    }
}