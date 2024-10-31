package 소프트티어;
import java.io.*;
import java.util.*;

public class q6248 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        ArrayList<Integer>[] goGraph = new ArrayList[N + 1];
        ArrayList<Integer>[] backGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            goGraph[i] = new ArrayList<>();
            backGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            goGraph[from].add(to);
            backGraph[to].add(from);
        }

        boolean[] v1 = new boolean[N + 1];
        boolean[] v2 = new boolean[N + 1];
        boolean[] v3 = new boolean[N + 1];
        boolean[] v4 = new boolean[N + 1];
        split = br.readLine().split(" ");
        int S = Integer.parseInt(split[0]);
        int T = Integer.parseInt(split[1]);
        v1[T] = true;
        dfs(S, goGraph, v1);
        dfs(T, backGraph, v2);

        v3[S] = true;
        dfs(T, goGraph, v3);
        dfs(S, backGraph, v4);

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (i == S || i == T) {
                continue;
            }
            if (v1[i] && v2[i] && v3[i] && v4[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int now, ArrayList<Integer>[] graph, boolean[] visit){
        if(visit[now]){ return; }
        visit[now] = true;
        for(Integer next : graph[now]){
            if(!visit[next]){
                dfs(next, graph, visit);
            }
        }
    }
}
