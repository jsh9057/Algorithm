package Brute_force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0
 */

public class TSP {
    private static boolean[] visit ;
    private static int mini=987654321;
    private static int k=0;

    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k =Integer.parseInt(br.readLine());

        visit = new boolean[k];
        int[][] nodes = new int[k][k];

        for(int i=0; i<k; i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s," ");
            int index=0;
            while(st.hasMoreTokens()) {
                int e = Integer.parseInt(st.nextToken());
                nodes[i][index++] = e;
            }
        }

//        for(int i=0; i<k ; i++) {
            dfs(nodes, 0, 0, 0, 0);
//        }
        bw.write(mini+"\n");
        bw.close();
        br.close();
    }

    public static void dfs(int[][] nodes ,int x, int r, int cost, int start){
        if(r==k && start==x){
            if(mini>cost){mini=cost;}
            return;
        }

        for(int i=0; i<k ; i++){
            if(nodes[x][i]!=0&& !visit[x]){
                cost+=nodes[x][i];
                visit[x]= true;
                if(cost<=mini){ dfs(nodes, i, r+1,cost, start);}
                visit[x]= false;
                cost-=nodes[x][i];
            }
        }
    }
}
