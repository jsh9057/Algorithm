package 릿코드;
import java.util.*;

public class Q2558 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1,e2)->(e2-e1));
        for(int g: gifts){
            pq.add(g);
        }

        while(k>0){
            k--;
            pq.add((int)(Math.sqrt(pq.poll())));
        }

        long ret = 0;
        while(!pq.isEmpty()){
            ret+=pq.poll();
        }
        return ret;
    }
}

