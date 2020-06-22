package Stack_Queeue;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q_Truck {

    public static class Truck{
        int weight;
        int x;
        public Truck(int weight){
            this.weight=weight;
            this.x=0;
        }
    }

    public static void main(String args[]){
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights ={10,10,10,10,10,10,10,10,10,10};
        int answer=0;
        int finishTruck=truck_weights.length;

        Queue<Truck> waitTruck = new LinkedList<>();
        ArrayList<Truck> ingTruck = new ArrayList<>();

        int nowBridgeWeight=0;

        for(int i=0; i<truck_weights.length; i++)
            waitTruck.add(new Truck(truck_weights[i]));

        while(finishTruck!=0){

            if(ingTruck.size()!=0){
                for(int i=0; i<ingTruck.size(); i++) {ingTruck.get(i).x = ingTruck.get(i).x+1;
                    System.out.println("다리위의 차 ("+i+") 현재x : "+ingTruck.get(i).x);}

                if(ingTruck.get(0).x==bridge_length){
                    nowBridgeWeight = nowBridgeWeight-ingTruck.get(0).weight;
                    ingTruck.remove(0);
                    System.out.println("차 나감");
                    finishTruck--;
                }


                if(waitTruck.size() != 0) {
                    if (weight >= nowBridgeWeight + waitTruck.peek().weight) {
                        System.out.println("새로운차 들어옴");
                        nowBridgeWeight = waitTruck.peek().weight + nowBridgeWeight;
                        ingTruck.add(waitTruck.poll());
                    }
                }
            }
            else if(ingTruck.size() == 0){
                nowBridgeWeight = nowBridgeWeight + waitTruck.peek().weight;
                ingTruck.add(waitTruck.poll());
                System.out.println("초기 차 들어옴");
            }

            answer++;
            System.out.println("--------------------------("+answer+") 현재 다리 무게: "+ nowBridgeWeight +"  -------------------------------");
        }
        System.out.println(answer);
    }
}
