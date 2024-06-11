package KAKAO2022BLINDREC;

public class q6 {
    static int N;
    static int M;
    static int[][] prefixSum;
    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        N = board.length;
        M = board[0].length;
        prefixSum = new int[N+1][M+1];

        for(int[] s : skill){ setDegree(s[0],s[1],s[2],s[3],s[4],s[5]); }
        setPrefixSum();
        board = calBoard(board);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j]>0){ answer++;}
            }
        }
        return answer;
    }

    public static void setDegree(int type, int r1, int c1, int r2, int c2, int degree){
        degree *= type == 1? -1 : 1;
        prefixSum[r1][c1]+=degree;
        prefixSum[r1][c2+1]+=(degree*-1);
        prefixSum[r2+1][c1]+=(degree*-1);
        prefixSum[r2+1][c2+1]+=degree;
    }

    public static void setPrefixSum(){
        for(int i = 0; i < N+1; i++) {
            for (int j = 0; j < M; j++) { prefixSum[i][j+1]=prefixSum[i][j]+prefixSum[i][j+1]; }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) { prefixSum[i+1][j]=prefixSum[i][j]+prefixSum[i+1][j]; }
        }
    }

    public static int[][] calBoard(int[][] board){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) { board[i][j]+=prefixSum[i][j]; }
        }
        return board;
    }

    public static void main(String[] args) {
        solution(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}}, new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}});
        solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}});
    }
}
