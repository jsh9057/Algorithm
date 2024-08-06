package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fib {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] zero = new int[41];
        zero[0]=1; zero[2]=1;
        int[] one = new int[41];
        one[1]=1; one[2]=1;
        for (int i = 3; i < 41; i++) {
            zero[i] = zero[i-1]+zero[i-2];
            one[i] = one[i-1]+one[i-2];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int t = Integer.parseInt(br.readLine());
            sb.append(zero[t]).append(" ").append(one[t]).append("\n");
        }
        System.out.println(sb);
    }
}
