package KAKAO2019.INTERN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class q4 {
    static String[] user;
    static String[] banned;
    static HashSet<String> answer;
    public static int solution(String[] user_id, String[] banned_id) {
        user = user_id;
        banned = banned_id;
        answer = new HashSet<>();

        dfs(0,0,new HashSet<>());
        System.out.println(answer.toString());
        return answer.size();
    }

    static void dfs(int idx, int depth,HashSet<String> set){
        if(idx >= user.length){ return; }
        if(depth >= banned.length){
            ArrayList<String> list = new ArrayList<>(set);
            Collections.sort(list);
            answer.add(list.toString());
            return;
        }

        for (int i = idx; i < user.length; i++) {
            if(isSame(user[i], banned[depth])){
                if(set.contains(user[i])){ continue; }
                HashSet<String> newSet = new HashSet<>(set);
                newSet.add(user[i]);
                dfs(idx,depth+1, newSet);
            }
        }
    }

    static boolean isSame(String str, String starStr){
        if(str.length() != starStr.length()){ return  false; }
        for (int i = 0; i < starStr.length(); i++) {
            if(starStr.charAt(i)=='*'){ continue; }
            if(starStr.charAt(i)!=str.charAt(i)){ return false; }
        }
        return true;
    }

//["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "abc1**"]	2
//["frodo", "fradi", "crodo", "abc123", "frodoc"]	["*rodo", "*rodo", "******"]	2
//["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "*rodo", "******", "******"]	3

    public static void main(String[] args) {
        solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"});
        solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"});
        solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"});
    }
}
