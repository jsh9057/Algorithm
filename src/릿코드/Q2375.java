package 릿코드;
import java.util.*;

public class Q2375 {

    static String res;
    static boolean isEnd;

    public String smallestNumber(String pattern) {
        isEnd = false;
        for(int i=1;i<10;i++){
            if(isEnd){ break; }
            bt(0,i,""+i,pattern, new boolean[10]);
        }

        return res;
    }
    void bt(int idx, int prev, String now, String pattern, boolean[] visit) {
        if(isEnd){return;}
        if(idx == pattern.length()){
            res = now;
            isEnd = true;
            return;
        }

        visit[prev]=true;
        char DI = pattern.charAt(idx);
        if(DI=='I'){
            for(int i=prev+1; i<=9; i++){
                if(!visit[i] && !isEnd){
                    visit[i]=true;
                    bt(idx+1,i,now+i,pattern, visit);
                    visit[i]=false;
                }
            }
        }
        else if(DI=='D'){
            for(int i=1; i<prev; i++){
                if(!visit[i] && !isEnd){
                    visit[i]=true;
                    bt(idx+1,i,now+i,pattern, visit);
                    visit[i]=false;
                }
            }
        }
    }
    public String smallestNumber2(String pattern) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<=pattern.length();i++){
            stack.push(i+1);
            if(i==pattern.length() || pattern.charAt(i)=='I'){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                System.out.println(sb);
            }
        }
        return sb.toString();
    }


}
