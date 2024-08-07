package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bridge {
    // nCr = n-1Cr-1 + n-1Cr
    static int[][] comb;
    public static void main(String[] args) throws IOException {
        comb = new int[31][31];
        for (int n = 0; n < 31; n++) {
            for (int r = 0; r <= n ; r++) {
                combine(n,r);
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            int n = Integer.parseInt(split[1]);
            int r = Integer.parseInt(split[0]);
            sb.append(comb[n][r]).append("\n");
        }
        System.out.println(sb);
    }

    static int combine(int n, int r){
        if(n==r || r==0){ return comb[n][r]=1; }
        else{
            if(comb[n][r]!=0){ return comb[n][r]; }
            return comb[n][r] = combine(n-1,r-1) + combine(n-1,r);
        }
    }
}
