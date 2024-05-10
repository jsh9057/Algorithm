package KAKAO2024WINTERINTERNSHIP;

import java.util.Arrays;
import java.util.HashMap;

public class q2 {
    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];
        HashMap<Integer,int[]> nodes = new HashMap<>();
        // [0]: in
        // [1]: out
        for (int[] e : edges){
            int from = e[0];
            int to = e[1];

            if(!nodes.containsKey(from)){ nodes.put(from,new int[2]); }
            if(!nodes.containsKey(to)){ nodes.put(to,new int[2]); }
            // in
            int[] tmp1 = nodes.get(to);
            tmp1[0]++;
            nodes.put(to,tmp1);

            // out
            int[] tmp2 = nodes.get(from);
            tmp2[1]++;
            nodes.put(from,tmp2);
        }

        int maxGraph = 0;
        for(Integer key: nodes.keySet()){
            int in = nodes.get(key)[0];
            int out = nodes.get(key)[1];
            if(in == 0 && out >=2){ answer[0] = key; maxGraph=out; } // 정점
            if (out == 0) { answer[2]++; }// 막대
            if (out == 2) { answer[3]++; }// 8자
        }

        answer[1]=maxGraph-answer[2]-answer[3];
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][] {{2, 3}, {4, 3}, {1, 1}, {2, 1}})));
        System.out.println(Arrays.toString(solution(new int[][] {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})));

        //solution();
    }

    public static String changeBracket(String[] bracket){
        String ret="";
        for (String b : bracket){
            ret += "\n---------------------------\n";
            String tmp = b.replaceAll("\\[","{");
            ret += tmp.replaceAll("\\]","}");
        }
        return ret;
    }
}