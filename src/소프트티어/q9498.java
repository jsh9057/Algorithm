package 소프트티어;
import java.util.*;
import java.io.*;

public class q9498 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<input.length(); i++){
            q.add(input.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            Character now = q.poll();
            Character next = q.peek();
            sb.append(now);
            if(next==null){ break; }
            if(now=='('&&next==')'){ sb.append(1); }
            if(now==')'&&next=='('){ sb.append('+');}
        }
        System.out.println(sb);
    }
}
