package KAKAO2019.INTERN;

import java.util.*;

public class q3 {
    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        HashMap<Long, Long> room = new HashMap<>();
        for (int i = 0; i < room_number.length; i++) {
            long now = room_number[i];
            while (true){
                Queue<Long> q = new LinkedList<>();
                if(room.containsKey(now)){
                    while (room.containsKey(now)){
                        q.add(now);
                        now = room.get(now);
                    }
                    while (!q.isEmpty()){ room.put(q.poll(),now+1); }
                }
                else{
                    room.put(now, now+1);
                    answer[i]=room.get(now)-1;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(10	,new long[] {1,3,4,1,3,1});
    }
}
