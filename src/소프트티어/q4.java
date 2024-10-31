package 소프트티어;
import java.io.*;
import java.util.*;
public class q4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            String[] split = br.readLine().split(" ");
            String a = split[0].toLowerCase();
            String b = split[1].toUpperCase();

            for(int i=0; i < a.length() ; i++){
                if(a.charAt(i)=='x'){
                    sb.append(b.charAt(i));
                }
            }
        }
        System.out.println(sb);
    }
}
