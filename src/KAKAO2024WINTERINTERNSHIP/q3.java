package KAKAO2024WINTERINTERNSHIP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class q3 {
    // 누적합, 투포인터, 이분탐색
    // 백트래킹, 비트마스킹
    static List<int[]> combA;
    static int N;

    public static int[] solution(int[][] dice) {
        int[] answer = new int[N/2];
        N = dice.length;
        combA = new ArrayList<>();
        chooseADice(0,0,new int[N/2]);

        int max = 0;
        for (int[] combA: combA){
            List<Integer> sumA = new ArrayList<>();
            List<Integer> sumB = new ArrayList<>();
            getSum(0,0,combA, dice, sumA);
            getSum(0,0,chooseBDice(combA),dice, sumB);
            Collections.sort(sumB);
            int win = 0;
            for (int i = 0; i < sumA.size(); i++) {
                int vs = lowerBound(sumB,sumA.get(i));
                if(vs>0){
                    win+=vs;
                }
            }

            if(win > max){
                max = win;
                answer = combA;
            }

        }
        for (int i = 0; i < N/2; i++) { answer[i]=answer[i]+1; }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {

        int[][] dice;
        dice = new int[][]{{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
        solution(dice);
        dice = new int[][]{{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}};
        solution(dice);
        dice = new int[][]{{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80}, {70, 70, 1, 1, 70, 70}};
        solution(dice);
    }

    static void chooseADice(int n, int cnt, int[] arr) {
        if (cnt == N / 2) {
            combA.add(arr.clone());
            return;
        }
        for (int i = n; i < N; i++) {
            arr[cnt] = i;
            chooseADice(i+1,cnt+1,arr);
        }
    }

    static int[] chooseBDice(int[] comb) {
        boolean[] isA = new boolean[N];
        for(int a :comb){
            isA[a]=true;
        }
        int[] arrB = new int[N/2];
        int b=0;
        for (int i = 0; i < N; i++) {
            if(!isA[i]){
                arrB[b++]=i;
            }
        }
        return arrB;
    }

    static void getSum(int cnt, int sum, int[] comb, int[][] dice, List<Integer> sums){
        if(cnt == N/2){
            sums.add(sum);
            return;
        }

        for(int i=0; i<6; i++){
            getSum(cnt+1,sum+dice[comb[cnt]][i],comb, dice, sums);
        }
    }

    // 특정 값 이상인 첫 위치
    public static int lowerBound(List<Integer> arr, int value){
        int max = arr.size();
        int min = 0;
        while(min<max){
            int mid = (min+max)/2;
            if(value > arr.get(mid)){
                min = mid+1;
            }else{
                max = mid;
            }
        }
        return min;
    }
}
