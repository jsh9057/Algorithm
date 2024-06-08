package KAKAO2022BLINDREC;

import java.util.*;

public class q3 {

    public static int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> record = new HashMap<>();
        HashMap<String, Integer> total = new HashMap<>();

        for (String r : records){
            String[] split = r.split(" ");
            if(split[2].equals("IN")){
                record.put(split[1],timeToInt(split[0]));
            }else {
                int sum = timeToInt(split[0])-record.get(split[1]);
                total.put(split[1],sum+total.getOrDefault(split[1],0));
                record.remove(split[1]);
            }
        }

        for(String key :record.keySet()){
            int sum = timeToInt("23:59") - record.get(key);
            total.put(key, total.getOrDefault(key,0) + sum);
        }

        List<String> keySet = new ArrayList<>(total.keySet());
        Collections.sort(keySet);
        int[] answer = new int[keySet.size()];
        for (int i = 0; i < keySet.size(); i++) {
            answer[i] = getFee(total.get(keySet.get(i)), fees);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static int getFee(int time, int[] fees){
        int ret = 0;
        if(time >= fees[0]){
            ret=fees[1];
            time-=fees[0];
        }else {
            return fees[1];
        }
        double ceil = (double) time / fees[2];
        ret += (int) Math.ceil(ceil)*fees[3];
        return ret;
    }

    public static int timeToInt(String time){
        String[] split = time.split(":");
        int tmp = Integer.parseInt(split[0])*60;
        tmp += Integer.parseInt(split[1]);
        return tmp;
    }

    public static void main(String[] args) {
        solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"});
        solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"});
    }
}
