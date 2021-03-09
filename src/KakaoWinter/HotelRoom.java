package KakaoWinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HotelRoom {
    public static void main(String args[]){
        long k=10;
        long[] room_number={1,3,4,1,3,1};

        HotelRoom hotelRoom = new HotelRoom();
        System.out.println(Arrays.toString(hotelRoom.unionFind(k,room_number)));
    }

    public long[] unionFind(long k, long[] room_number){
        long[] answer= new long [room_number.length];
        HashMap<Long,Long> hm = new HashMap<>();
        for(int i=0; i<room_number.length; i++){
            long request =room_number[i];
            if(!hm.containsKey(request)){
                hm.put(request,request+1); answer[i]=request;}
            else{
                ArrayList<Long> list = new ArrayList<>();
                while(hm.containsKey(request)) {
                    list.add(request);
                    request = hm.get(request);
                }
                answer[i]=request;
                list.add(request);
                for(Long l : list){
                    hm.put(l,request+1);
                }
            }
        }
        return answer;
    }
}
