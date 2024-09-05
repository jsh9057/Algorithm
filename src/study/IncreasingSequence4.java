package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class IncreasingSequence4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) { A[i] = Integer.parseInt(split[i]); }

        int maxNode = -1;
        int maxLen = -1;
        Node[] dp = new Node[N];
        for (int i = 0; i < N; i++) {
            dp[i] = new Node(1,A[i],i);
            for (int j = 0; j < i; j++) {
                if(A[i]<=A[j]) { continue; }
                if(dp[j].len+1 > dp[i].len){
                    dp[i] = new Node(dp[j].len+1,A[i],j);
                }
            }
            if(maxLen < dp[i].len){
                maxNode = i;
                maxLen = dp[i].len;
            }
        }
        System.out.println(maxLen);
        ArrayList<Integer> list = new ArrayList<>();
        if(maxLen == 1){ System.out.println(dp[maxNode].value); return; }
        while (true){
            list.add(dp[maxNode].value);
            maxNode = dp[maxNode].prevIdx;
            if(dp[maxNode].prevIdx == maxNode){
                list.add(dp[maxNode].value);
                break;
            }
        }
        for (int i = list.size()-1; i >= 0 ; i--) {
            System.out.print(list.get(i)+" ");
        }
    }

    static class Node{
        int len;
        int value;
        int prevIdx;

        public Node(int len, int value, int prevIdx) {
            this.len = len;
            this.value = value;
            this.prevIdx = prevIdx;
        }
    }
}
