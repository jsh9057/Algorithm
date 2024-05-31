package KAKAO2022TECH;

import java.util.*;

public class q4 {
    static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        boolean[] visit = new boolean[n+1];
        HashSet<Integer> summit = new HashSet<>();
        HashSet<Integer> gate = new HashSet<>();
        ArrayList<Node>[] graph = new ArrayList[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.sort(summits);

        for (int s :summits){ summit.add(s); }
        for (int g :gates){ gate.add(g); }

        for (int i = 0; i < paths.length; i++) {
            int from = paths[i][0];
            int to = paths[i][1];
            int cost = paths[i][2];
            if(graph[from]==null){ graph[from]=new ArrayList<>(); }
            if(graph[to]==null){ graph[to]=new ArrayList<>(); }

            if(gate.contains(from) || summit.contains(to)){
                graph[from].add(new Node(to,cost));
                continue;
            }
            if (gate.contains(to) || summit.contains(from)){
                graph[to].add(new Node(from,cost));
                continue;
            }
            graph[from].add(new Node(to,cost));
            graph[to].add(new Node(from, cost));

        }

        int minIntensity = Integer.MAX_VALUE;
        int minIndex = Integer.MAX_VALUE;
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for (int g = 0; g < gates.length; g++) {
            int start = gates[g];
            Arrays.fill(visit,false);
            dist[start]=0;
            pq.add(new Node(start,0));

            while (!pq.isEmpty()){
                int now = pq.poll().index;
                if(visit[now]){continue; }
                visit[now]=true;

                for (Node next : graph[now]){
                    if(dist[next.index] > Math.max(dist[now], next.cost)){
                        dist[next.index] = Math.max(dist[now], next.cost);
                        pq.add(new Node(next.index, dist[next.index]));
                    }
                }
            }

//            for (int i = 0; i < summits.length; i++) {
//                System.out.println(start+"->"+summits[i]+": "+dist[summits[i]]);
//            }
        }
        for (int i = 0; i < summits.length; i++) {
            if(dist[summits[i]]<minIntensity){
                minIntensity = dist[summits[i]];
                minIndex = summits[i];
            }
        }
        System.out.println("["+minIndex+", "+minIntensity+"]");
        return new int[] {minIndex,minIntensity};
    }

    public static void main(String[] args) {
        solution(6,new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}},new int[]{1,3}, new int[]{5});
        solution(7, new int[][]{{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}}, new int[]{1}, new int[] {2,3,4});
        solution(7, new int[][]{{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}}, new int[]{3,7}, new int[]{1,5});
        solution(5, new int[][]{{1, 3, 10}, {1, 4, 20}, {2, 3, 4}, {2, 4, 6}, {3, 5, 20}, {4, 5, 6}},new int[]{1,2}, new int[]{5});

    }
}