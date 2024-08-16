package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sequence {
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        visit = new boolean[N+1];
        go(N,M,0,"");
    }

    static void go(int N, int M, int depth, String ret){
        if(depth == M){ System.out.println(ret); return;}

        for (int i = 1; i <= N ; i++) {
            if(!visit[i]){
                visit[i] = true;
                go(N,M,depth+1,ret+i+" ");
                visit[i] = false;
            }
        }
    }
}
