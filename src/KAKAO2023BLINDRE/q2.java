package KAKAO2023BLINDRE;

import java.util.ArrayDeque;
import java.util.Deque;

public class q2 {
    static class Item {
        int cost;
        int count;

        public Item(int cost, int count) {
            this.cost = cost;
            this.count = count;
        }
    }
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        Deque<Item> deliveryQ = new ArrayDeque<>();
        Deque<Item> pickupQ = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if(deliveries[i]!=0){
                deliveryQ.addLast(new Item(i+1,deliveries[i]));
            }
            if(pickups[i]!=0){
                pickupQ.addLast(new Item(i+1,pickups[i]));
            }
        }

        int cost=0;
        while ( !deliveryQ.isEmpty() || !pickupQ.isEmpty()){
            int nowCap = cap;

            int dCost = 0;
            int pCost = 0;
            if(!deliveryQ.isEmpty()){ dCost = deliveryQ.peekLast().cost;}
            if(!pickupQ.isEmpty()){ pCost = pickupQ.peekLast().cost;}

            int nowCost = (Math.max(dCost, pCost))*2;

            while (!deliveryQ.isEmpty() && nowCap>0){
                Item nowD = deliveryQ.pollLast();
                if(nowCap >= nowD.count){
                    nowCap -= nowD.count;
                }
                else{
                    deliveryQ.addLast(new Item(nowD.cost, nowD.count - nowCap));
                    nowCap = 0;
                }
            }

            nowCap = cap;
            while (!pickupQ.isEmpty() && nowCap>0){
                Item nowP = pickupQ.pollLast();
                if(nowCap >= nowP.count){
                    nowCap -= nowP.count;
                }
                else{
                    pickupQ.addLast(new Item(nowP.cost, nowP.count - nowCap));
                    nowCap = 0;
                }
            }
            cost+= nowCost;
        }
        return cost;
    }
    public static void main(String[] args) {
        int[] d1 = {0,0,1,0,0};
        int[] p1 = {0, 0, 0, 0, 0};
        solution(1, 5, d1, p1);    // 16

        int[] d2 = {0,0};
        int[] p2 = {0,4};
        solution(2, 2, d2, p2);    // 30
    }
}
