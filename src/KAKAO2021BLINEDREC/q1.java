package KAKAO2021BLINEDREC;

import java.util.*;

public class q1 {
    static HashMap<String, Integer> comb;
    static int[] max;
    public static String[] solution(String[] orders, int[] course) {
        max = new int[course.length];

        List<String> result = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            comb = new HashMap<>();
            for (int j = 0; j < orders.length; j++) {
                char[] sortOrder = orders[j].toCharArray();
                Arrays.sort(sortOrder);
                setComb(sortOrder,course[i],0,0,new char[course[i]], i);
            }
            if(max[i]>1){
                for (String key :comb.keySet()){
                    if(comb.get(key)==max[i]){ result.add(key);}
                }
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    static void setComb(char[] o, int course, int idx, int depth, char[] c, int courseIdx){
        if(depth == course){
            String combString = new String(c);
            comb.put(combString,comb.getOrDefault(combString,0)+1);
            max[courseIdx] = Math.max(comb.get(combString),max[courseIdx]);
            return;
        }

        for (int i = idx; i < o.length; i++) {
            c[depth]=o[i];
            setComb(o,course,i+1,depth+1, c, courseIdx);
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4})));
        solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2,3,5});
        solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2,3,4});
    }

}
