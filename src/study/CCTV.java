package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CCTV {

    public static int solution(int[][] routes) {
        ArrayList<Car>[] loc = new ArrayList[60001];
        HashSet<Integer> check = new HashSet<>();
        int n = 0;
        for (int[] r: routes){
            int start = r[0] + 30000;
            int end = r[1] + 30000;
            if(loc[start]==null){ loc[start]=new ArrayList<>(); }
            if(loc[end]==null){ loc[end]=new ArrayList<>(); }
            loc[start].add(new Car(n,true));
            loc[end].add(new Car(n,false));
            check.add(n++);
        }

        int cctv = 0;
        ArrayList<Integer> road = new ArrayList<>();
        for (int i = 0; i <= 60000; i++) {
            if(loc[i]==null){ continue; }
            boolean isOut = false;
            for (Car car:loc[i]){
                if(car.isIn){ road.add(car.n); }
                else{
                    if(check.contains(car.n)) { isOut = true; }
                }
            }
            if(isOut){
                for (int r: road){ check.remove(r); }
                cctv++;
            }
        }
        System.out.println(cctv);
        return cctv;
    }

    static class Car{
        int n;
        boolean isIn;

        public Car(int n, boolean isIn) {
            this.n = n;
            this.isIn = isIn;
        }
    }

    public static void main(String[] args) {
        solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}});
    }
}