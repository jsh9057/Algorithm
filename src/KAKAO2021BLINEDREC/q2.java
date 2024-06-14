package KAKAO2021BLINEDREC;

import java.util.*;

public class q2 {
    static HashMap<String, List<Integer>> queryToScoreList;
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        queryToScoreList = new HashMap<>();

        for (String in :info){
            String[] split = in.split(" ");
            String[] q = new String[4];
            int score = Integer.parseInt(split[4]);
            // 모든 info 경우의 수
            for (int i = 0; i < 2; i++) {
                q[0]=select(split[0],i);
                for (int j = 0; j < 2; j++) {
                    q[1]=select(split[1],j);
                    for (int k = 0; k < 2; k++) {
                        q[2]=select(split[2],k);
                        for (int l = 0; l < 2; l++) {
                            q[3]=select(split[3],l);
                            String queryString = toQuery(q);
                            List<Integer> ret = queryToScoreList.getOrDefault(queryString,new ArrayList<>());
                            ret.add(score);
                            queryToScoreList.put(queryString,ret);
                        }
                    }
                }
            }
        }

        for (String key : queryToScoreList.keySet()){
            Collections.sort(queryToScoreList.get(key));
        }

        int i = 0;
        for (String q : query){
            String[] split = q.split(" and ");
            String[] split2 = split[3].split(" ");
            split[3]=split2[0];
            int score = Integer.parseInt(split2[1]);

            String queryString = toQuery(split);
            List<Integer> scoreList = queryToScoreList.get(queryString);

            if(scoreList == null){ answer[i++] = 0; continue;}
            answer[i++] = scoreList.size() - lowerBound(queryToScoreList.get(queryString),score);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    // 특정 값 이상인 첫 위치
    public static int lowerBound(List<Integer> list, int value){
        int max = list.size();
        int min = 0;
        while(min<max){
            int mid = (min+max)/2;
            if(value > list.get(mid)){
                min = mid+1;
            }else{
                max = mid;
            }
        }
        return min;
    }

    static String select(String s, int i){
        if(i==0){ return s;}
        else{ return "-";}
    }

    static String toQuery(String[] q){
        StringBuilder sb = new StringBuilder();
        for (String s: q){ sb.append(s); }
        return sb.toString();
    }

    public static void main(String[] args) {
        solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});
    }
}