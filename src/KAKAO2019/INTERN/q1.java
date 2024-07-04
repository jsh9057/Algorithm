package KAKAO2019.INTERN;

import java.util.Stack;

public class q1 {
    static int[][] board;
    public static int solution(int[][] b, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        board = new int[b.length][b.length];
        for (int i = 0; i < b.length; i++) { board[i] = b[i]; }

        for (int m : moves){
            int doll = get(m-1);
            if(doll>0){
                if(!stack.isEmpty() && stack.peek()==doll){
                    stack.pop();
                    answer+=2;
                }
                else{ stack.add(doll); }
            }
        }
        return answer;
    }
    static int get(int x){
        for (int i = 0; i < board.length; i++) {
            if(board[i][x]!=0){
                int ret = board[i][x];
                board[i][x]=0; return ret;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4});
    }
}
