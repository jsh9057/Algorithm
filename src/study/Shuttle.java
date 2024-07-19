package study;

import java.util.ArrayList;
import java.util.Arrays;

public class Shuttle {
    // 횟수,간격,정원
    // 9시 부터
    public static String solution(int n, int t, int m, String[] timetable) {
        int[] intTime = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) { intTime[i] = timeToInt(timetable[i]); }
        Arrays.sort(intTime);

        ArrayList<Integer>[] bus = new ArrayList[n];
        for (int i = 0; i < n; i++) { bus[i]=new ArrayList<>(); }

        int idx = 0;

        for (int time = 540; time <= 540+(n-1)*t; time+=t) {
            int cycle = (time-540)/t;
            int cnt = 0;
            while(intTime.length > idx && time >= intTime[idx]){
                bus[cycle].add(intTime[idx]);
                idx++;
                cnt++;
                if(cnt==m){ break; }
            }
        }
        int ret;
        if(bus[n-1].size()<m){ ret = 540+(n-1)*t; }
        else{ ret = bus[n-1].get(bus[n-1].size()-1)-1; }
        System.out.println(intToTime(ret));
        return intToTime(ret);
    }
    static int timeToInt(String time){
        String[] split = time.split(":");
        return Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
    }
    static String intToTime(int time){
        String h;
        if(time/60<10){ h="0"+time/60; }
        else{ h= String.valueOf(time / 60); }

        String m;
        if(time%60<10){ m="0"+time%60; }
        else{ m= String.valueOf(time % 60); }

        return h+":"+m;
    }
//	"09:00"
//	"09:09"
//  "08:59"
//	"00:00"
//	"09:00"
//	"18:00"
    public static void main(String[] args) {
        solution(1,1,5, new String[]{"08:00", "08:01", "08:02", "08:03"});
        solution(2,10,2, new String[]{"09:10", "09:09", "08:00"});
        solution(2,1,2, new String[]{"09:00", "09:00", "09:00", "09:00"});
        solution(1,1,5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"});
        solution(1,1,1, new String[]{"23:59"});
        solution(10,60,45, new String[]{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"});
        solution(2,10,2, new String[]{"09:10", "09:09", "08:00", "09:09"});
        solution(10, 25, 1,new String[] { "09:00", "09:10" ,"09:20" ,"09:30" ,"09:40" ,"09:50",
                "10:00", "10:10" ,"10:20" ,"10:30" ,"10:40" ,"10:50" });
    }
}
