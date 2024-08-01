package study;

import java.util.*;

/*
    1. 비용없이 이동가능한 지형끼리 그룹핑 (dfs:시간초과, bfs 사용)
    2. 그룹간 최소비용의 edge 찾기
    3. 그룹의 MST(최소신장트리) 구하기
        * 크루스칼알고리즘 사용 (union&find 사용)
 */
public class Movement {
    static boolean[][] visit;
    static int N;
    static final int[] dx={1,-1,0,0};
    static final int[] dy={0,0,1,-1};
    static ArrayList<int[]> graph;
    static HashMap<String,Integer> xyToGroup;
    static int[][] map;
    static int maxGroup;
    static int[] parent;
    public static int solution(int[][] land, int height) {
        int answer = 0;
        N = land.length;
        visit = new boolean[N][N];
        map = new int[N][N];
        xyToGroup = new HashMap<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) { map[i][j]=land[i][j]; }
        }

        int group = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visit[i][j]){continue;}
                Group(i,j,height,group++);
                maxGroup = group;
            }
        }

        for (int i = 0; i < N; i++) { Arrays.fill(visit[i],false); }

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visit[i][j]){continue;}
                Cost(i,j);
            }
        }

        graph.sort((o1, o2) -> o1[2]-o2[2]);
        parent = new int[maxGroup];
        for (int i = 0; i < maxGroup; i++) { parent[i]=i; }

        answer = kruskal(maxGroup);
        System.out.println(answer);
        return answer;
    }

    static void Group(int y, int x, int height, int group){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x,group});
        visit[y][x]=true;
        xyToGroup.put(y+","+x,group);

        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i]+now[0];
                int nx = dx[i]+now[1];
                if(isRange(ny,nx) && !visit[ny][nx]){
                    int diff = map[now[0]][now[1]]>map[ny][nx] ? map[now[0]][now[1]]-map[ny][nx] : map[ny][nx]- map[now[0]][now[1]];
                    if(height>=diff){
                        xyToGroup.put(ny+","+nx,group);
                        visit[ny][nx]=true;
                        q.add(new int[]{ny,nx,group});
                    }
                }
            }
        }
    }

    static void Cost(int y, int x){
        if(visit[y][x]){ return; }
        visit[y][x]=true;
        int nowGroup = xyToGroup.get(y+","+x);
        for (int i = 0; i < 4; i++) {
            int ny = dy[i]+y;
            int nx = dx[i]+x;
            if(isRange(ny,nx) && !visit[ny][nx]){
                int nextGroup = xyToGroup.get(ny+","+nx);
                if(nowGroup!=nextGroup){
                    int c = map[y][x] > map[ny][nx] ? map[y][x]-map[ny][nx] : map[ny][nx]-map[y][x];
                    if(c == 0){ continue; }
                    graph.add(new int[]{nowGroup,nextGroup,c});
                }
            }
        }
    }

    static int find(int idx){
        if(parent[idx]==idx){ return idx; }
        return find(parent[idx]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x<y) parent[y]=x;
        else parent[x]=y;
    }

    static int kruskal(int maxGroup){
        int cost = 0;
        int edge = 0;
        for (int i = 0; i < graph.size(); i++) {
            int from = graph.get(i)[0];
            int to = graph.get(i)[1];
            int c = graph.get(i)[2];
            if(find(from) != find(to)){
                cost+=c;
                union(from,to);
                edge++;
            }
            if(maxGroup-1==edge){break;}
        }
        return cost;
    }

    static boolean isRange(int y, int x){ return 0<=y && y<N && 0<=x && x<N; }

    public static void main(String[] args) {
        solution(new int[][]{{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}},3);
        solution(new int[][]{{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}},1);
    }
}
