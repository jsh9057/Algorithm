package KaKaoWinterIntern;

import java.util.Arrays;
import java.util.HashMap;

public class Hotel {
    static HashMap<Long, Long> map ;
    public static void main(String args[]){
        System.out.println(Arrays.toString(solution(new long[]{1,3,4,1,3,1}, 10)));
    }
    public static long[] solution (long[] room_number, int k ){
        long[] result = new long[room_number.length];
        map = new HashMap<>();
        for(int i=0; i<room_number.length; i++){
            result[i]=findRoom(room_number[i]);
        }
        System.out.println(map.toString());
        return result;
    }
    public static long findRoom(long room){
    }
}
