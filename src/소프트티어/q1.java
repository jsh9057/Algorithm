package 소프트티어;
import java.io.*;
import java.util.*;

public class q1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int W = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        PriorityQueue<Item> pq = new PriorityQueue<Item>(
                (i1, i2)-> i2.v - i1.v
        );
        for(int i=0; i<K; i++){
            split = br.readLine().split(" ");
            pq.add(new Item(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }

        int ret = 0;
        while(!pq.isEmpty()){
            Item now = pq.poll();
            int how = Math.min(W,now.w);
            W -= how;
            ret += how*now.v;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ret);
        System.out.println(sb);
    }

    static class Item {
        int w;
        int v;

        public Item(int w, int v){
            this.w = w;
            this.v = v;
        }
    }
}
