package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SpeedTrap {
    public static void main(String args[]){
        int[][][] arr = {
            {{-2,-1},{1,2},{-3,0}},
//            {{0,0}},
//            {{0,1},{0,1},{1,2}},
//            {{0,1},{2,3},{4,5},{6,7}},
//            {{-20,-15},{-14,-5},{-18,-13},{-5,-3}},
//            {{-20,15},{-14,-5},{-18,-13},{-5,-3}},
//            {{-20,15},{-20,-15},{-14,-5},{-18,-13},{-5,-3}},
//            {{0,12},{1,12},{2,12},{3,12},{5,6},{6,12},{10,12}},
//            {{0,0},{0,0},{2,2}},
//            {{0,1},{0,1},{2,2}},
//                {{0,14},{1,4},{3,8},{10,12},{5,6},{2,9}},
//                {{0,14},{1,9},{3,8},{8,12},{5,6},{2,9}},
        };
        int[] answer = {
                2,
//                1,
//                1,
//                4,
//                2,
//                2,
//                2,
//                2,
//                2,
//                2,
//                3,
//                2
                };
        for(int i=0; i<arr.length; i++){
            int expected = solution(arr[i]);
            if(expected != answer[i]){
                System.out.println(i+" 번째 틀림");
                System.out.println("expected: "+answer[i]);
                System.out.println("but: "+expected);
            }else{
                System.out.println(i+" 번째 통과");
            }
            System.out.println("------------------");
        }

    }

        public static int solution(int[][] routes){
            PriorityQueue<Car> cq = new PriorityQueue<>((Car o1, Car o2)-> o1.exitNum - o2.exitNum);
            Arrays.sort(routes, (int[] o1, int[] o2)-> o1[0] - o2[0]);
            for(int[] r : routes){
                System.out.println("시작 : "+r[0] +" 끝 : "+ r[1]);
            }


            int index = 0;
            int nextPath = 0;
            int amountOfCamera = 0;
            while(index +1 < routes.length){
                nextPath = routes[index+1][0];
                cq.add(new Car(routes[index][0],routes[index][1]));

                if(cq.peek().exitNum < nextPath) {
                    cq.clear();
                    amountOfCamera++;
                }
                index ++;
            }
            amountOfCamera++;

            return amountOfCamera;
        }

    }
    class Car {

        int currNum;
        int exitNum;

        Car(int currNum, int exitNum) {
            this.currNum = currNum;
            this.exitNum = exitNum;
        }
    }

