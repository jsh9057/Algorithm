package 릿코드;
import java.util.*;

public class Q3264 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Node> pq = new PriorityQueue<>((Node e1, Node e2)->{
            if(e1.n==e2.n){ return e1.idx-e2.idx; }
            else { return e1.n-e2.n; }
        });
        for(int i=0;i<nums.length;i++){
            pq.add(new Node(nums[i],i));
        }

        while(k>0){
            Node now = pq.poll();
            System.out.println(now.n);
            pq.add(new Node((now.n)*multiplier,now.idx));
            k--;
        }
        int[] ret = new int[nums.length];
        while(!pq.isEmpty()){
            Node now = pq.poll();
            ret[now.idx]=now.n;
        }
        return ret;
    }

    static class Node{
        int n;
        int idx;

        Node(int n, int idx){
            this.n=n;
            this.idx=idx;
        }
    }
}
