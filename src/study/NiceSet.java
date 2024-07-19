package study;

import java.util.Arrays;

public class NiceSet {
    public static int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(s/n == 0){ return new int[]{-1}; }

        int tmp = s%n;
        Arrays.fill(answer, s/n);
        for (int i = n-1; i >= 0; i--) {
            if(tmp==0){ break;}
            answer[i]++; tmp--;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2,9)));
        System.out.println(Arrays.toString(solution(2,1)));
        System.out.println(Arrays.toString(solution(2,8)));
    }
}
