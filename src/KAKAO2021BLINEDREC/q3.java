package KAKAO2021BLINEDREC;

import java.util.*;

public class q3 {
    static ArrayList<Node>[] graph;
    static int[][] dist ;
    static final int INF = Integer.MAX_VALUE;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        graph = new ArrayList[n+1];
        dist = new int[n+1][n+1];

        for (int[] f: fares){
            int from = f[0];
            int to = f[1];
            int cost = f[2];
            if(graph[from]==null){ graph[from]= new ArrayList<>(); }
            if(graph[to]==null){ graph[to]= new ArrayList<>(); }
            graph[from].add(new Node(to,cost));
            graph[to].add(new Node(from,cost));
        }

        for (int[] d :dist){ Arrays.fill(d,INF); }

        for (int i = 1; i <= n; i++) {
            if(graph[i]==null){ continue; }

            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
            pq.add(new Node(i,0));
            dist[i][i]=0;
            while (!pq.isEmpty()){
                Node curNode = pq.poll();
                if(dist[i][curNode.idx] < curNode.cost){ continue; }

                for (int j = 0; j < graph[curNode.idx].size(); j++) {
                    Node nextNode = graph[curNode.idx].get(j);
                    if(dist[i][nextNode.idx] > curNode.cost + nextNode.cost){
                        dist[i][nextNode.idx] = curNode.cost + nextNode.cost;
                        pq.add(new Node(nextNode.idx, dist[i][nextNode.idx]));
                    }
                }
            }
        }

        int minCost = INF;
        for (int i = 1; i <= n; i++) {
            minCost = Math.min(minCost, dist[s][i]+dist[i][a]+dist[i][b]);
        }

        System.out.println(minCost);
        return answer;
    }
    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        solution(6,4,6,2,new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
        solution(7,3,4,1,new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}});
        solution(6,4,5,6,new int[][]{{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}});
    }
}