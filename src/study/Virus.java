package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Virus {
    static int ret;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        visit = new boolean[V+1];

        for (int i = 0; i < E; i++) {
            String[] split = br.readLine().split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            if(graph[from]==null){ graph[from]=new ArrayList<>(); }
            if(graph[to]==null){ graph[to]=new ArrayList<>(); }
            graph[from].add(to);
            graph[to].add(from);
        }
        ret = 0;
        visit[1] = true;
        dfs(1);
        System.out.println(ret-1);
    }

    static void dfs(int now){
        ret++;
        if(graph[now]==null){return;}
        for (int next : graph[now]){
            if(!visit[next]){
                visit[next] = true;
                dfs(next);
            }
        }
    }
}
