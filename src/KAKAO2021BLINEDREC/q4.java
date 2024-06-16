package KAKAO2021BLINEDREC;

public class q4 {
    static final int MAX = 360000;
    public static String solution(String play_time, String adv_time, String[] logs) {
        int playTime = timeToInt(play_time);
        int advTime = timeToInt(adv_time);

        int[] prefixSum = new int[MAX+1];

        for (String log: logs){
            String[] split = log.split("-");
            int start = timeToInt(split[0]);
            int end = timeToInt(split[1]);
            prefixSum[start]++;
            prefixSum[end]--;
        }

        for (int i = 1; i <= MAX; i++) { prefixSum[i] += prefixSum[i-1]; }

        long total = 0;
        for (int i = 0; i < advTime; i++) { total += prefixSum[i]; }

        long max = 0;
        int maxTime = 0;
        for (int i = 1; i <= MAX-advTime; i++) {
            total = total-prefixSum[i-1]+prefixSum[i+advTime-1];
            if(total > max){
                max = total;
                maxTime = i;
            }
        }
        System.out.println(intToTime(maxTime));
        return intToTime(maxTime);
    }

    public static int timeToInt(String time){
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0])*3600;
        int m = Integer.parseInt(split[1])*60;
        int s = Integer.parseInt(split[2]);
        return h+m+s;
    }

    public static String intToTime(int num){
        int h = num/3600;
        int m = (num%3600)/60;
        int s = num%60;
        return String.format("%02d:%02d:%02d",h,m,s);
    }
    public static void main(String[] args) {
        solution("02:03:55"	,"00:14:15",new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});
        solution("99:59:59"	,"25:00:00",new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"});
        solution("50:00:00"	,"50:00:00",new String[]{"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"});
    }
}