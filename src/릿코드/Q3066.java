package 릿코드;
import java.util.*;

public class Q3066 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b)->  a.compareTo(b));
        for(int i=0;i<nums.length;i++){ pq.add((long)nums[i]); }

        int cnt = 0;
        while(!pq.isEmpty()){
            Long a = pq.poll();
            if(a>=k){ return cnt; }
            Long b = pq.poll();
            pq.add(Math.min(a,b)*2+ Math.max(a,b));
            cnt++;
        }
        return -1;
    }
}
