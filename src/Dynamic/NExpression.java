package Dynamic;

import java.util.LinkedList;
import java.util.Queue;

public class NExpression {
    public static void main(String args[]){
        int N=2;
        int number = 11;
        int sol = solution(N,number);
        System.out.println(sol);
    }

    static final int MAX_RANGE=32000;
    static final int MAX_N = 8;
    public static int solution(int N, int number) {
        int answer = 0;
        int[] arr = new int[MAX_RANGE];
        boolean[] visit = new boolean[MAX_RANGE];
        int digit = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        arr[N] = 1;
        answer = 1;

        while (answer <= MAX_N) {
            digit += Math.pow(10, answer);
            while (!q.isEmpty()) {
                int n = q.poll();
                int plus = N + n;
                int sub = n - N;
                int mul = n * N;
                int div = n / N;

                int value = plus;
                int re = compute(value, q, arr, visit, answer, number);
                if (re != -1) return re;

                value = sub;
                re = compute(value, q, arr, visit, answer, number);
                if (re != -1) return re;

                value = mul;
                re = compute(value, q, arr, visit, answer, number);
                if (re != -1) return re;

                value = div;
                re = compute(value, q, arr, visit, answer, number);
                if (re != -1) return re;

                value = digit*N;
                re = compute(value, q, arr, visit, answer, number);
                if (re != -1) return re;
            }
            answer++;
        }
        return -1;
//        System.out.println(answer);
    }
    public static boolean isRange(int n){
        return (n>0 && n<MAX_RANGE) ? true :  false;
    }
    public static void minReturn(int n, int[] arr, int answer){
        if(arr[n]==0) { arr[n]= answer;}
        else {arr[n]= Math.min(arr[n],answer);}
    }
    public static int compute(int value, Queue<Integer> q, int[] arr, boolean[] visit, int answer, int number){
        if (isRange(value)&&visit[value]==false) {
            q.add(value);
            minReturn(value, arr, answer);
            visit[value]=true;
            if (value == number) {
                return answer;
            }
        }
        return -1;
    }
}
