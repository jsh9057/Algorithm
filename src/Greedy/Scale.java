package Greedy;

import java.util.Arrays;

public class Scale {
    public static void main(String args[]) {
        int[] weight = {3, 1, 6, 2, 7, 30, 1};
        int answer;
        Arrays.sort(weight);

        answer = weight[0];
        for (int i = 1; i < weight.length; i++) {
            if (answer + 1 < weight[i]) { break; }
            else { answer += weight[i]; }
        }
        answer++;
        System.out.println(answer);
    }
}