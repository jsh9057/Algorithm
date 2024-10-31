package 소프트티어;
import java.io.*;
import java.util.*;

public class q3 {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        long K = Integer.parseInt(split[0]);
        long P = Integer.parseInt(split[1]);
        int N = Integer.parseInt(split[2]);

        long ret = K;
        for(int i=0; i<N; i++){
            ret = (ret * P)%MOD;
        }
        System.out.println(ret);
    }
}
