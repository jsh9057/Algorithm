package KAKAO2019.INTERN;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class q5 {
    public static int[] solution(String s) {
        List<List<Integer>> tupleList = new ArrayList<>();

        s = s.substring(1,s.length()-1);
        String[] split = s.split("\\{|\\}");
        for (String str: split){
            if(str.equals(",")){ continue; }
            String[] strArr=str.split(",");
            List<Integer> list = new ArrayList<>();

            for (String strA :strArr){
                if(strA.length()==0){continue;}
                list.add(Integer.parseInt(strA));
            }
            if (list.size()!=0){tupleList.add(list);}
        }
        tupleList.sort((o1, o2) -> o1.size()-o2.size());

        int[] ret = new int[tupleList.size()];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < tupleList.size(); i++) {
            for (int j = 0; j < tupleList.get(i).size(); j++) {
                if(set.contains(tupleList.get(i).get(j))){ continue; }
                else{
                    ret[i]=tupleList.get(i).get(j);
                    set.add(ret[i]);
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        solution("{{20,111},{111}}");
        solution("{{123}}");
        solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
    }
}
