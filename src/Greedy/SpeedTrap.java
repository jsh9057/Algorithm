package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SpeedTrap {
    public static void main(String args[]){
        int[][][] arr = {
            {{-2,-1},{1,2},{-3,0}},
            {{0,0}},
            {{0,1},{0,1},{1,2}},
            {{0,1},{2,3},{4,5},{6,7}},
            {{-20,-15},{-14,-5},{-18,-13},{-5,-3}},
            {{-20,15},{-14,-5},{-18,-13},{-5,-3}},
            {{-20,15},{-20,-15},{-14,-5},{-18,-13},{-5,-3}},
            {{0,12},{1,12},{2,12},{3,12},{5,6},{6,12},{10,12}},
            {{0,0},{0,0},{2,2}},
            {{0,1},{0,1},{2,2}},
                {{0,14},{1,4},{3,8},{10,12},{5,6},{2,9}},
                {{0,14},{1,9},{3,8},{8,12},{5,6},{2,9}},
        };
        int[] answer = {
                2,
                1,
                1,
                4,
                2,
                2,
                2,
                2,
                2,
                2,
                3,
                2
                };
        for(int i=0; i<arr.length; i++){
            int expected = solution(arr[i]);
            if(expected != answer[i]){
                System.out.println(i+" 번째 틀림");
                System.out.println("expected: "+answer[i]);
                System.out.println("but: "+expected);
            }else{
                System.out.println(i+" 번째 통과");
            }
            System.out.println("------------------");
        }

    }

        public static int solution(int[][] routes){
            Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
            int ans = 0;
            int last_camera = Integer.MIN_VALUE;
            for (int[] a : routes) {
                if (last_camera < a[0]) {
                    ++ans;
                    last_camera = a[1];
                }
            }
            return ans;
    }
}

