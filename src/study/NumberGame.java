package study;

import java.util.Arrays;

public class NumberGame {
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int aMax = A.length-1, bMax=B.length-1;

        while (aMax>=0){
            if(A[aMax]<B[bMax]){ answer++; aMax--; bMax--;}
            else{ aMax--;}
        }
        System.out.println(answer);
        return answer;
    }
//    [5,1,3,7]	[2,2,6,8]	3
//[2,2,2,2]	[1,1,1,1]
    public static void main(String[] args) {
        solution(new int[]{5,1,3,7}, new int[]{2,2,6,8});
        solution(new int[]{2,2,2,2}, new int[]{1,1,1,1});
    }
}
