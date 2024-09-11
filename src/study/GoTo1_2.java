package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GoTo1_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Node> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        queue.add(new Node(N,-1,0));
        int [] memo = new int[N+1];

        memo[N] = -1;
        while (!queue.isEmpty()){
            Node now = queue.poll();
            if(now.num == 1){
                System.out.println(now.depth);
                memo[now.num] = now.prev;
                break;
            }
            if(now.num%3==0){
                if(memo[now.num/3]==0){
                    queue.add(new Node(now.num/3, now.num, now.depth+1));
                    memo[now.num/3]= now.num;
                }
            }

            if(now.num%2==0){
                if(memo[now.num/2]==0) {
                    queue.add(new Node(now.num / 2, now.num, now.depth + 1));
                    memo[now.num/2]= now.num;
                }
            }
            if(memo[now.num-1]==0) {
                    queue.add(new Node(now.num - 1, now.num, now.depth + 1));
                    memo[now.num-1]= now.num;
            }
        }

        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(1);
        int prev = memo[1];
        while (prev != -1){
            ret.add(prev);
            prev = memo[prev];
        }
        for (int i = ret.size()-1; i >= 0 ; i--) {
            System.out.print(ret.get(i)+" ");
        }
    }

    static class Node {
        int num;
        int prev;

        int depth;

        public Node(int num, int prev, int depth) {
            this.num = num;
            this.prev = prev;
            this.depth = depth;
        }
    }
}
