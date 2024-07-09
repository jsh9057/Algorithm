package dfsAndbfs;

import java.util.*;

public class FarNode {
    public static int solution(int n, int[][] edge) {
        ArrayList<Node>[] graph = new ArrayList[n+1];
        for (int i = 0; i < edge.length; i++) {
            if(graph[edge[i][0]]==null){  graph[edge[i][0]] = new ArrayList<>(); }
            if(graph[edge[i][1]]==null){  graph[edge[i][1]] = new ArrayList<>(); }
            graph[edge[i][0]].add(new Node(edge[i][1],1));
            graph[edge[i][1]].add(new Node(edge[i][0],1));
        }
        
        boolean[] visit = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1,0));
        dist[1]=0;

        while (!q.isEmpty()){
            Node now = q.poll();
            if(visit[now.n]){ continue; }
            visit[now.n]= true;
            for (Node next: graph[now.n]){
                if(dist[next.n]>dist[now.n]+next.cost){
                    dist[next.n]=dist[now.n]+next.cost;
                    q.add(new Node(next.n,dist[next.n]));
                }
            }
        }

        int maxNum = -1;
        for (int i = 1; i < n+1; i++) { maxNum=Math.max(maxNum,dist[i]); }

        int answer = 0;
        for (int i = 1; i < n+1; i++) {
            if(dist[i]==maxNum){ answer++; }
        }
        return answer;
    }

    static class Node implements Comparable<Node>{
        int n;
        int cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) { return this.cost - o.cost; }
    }

    public static void main(String[] args) {
        solution(6,new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }
}
