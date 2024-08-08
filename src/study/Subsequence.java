package study;

import java.util.Arrays;

public class Subsequence {
    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int s=0;
        int e=0;
        int len =0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while (true){
            if(sum<k){
                if(e>=sequence.length){break;}
                sum += sequence[e];
                len++;
                e++;
            }
            else{
                if((sum == k) && (len<minLen)){
                    answer[0]=s; answer[1]=e-1;
                    minLen = len;
                }
                sum -= sequence[s];
                s++;
                len--;
            }
        }
        System.out.println(Arrays.toString(answer));

        return answer;
    }

//    [1, 2, 3, 4, 5]	7	[2, 3]
//[1, 1, 1, 2, 3, 4, 5]	5	[6, 6]
//[2, 2, 2, 2, 2]	6	[0, 2]

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4, 5},7);
        solution(new int[]{1, 1, 1, 2, 3, 4, 5},5);
        solution(new int[]{2, 2, 2, 2, 2},6);

    }
}
