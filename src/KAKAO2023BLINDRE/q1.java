package KAKAO2023BLINDRE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class q1 {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> termInfo = new HashMap<>();

        for (int i = 0; i < terms.length; i++) {
            String[] input = terms[i].split(" ");
            termInfo.put(input[0], Integer.parseInt(input[1]));
        }

        int toDay = dateToInt(today);
        for (int i = 0; i < privacies.length; i++) {
            String[] input = privacies[i].split(" ");
            int date = dateToInt(input[0]);
            int end = date+termInfo.get(input[1])*28;
            if(toDay >= end){ answer.add(i+1); }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int dateToInt(String date){
        int y,m,d;

        String[] input = date.split("\\.");
        y = Integer.parseInt(input[0])*12*28;
        m = Integer.parseInt(input[1])*28;
        d = Integer.parseInt(input[2]);
        return y+m+d;
    }


    public static void main(String[] args) {
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        solution( "2022.05.19", terms, privacies);  // 1,3

        terms = new String[] {"Z 3", "D 5"};
        privacies = new String[] {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        solution( "2020.01.01", terms, privacies);  // 1,4,5
    }
}
