package study;

public class AnalogClock {
    public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int start = timeToSecond(h1,m1,s1);
        int end = timeToSecond(h2,m2,s2);
        double hourAngle = toHourAngle(start);
        double minuteAngle = toMinuteAngle(start);
        double secondAngle = toSecondAngle(start);
        if(hourAngle == secondAngle){ answer++; }
        if(minuteAngle == secondAngle){ answer++; }
        if(hourAngle == secondAngle && secondAngle == minuteAngle){ answer --; }

        while (start < end){
            start++;
            double nowHourAngle = toHourAngle(start);
            double nowMinuteAngle = toMinuteAngle(start);
            double nowSecondAngle = toSecondAngle(start);

            if(hourAngle > secondAngle && nowHourAngle <= nowSecondAngle){ answer++; }
            else if(secondAngle==354 && hourAngle>354){ answer++; }

            if(minuteAngle > secondAngle && nowMinuteAngle <= nowSecondAngle){ answer++; }
            else if(secondAngle==354 && minuteAngle>354){ answer++; }

            if(nowHourAngle == nowSecondAngle && nowSecondAngle == nowMinuteAngle){ answer --; }

            hourAngle = nowHourAngle;
            minuteAngle = nowMinuteAngle;
            secondAngle = nowSecondAngle;
        }
        System.out.println(answer);
        return answer;
    }

    static int timeToSecond(int h, int m, int s){
        int ret = h*60;
        ret = (ret+m)*60;
        ret += s;
        return ret;
    }

    static double toHourAngle(int second){ return (second / 120.0)%360.0; }
    static double toMinuteAngle(int second){ return (second / 10.0)%360.0; }
    static double toSecondAngle(int second){ return (second * 6.0)%360.0; }

    public static void main(String[] args) {
        solution(0,	5,	30	,0,	7,	0);
        solution(12,	0,	0	,12,	0,	30);
        solution( 0,	6,	1,	0	,6,	6);
        solution(11	,59,	30,	12,	0	,0	);
        solution(11,	58,	59,	11,	59,	0);
        solution(1,	5,	5,	1,	5	,6);
        solution(0,	0,	0,	23,	59	,59);
    }
}
