package study;

import java.util.Arrays;

public class Thievery {
    public static int solution(int[] money) {
        int N = money.length;
        int[] dpA = new int[N];
        int[] dpB = new int[N];
        dpA[0]=money[0];
        dpA[1]=money[0];

        dpB[1]=money[1];

        for (int i = 2; i < N; i++) {
            dpA[i] = Math.max(dpA[i-2]+money[i],dpA[i-1]);
            dpB[i] = Math.max(dpB[i-2]+money[i],dpB[i-1]);
        }

        System.out.println(Arrays.toString(dpA));
        System.out.println(Arrays.toString(dpB));

        System.out.println(Math.max(dpA[N-2],dpB[N-1]));
        return Math.max(dpA[N-2],dpB[N-1]);
    }

    public static void main(String[] args) {
        solution(new int[] {1, 2, 3, 1});
        solution(new int[] {4, 5, 2, 4});
        solution(new int[] {3,2,1});
    }
}
