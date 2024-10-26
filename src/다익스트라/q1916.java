package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class q1916 {
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) { graph[i] = new ArrayList<>(); }
        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            graph[Integer.parseInt(split[0])].add(new Node(Integer.parseInt(split[1]),Integer.parseInt(split[2])));
        }
        String[] split = br.readLine().split(" ");
        System.out.println(dijkstra(N,Integer.parseInt(split[0]),Integer.parseInt(split[1])));
    }

    //노드의 크기, 출발지
    public static int dijkstra(int n, int start, int end) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
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

        return dist[end];
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
