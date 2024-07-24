package study;

public class Ranking {
    public static int solution(int n, int[][] results) {
        int answer = 0;
        int [][] win = new int[n+1][n+1];

        for (int[] r: results){
            win[r[0]][r[1]]=1;
            win[r[1]][r[0]]=-1;
        }

        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <=n; j++) {
                   if(win[i][k]==1 && win[k][j]==1){ win[i][j]=1; }
                   if(win[i][k]==-1 && win[k][j]==-1){ win[i][j]=-1; }
                }
            }
        }

        for (int i = 1; i <=n ; i++) {
            System.out.print(i+": ");
            for (int j = 1; j <= n; j++) {
                System.out.print(win[i][j]+" ");
            }
            System.out.println();
        }

        for (int i = 1; i <=n ; i++) {
            int cnt = 0;
            for (int j = 1; j <=n ; j++) { if(win[i][j]!=0){ cnt ++; } }
            if(cnt>=n-1){ answer++; }
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution(5,new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
    }
}