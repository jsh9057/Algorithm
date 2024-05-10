package BLIND_2022;

import java.util.*;

/*
    Record {
        int num;
        int time;
    }

    HashMap<차량번호, PriorityQueue<Record>> map

    PriorityQueue<Integer> q // 시간의 오름차순으로 뽑아내기위해 정렬

    모든 레코드를 읽은뒤에 각 차량번호로 접근해서 큐의 크기가 홀수라면
    큐에 (차량번호,1439) 넣어줍니다.
 */

public class Parking {
    static int[] feeInfo;
    public static void main(String[] args) {
        int[] fees={180, 5000, 10, 600};    // 기본시간, 기본요금, 단위시간, 단위요금
        String[] records={"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        feeInfo=fees;
        Set<Integer> nums = new HashSet<>();

        ArrayList<Record> list = new ArrayList<>();
        for(int i=0;i<records.length; i++){
            String[] split = records[i].split(" ");
            String[] timeStr = split[0].split(":");
            int time = Integer.parseInt(timeStr[0])*60;
            time+= Integer.parseInt(timeStr[1]);

            list.add(new Record(Integer.parseInt(split[1]),split[2]));
        }
        Collections.sort(list);
        HashMap<Integer,Integer> times = new HashMap<>();
        for(int i=1; i<list.size(); i++){
            int in = list.get(i-1).time;
            int out = 1439;
            if(list.get(i).number == list.get(i-1).number){out = list.get(i).time;}
            else {i++;}

            int time = out-in;
            if(times.containsKey(list.get(i-1))){
                times.put(list.get(i-1).number,times.get(list.get(i-1))+time);
            }
            times.put(list.get(i-1).number,time);
        }
        System.out.println(times.toString());


    }
    static class Record implements Comparable<Record>{
        int number;
        int time;
        int kind; // 0 : 입 / 1: 출

        public Record(int number, String str) {
            this.number = number;
            if(str.equals("IN")){kind=0;}
            else{kind=1;}
        }
        @Override
        public int compareTo(Record o) {
            if(this.number == o.number){ return this.time- o.time;}
            return this.number-o.number;}
    }
}
