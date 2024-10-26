package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class q1238 {
    static ArrayList<Node>[] graph;
    static boolean[] check;
    static int[] dist;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int X = Integer.parseInt(split[2]);

        graph = new ArrayList[N+1];
        cost = new int[N+1];
        for (int i = 0; i < N+1; i++) { graph[i] = new ArrayList<>(); }

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            graph[Integer.parseInt(split[0])].add(new Node(Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        }

        for (int i = 1; i < N+1; i++) {
            if(i==X){continue;}
            dijkstra(N,i);
            cost[i]=dist[X];
        }
        dijkstra(N,X);
        int max = 0;
        for (int i = 1; i < N+1; i++) {
            cost[i]+=dist[i];
            max = Math.max(cost[i],max);
        }
        System.out.println(max);
    }

    //노드의 크기, 출발지
    public static void dijkstra(int n, int start) {
        check = new boolean[n + 1];
        dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            int nowVertex = pq.poll().index;

            if(check[nowVertex]) continue;
            check[nowVertex] = true;

            //index의 연결된 정점 비교
            for(Node next : graph[nowVertex]) {
                if(dist[next.index] > dist[nowVertex]+ next.cost) {
                    dist[next.index] = dist[nowVertex] + next.cost;

                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
