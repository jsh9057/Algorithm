package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class q11779 {
    static ArrayList<Node>[] graph;
    static ArrayList<Integer>[] path;
    static boolean[] check;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        path = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
            path[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            graph[Integer.parseInt(split[0])].add(new Node(Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        }

        String[] split = br.readLine().split(" ");
        int s = Integer.parseInt(split[0]);
        int e = Integer.parseInt(split[1]);

        dijkstra(N, Integer.parseInt(split[0]));
        System.out.println(dist[e]);
        System.out.println(path[e].size());
        for (Integer p : path[e]){
            System.out.print(p+" ");
        }
    }

    //노드의 크기, 출발지
    public static void dijkstra(int n, int start) {
        check = new boolean[n + 1];
        dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        ArrayList<Integer> startPath =new ArrayList<>();
        startPath.add(start);
        pq.offer(new Node(start, 0, startPath));

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int nowVertex = now.index;
            ArrayList<Integer> nowPath = now.path;

            if(check[nowVertex]) continue;
            check[nowVertex] = true;

            //index의 연결된 정점 비교
            for(Node next : graph[nowVertex]) {
                if(dist[next.index] > dist[nowVertex]+ next.cost) {
                    dist[next.index] = dist[nowVertex] + next.cost;
                    ArrayList<Integer> nextPath = new ArrayList<>(nowPath);
                    nextPath.add(next.index);
                    path[next.index] = nextPath;
                    pq.offer(new Node(next.index, dist[next.index],nextPath));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int index;
        int cost;
        ArrayList<Integer> path;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        public Node(int index, int cost, ArrayList<Integer> path) {
            this.index = index;
            this.cost = cost;
            this.path = path;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
