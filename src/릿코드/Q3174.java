package 릿코드;
import java.util.*;

public class Q3174 {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(isNum(s.charAt(i))){ stack.pop(); }
            else{ stack.push(s.charAt(i)); }
        }

        String res="";
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b)-> a.compareTo(b));

        while(!stack.isEmpty()){ res = stack.pop()+res; }
        return res;
    }

    boolean isNum(Character c){
        if(c-'0'<=9){ return true; }
        return false;
    }
}
