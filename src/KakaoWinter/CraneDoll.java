package KakaoWinter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CraneDoll {

    static final int BLINK=0;

    public static void main(String args[]){
        CraneDoll craneDoll=new CraneDoll();
        int[][] board= {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}};
        int[] move = {1,5,3,5,1,2,1,4};
        System.out.println(craneDoll.solution(board,move));
    }
    public int solution(int[][] board, int[] moves){
        ArrayList<Queue<Integer>> boardQ = new ArrayList<>();
        Stack<Integer> dollStack = new Stack<>();
        int answer =0;

        for(int i=0; i<board[0].length; i++){
            Queue<Integer> q = new LinkedList<>();
            boardQ.add(q);
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]!=BLINK){boardQ.get(j).add(board[i][j]);}
            }
        }

        for(int i=0; i<moves.length; i++){
            boolean deleteDoll = false;
            if(!boardQ.get(moves[i]-1).isEmpty()){
                int now = boardQ.get(moves[i]-1).poll();
                int last = BLINK;
                if(!dollStack.isEmpty()){
                    last = dollStack.peek();
                    if(last==now){ deleteDoll=true; dollStack.pop(); answer+=2;}
                }
                if(deleteDoll==false){dollStack.add(now);}
            }
        }

        return answer;
    }
}
