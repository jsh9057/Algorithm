package study;

import java.util.Arrays;

public class Missile {
    public static int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1]-o2[1]);

        int now = 0;
        for (int[] t : targets){
            int s = t[0];
            int e = t[1];
            if(now>s){ continue; }
            now = e;
            answer++;
        }
        System.out.println(answer);
        return answer;
    }

        public static void main(String[] args) {
            solution(new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}});
        }
}
