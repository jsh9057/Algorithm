package DFS_BFS;

public class Network {

    public static void main(String args[]){
        int n=6;
//        int[][] computers={{1,1,0},{1,1,0},{0,0,1}};
//        int[][] computers={{1,1,0},{1,1,1},{0,1,1}};
//        int[][] computers={{1,0,0},{0,1,0},{0,0,1}};
        int[][] computers={{1,1,0,0,0,0},{1,1,1,0,0,0},{0,1,1,1,1,0},{0,0,1,1,0,0},{0,0,1,0,1,0},{0,0,0,0,0,1}};
//        int[][] computers = {{1,0,0,1},{0,1,1,1},{0,1,1,0},{1,1,0,1}};
        boolean[] visited=new boolean[n];
        int answer = 0;
        for(int i=0; i<n; i++){
            answer+=dfs(computers,visited,i);
        }
        System.out.println(answer);
    }
    public static int dfs(int[][] computers , boolean[] visited, int i){
        if(visited[i]){return 0;}
        visited[i]=true;
        for(int k=0; k < computers[i].length; k++){
            if(computers[i][k]==1)
                dfs(computers,visited,k);
        }
        return 1;
    }
}
