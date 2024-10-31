package 소프트티어;
import java.io.*;
import java.util.*;
public class q5 {
    static final String NORMAL = "normal";
    static final String SECRET = "secret";
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String M = br.readLine().replace(" ","");
        String N = br.readLine().replace(" ","");
        System.out.println( N.contains(M) ? SECRET:NORMAL);
    }
}
