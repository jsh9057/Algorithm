package KAKAO2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class q1 {
    final static String IN_INFO = "님이 들어왔습니다.";
    final static String OUT_INFO = "님이 나갔습니다.";
    final static String ENTER = "Enter";
    final static String LEAVE = "Leave";
    public static String[] solution(String[] record) {
        HashMap<String, String> idMap = new HashMap<>();
        for (String r: record){
            String[] split = r.split(" ");
            if(split.length==3){ idMap.put(split[1],split[2]); }
        }

        List<String> ret = new ArrayList<>();
        for (String r: record){
            String[] split = r.split(" ");
            if(split[0].equals(ENTER)){ ret.add(idMap.get(split[1])+IN_INFO); }
            else if(split[0].equals(LEAVE)){ ret.add(idMap.get(split[1])+OUT_INFO); }
        }
        System.out.println(ret);
        return ret.toArray(new String[ret.size()]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
    }

}