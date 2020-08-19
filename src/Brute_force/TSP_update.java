package Brute_force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0
 */

public class TSP_update {
    private static boolean[] visit ;
    private static int MAX=987654321;
    private static int k=0;
    private static int[][] nodes;
    private static int[][] dp;
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k =Integer.parseInt(br.readLine());

        visit = new boolean[k];
        nodes = new int[k][k];
        dp = new int [k][(1<<k)-1];

        for(int[] a : dp)
            Arrays.fill(a,MAX);

        for(int i=0; i<k; i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s," ");
            int index=0;
            while(st.hasMoreTokens()) {
                int e = Integer.parseInt(st.nextToken());
                nodes[i][index++] = e;
            }
        }
        bw.write(tsp(0,1)+"\n");
        bw.close();
        br.close();
    }

    public static int tsp(int node, int visit){
        if(visit == (1<<k)-1){
            if(nodes[node][0]==0){return MAX;}
            return nodes[node][0];
        }

        if(dp[node][visit]!=MAX){return dp[node][visit];}

        for(int i=0; i<k; i++){
            int next = visit | (1 <<i);
            if(nodes[node][i]!=0 && (visit & (1<<i)) == 0){
                dp[node][visit]=Math.min(dp[node][visit],tsp (i,next)+nodes[node][i]);
            }
        }
        return dp[node][visit];
    }
}
