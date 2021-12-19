package Brute_force;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindDecimal {
    static Boolean[] visit;
    static Boolean[] check;
    static Set<Integer> set ;
    public static void main(String args[]){
        int s1=solution("17");
        int s2=solution("001");
        System.out.println(s1);
        System.out.println(s2);


    }
    public static int solution(String numbers){
        check= new Boolean[9999999];
        Arrays.fill(check,false);
        visit = new Boolean[numbers.length()];
        set = new LinkedHashSet<>();
        for(int i=0; i<numbers.length(); i++){
            Arrays.fill(visit,false);
            visit[i]=true;
            dfs(numbers,0,String.valueOf(numbers.charAt(i)));
        }
        System.out.println(set.toString());
        int answer=0;
        for(int i : set)
            if(isDecimal(i)){answer++;}
        return answer;
    }

    public static boolean isDecimal(int n){
        if(n<=1){return false;}
        for(int i=2; i<n; i++){
            if(n%i==0){return false;}
        }
        return true;
    }

    public static void dfs(String number, int depth, String preNum){
        if(depth==0){set.add(Integer.parseInt(preNum));}
        if(depth>=number.length()-1){return;}
        for(int i=0; i<number.length(); i++){
            if(visit[i]!=true) {
                visit[i] = true;
                String s = preNum + number.charAt(i);
                int n = Integer.parseInt(s);
                dfs(number, depth + 1, s);
                set.add(n);
                visit[i]=false;
            }
        }
    }
}
