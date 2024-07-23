package study;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class Traffic {
    static long[][] timestamp;
    public static int solution(String[] lines) {
        int answer = 1;
        timestamp = new long[lines.length][2];
        for (int i = 0; i < lines.length; i++) {
            String[] split = lines[i].split(" ");
            long ing = timeToLong(split[2].substring(0,split[2].length()-1))-1;
            timestamp[i][1] = timeToLong(split[1]);
            timestamp[i][0] = timestamp[i][1] - ing;
        }

        Arrays.sort(timestamp, Comparator.comparingLong(o -> o[0]));

        for (int i = 0; i < lines.length; i++) {
            int cnt = 1;
            for (int j = i-1; j>=0 ; j--) {
                long start = timestamp[i][0];
                if((start - 1000 < timestamp[j][1] && timestamp[j][1] <= start )
                        || (start - 1000 < timestamp[j][0] && timestamp[j][0] <= start)
                        || (timestamp[j][0] <= start-1000 && start<= timestamp[j][1])
                ) { cnt++; }
            }
            answer = Math.max(cnt,answer);
        }
        System.out.println(answer);
        return answer;
    }

    static long timeToLong(String time){
        String[] split = time.split(":");
        if(split.length==1){
            BigDecimal tmp = new BigDecimal(time);
            return tmp.multiply(BigDecimal.valueOf(1000)).longValue();
        }
        long t = Long.parseLong(split[0])*60;
        t = (t + Long.parseLong(split[1]))*60;
        return new BigDecimal(split[2]).add(BigDecimal.valueOf(t)).multiply(BigDecimal.valueOf(1000)).longValue();
    }

    public static void main(String[] args) {
        solution(new String[]{"2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"});
        solution(new String[]{"2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"});
        solution(new String[]{"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"});
    }
}
