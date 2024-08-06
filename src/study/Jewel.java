package study;

import java.util.*;

public class Jewel {
    public static int[] solution(String[] gems) {
        Queue<String> queue = new LinkedList<>();
        HashMap<String,Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        int kind = set.size();
        for (int i = 0; i < kind; i++) {
            queue.add(gems[i]);
            map.put(gems[i],map.getOrDefault(gems[i],0)+1);
        }
        int s=0;
        int e=kind-1;
        int minLen=Integer.MAX_VALUE;;
        int len = e-s;
        int[] answer = new int[2];
        while (e < gems.length){
            if(map.size()<kind){
                e++;
                len++;
                if(e==gems.length){break;}
                queue.add(gems[e]);
                map.put(gems[e],map.getOrDefault(gems[e],0)+1);
            }
            else if(map.size()==kind && minLen>len){
                minLen = len;
                answer[0]=s+1;
                answer[1]=e+1;
            }
            else {
                s++;
                len--;
                String gem = queue.poll();
                if(map.get(gem)==1){ map.remove(gem); }
                else{ map.put(gem, map.get(gem)-1); }
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
    public static void main(String[] args) {
        solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        solution(new String[]{"AA", "AB", "AC", "AA", "AC"});
        solution(new String[]{"XYZ", "XYZ", "XYZ"});
        solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"});
        solution(new String[]{"A", "B" ,"B", "C", "A", "B", "C", "A","B","C"});
        solution(new String[]{"A", "B", "A", "A", "A", "C", "A", "B"});
    }
}
