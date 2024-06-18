package KAKAO2020BLIND;

import java.util.LinkedList;
import java.util.Queue;

public class q2 {
    public static String solution(String p) {
        String answer = recursion(p);
        System.out.println();
        return answer;
    }

    public static String recursion(String str){
        if(str.length()==0){ return ""; }

        int left = 0;
        int right = 0;
        int i;
        for (i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(' ){ left++; }
            else { right++; }
            if(left>0 && left == right){ break; }
        }
        String u = str.substring(0,i+1);
        String v = str.substring(i+1);

        if(isComplete(u)){ return u+recursion(v); }
        String tmp  = 2>u.length()? "" : u.substring(1,u.length()-1);
        return "("+recursion(v)+")"+revers(tmp);
    }

    static boolean isComplete(String str){
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='('){ queue.add('('); }
            else{
                if(queue.isEmpty()){ return false;}
                queue.poll();
            }
        }
        return queue.size()==0;
    }

    static String revers(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='('){ sb.append(")"); }
            else {sb.append("("); }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        solution("(()())()");
        solution(")(");
        solution("()))((()");
    }
}