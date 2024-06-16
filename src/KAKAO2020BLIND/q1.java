package KAKAO2020BLIND;

import java.util.LinkedList;
import java.util.Queue;

public class q1 {
    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;

        if(s.length()==1){ return 1;}

        for (int i = 1; i <= s.length()/2; i++) {
            answer = Math.min(comp(s,i).length(), answer);
        }
        return answer;
    }

    static String comp(String str, int num){
        Queue<String> q = new LinkedList<>();
        int i;
        for (i = 0; i < str.length()-num; i+=num) {
            q.add(str.substring(i,i+num));
        }
        q.add(str.substring(i));

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()){
            String now = q.poll();
            String next = q.peek();
            int cnt = 1;
            while (now.equals(next)){
                cnt++;
                now = q.poll();
                next = q.peek();
            }
            if(cnt>1){sb.append(cnt);}
            sb.append(now);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        solution("aabbaccc");
        solution("ababcdcdababcdcd");
        solution("abcabcdede");
        solution("abcabcabcabcdededededede");
        solution("xababcdcdababcdcd");
    }
}
