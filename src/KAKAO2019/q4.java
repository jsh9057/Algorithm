package KAKAO2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class q4 {
    public static int solution(int[] food_times, long k) {
        ArrayList<Food> foodList = new ArrayList<>();
        for (int i = 0; i < food_times.length; i++) { foodList.add(new Food(i+1,food_times[i])); }
        Collections.sort(foodList, Comparator.comparingLong(o -> o.time));

        int idx = 0;
        long cycle = 0;
        int size = foodList.size();

        while (idx<foodList.size()){
            if(cycle==foodList.get(idx).time){ idx++; size--; continue; }

            if((foodList.get(idx).time-cycle)*size>k){
                List<Food> ret = foodList.subList(idx, foodList.size());
                ret.sort(Comparator.comparingInt(o -> o.n));
                return ret.get((int) (k%size)).n;
            }
            else{
                k-=size*(foodList.get(idx).time-cycle);
                cycle = foodList.get(idx).time;
            }
            idx++;
            size--;
        }
        return -1;
    }
    public static class Food{
        int n;
        long time;

        public Food(int n, long time) {
            this.n = n;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2}, 5));
        System.out.println(solution(new int[]{2, 5, 2, 3, 2}, 8));
    }
}
