package BLIND_2022;

import java.util.*;

public class Report {
    public static void main(String[] args) {
        String[] id_list={"muzi", "frodo", "apeach", "neo"};
        String[] report={"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k=2;

        HashMap<String,Set<String>> list = new HashMap<>();
        HashMap<String,Integer> tag = new HashMap<>();

        for(int i=0;i<id_list.length;i++){tag.put(id_list[i],i);}

        for(String s: id_list){list.put(s,new HashSet<>());}

        for(String s : report){
            String[] split = s.split(" ");
            list.get(split[1]).add(split[0]);
        }

        int[] ret = new int[id_list.length];

        for(String s : list.keySet()){
            Set<String> set = list.get(s);
            if(set.size()>= k){
                Iterator<String> it =  set.iterator();
                while (it.hasNext()){ret[tag.get(it.next())]++;}
            }
        }
        System.out.println(Arrays.toString(ret));
    }
}
