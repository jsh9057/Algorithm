package 릿코드;

public class Q2924 {
    public int findChampion(int n, int[][] edges) {
        int[][] record = new int[n][n];
        for(int[] e : edges){
            record[e[0]][e[1]]=1;   // win
            record[e[1]][e[0]]=-1;  // lose
        }

        for(int k=0; k<n; k++){
            for(int win=0; win<n; win++){
                for(int lose=0; lose<n; lose++){
                    if(record[win][k]==1 && record[k][lose]==1){
                        record[win][lose]=1;
                        record[lose][win]=-1;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(record[i][j]==1){cnt++;}
            }
            if(cnt == n-1){ return i; }
        }
        return -1;
    }

    public int findChampion2(int n, int[][] edges) {
        int[] indegree = new int[n];
        for(int[] e: edges){
            indegree[e[1]]++; // 패배 경험
        }

        int champ=-1;
        int champCnt=0;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                champ = i;
                champCnt++;
            }
        }
        return champCnt==1? champ:-1;
    }
}
