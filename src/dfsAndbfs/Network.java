package dfsAndbfs;

public class Network {
    static boolean[] visit;

    public static int solution(int n, int[][] computers) {
        visit = new boolean[n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if(visit[i]){ continue; }
            answer++;
            dfs(i,computers);
        }

        System.out.println(answer);
        return answer;
    }
    static void dfs(int idx, int[][] computers){
        if(visit[idx]){ return; }
        visit[idx]=true;
        for (int i = 0; i < visit.length; i++) {
            if(!visit[i] && computers[idx][i]==1){ dfs(i,computers); }
        }
    }
    public static void main(String[] args) {
        solution(3,new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        solution(3,new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
    }
}
