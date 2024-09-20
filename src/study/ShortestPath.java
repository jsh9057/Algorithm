package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int V = Integer.parseInt(split[0]);
        int E = Integer.parseInt(split[1]);
        int root = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[V+1];
        for (int i = 1; i <=V ; i++) { graph[i]=new ArrayList<>(); }
        for (int i = 0; i < E; i++) {
            split = br.readLine().split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            int cost =Integer.parseInt(split[2]);
            graph[from].add(new Node(to,cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[V+1];
        int[] dist = new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[root] = 0;
        pq.add(new Node(root,0));

        while (!pq.isEmpty()){
            Node now = pq.poll();
            if(visit[now.index]) continue;
            visit[now.index] = true;

            for (Node next : graph[now.index]){
                if(dist[next.index] > dist[now.index]+next.cost){
                    dist[next.index] = dist[now.index] + next.cost;
                    pq.add(new Node(next.index,dist[next.index]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i]==Integer.MAX_VALUE? "INF":dist[i]);
        }
    }

    static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int next, int cost) {
            this.index = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) { return this.cost - o.cost; }
    }
}
