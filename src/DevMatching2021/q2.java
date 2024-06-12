package DevMatching2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class q2 {
    static int[][] map;
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows][columns];
        int val = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) { map[i][j]=val++; }
        }

        int i = 0;
        for (int[] q : queries){
            answer[i++]=query(q[0],q[1],q[2],q[3]);
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static int query(int r1, int c1, int r2, int c2){
        Deque<Integer> row1 = new ArrayDeque<>();
        Deque<Integer> row2 = new ArrayDeque<>();
        Deque<Integer> col1 = new ArrayDeque<>();
        Deque<Integer> col2 = new ArrayDeque<>();

        int min = Integer.MAX_VALUE;

        for (int i = c1-1; i < c2; i++) {
            row1.addLast(map[r1-1][i]);
            row2.addLast(map[r2-1][i]);
            min = Math.min(min,map[r1-1][i]);
            min = Math.min(min,map[r2-1][i]);
        }

        for (int i = r1; i < r2-1; i++) {
            col1.addLast(map[i][c1-1]);
            col2.addLast(map[i][c2-1]);
            min = Math.min(min,map[i][c1-1]);
            min = Math.min(min,map[i][c2-1]);
        }

        if(r2-r1==1){
            row1.addFirst(row2.pollFirst());
            row2.addLast(row1.pollLast());
        }
        else {
            row1.addFirst(col1.pollFirst());
            col2.addFirst(row1.pollLast());
            row2.addLast(col2.pollLast());
            col1.addLast(row2.pollFirst());
        }

        for (int i = c1-1; i < c2; i++) {
            map[r1-1][i]=row1.pollFirst();
            map[r2-1][i]=row2.pollFirst();
        }
        for (int i = r1; i < r2-1; i++) {
            map[i][c1-1]=col1.pollFirst();
            map[i][c2-1]=col2.pollFirst();
        }
        return min;
    }
    public static void main(String[] args) {
        solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
        solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}});
        solution(100, 97, new int[][]{{1, 1, 100, 97}});
    }
}
