package KAKAO2022BLINDREC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class q1 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashSet<String>[] reportList = new HashSet[id_list.length];
        HashMap<String,Integer> idToIdx = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) { reportList[i]=new HashSet<>(); }
        for (int i = 0; i < id_list.length; i++) { idToIdx.put(id_list[i],i); }

        for (int i = 0; i < report.length; i++) {
            String[] split = report[i].split(" ");
            reportList[idToIdx.get(split[1])].add(split[0]);
        }

        for (int i = 0; i < reportList.length; i++) {
            if (reportList[i].size() < k) { continue; }
            for (String id : reportList[i]) { answer[idToIdx.get(id)]++; }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
        solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
        solution(new String[]{"a", "b", "c", "d"}, new String[]{"a b", "a b", "c a", "d a", "a b", "c d", "a d", "b c", "b a", "d a"}, 2);


    }
}
