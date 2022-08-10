package Toss;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class n5 {
    public static void main(String[] args) {
        int[] tasks= {1,1,2,3,3,2,2};
        int lne = tasks.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<lne;i++){ map.put(tasks[i],map.getOrDefault(tasks[i],0)+1); }
        Iterator<Integer> it = map.keySet().iterator();
        int cnt = 0;
        while (it.hasNext()){
            int key = it.next();
            if(map.get(key)==1){ System.out.println( -1);return;}
        }
        it = map.keySet().iterator();
        while (it.hasNext()){
            int key = it.next();
            if(map.get(key)>=3){ map.put(key,map.get(key)-3); cnt+=1;}
            else if(map.get(key)>=2){map.put(key,map.get(key)-2); cnt+=1;}
            else if(map.get(key)==1){map.remove(key); cnt+=1;}
            else if(map.get(key)==0){map.remove(key);}
        }
        System.out.println(cnt);

    }
}
