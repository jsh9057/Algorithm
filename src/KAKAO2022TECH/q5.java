package KAKAO2022TECH;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class q5 {
    static int R;
    static int C;
    static Deque<Integer>[] row;
    static Deque<Integer> firstCol;
    static Deque<Integer> lastCol;

    static Deque<Integer> idx;

    public static int[][] solution(int[][] rc, String[] operations) {
        R = rc.length;
        C = rc[0].length;
        idx = new ArrayDeque<>();

        for (int i = 0; i < R; i++) { idx.addLast(i); }

        row = new ArrayDeque[rc.length];
        firstCol = new ArrayDeque<>();
        lastCol = new ArrayDeque<>();

        for (int r = 0; r < R; r++) {
            row[r]=new ArrayDeque<>();
            for (int c = 0; c < C; c++) {
                if(c==0){ firstCol.offer(rc[r][c]); }
                else if( c== C-1){ lastCol.offer(rc[r][c]); }
                else { row[r].offer(rc[r][c]); }
            }
        }

        for (String o : operations){
            switch (o){
                case "ShiftRow":
                    shiftRow();
                    break;
                case "Rotate":
                    rotate();
                    break;
            }
        }
        return print();
    }

    static int[][] print(){
        int[][] ret = new int[R][C];
        for (int i = 0; i < R; i++) {
            int r = idx.pollFirst();
            for (int j = 0; j < C; j++) {
                if(j==0){ ret[i][j] = firstCol.poll(); }
                else if( j== C-1){ ret[i][j] = lastCol.poll(); }
                else {ret[i][j] = row[r].poll();}
            }
        }
        for (int[] r : ret){
            System.out.println(Arrays.toString(r));
        }
        return ret;
    }

    static void shiftRow(){
        idx.addFirst(idx.pollLast());
        firstCol.addFirst(firstCol.pollLast());
        lastCol.addFirst(lastCol.pollLast());
    }

    static void rotate(){
        row[idx.peekFirst()].addFirst(firstCol.pollFirst());
        lastCol.addFirst(row[idx.peekFirst()].pollLast());
        row[idx.peekLast()].addLast(lastCol.pollLast());
        firstCol.addLast(row[idx.peekLast()].pollFirst());
    }

    public static void main(String[] args) {
        solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new String[]{"Rotate", "ShiftRow"} );
        System.out.println("-----");
        solution(new int[][]{{8, 6, 3}, {3, 3, 7}, {8, 4, 9}}, new String[]{"Rotate", "ShiftRow", "ShiftRow"} );
        System.out.println("-----");
        solution(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}, new String[]{"ShiftRow", "Rotate", "ShiftRow", "Rotate"} );
        System.out.println("-----");
        solution(new int[][]{{1,1,1,1,1}, {2,2,2,2,2}, {3,3,3,3,3}, {4,4,4,4,4}, {5,5,5,5,5}}, new String[]{"Rotate", "ShiftRow"} );
    }
}