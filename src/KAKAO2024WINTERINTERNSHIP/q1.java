package KAKAO2024WINTERINTERNSHIP;

import java.util.HashMap;

public class q1 {

    public static int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> nameList = new HashMap<>();
        int friendCnt = friends.length;
        for (int i = 0; i < friendCnt; i++) {
            nameList.put(friends[i],i);
        }

        int[][] history = new int[50][50];
        for (int i = 0; i < gifts.length; i++) {
            String[] split = gifts[i].split(" ");
            int from = nameList.get(split[0]);
            int to = nameList.get(split[1]);

            history[from][to]+=1;
        }

        int[] nextMonth = new int[friendCnt];
        int[] giftScore = new int[friendCnt];

        for(int i=0;i<friendCnt; i++){
            int toGiftCnt = 0;
            int fromGiftCnt = 0;

            for(int k = 0; k <friendCnt; k++){
                toGiftCnt += history[i][k];
            }
            for(int k = 0; k <friendCnt; k++){
                fromGiftCnt += history[k][i];
            }
            int score = toGiftCnt - fromGiftCnt;
            giftScore[i]=score;
        }


        for (int i = 0; i < friendCnt; i++) {
            for (int j = i; j < friendCnt; j++) {
                if(i==j){continue;}

                int a = history[i][j];
                int b = history[j][i];

                if(history[i][j]==0 && history[j][i]==0 || a==b){
                    a = giftScore[i];
                    b = giftScore[j];
                    if(a!=b){
                        nextMonth[a>b ? i:j]+=1;
                    }
                }
                else {
                    a = history[i][j];
                    b = history[j][i];
                    if(a!=b){
                        nextMonth[a>b ? i:j]+=1;
                    }
                }
            }
        }
        int max = 0;
        for (int i=0;i<friendCnt;i++){
            max = Math.max(max, nextMonth[i]);
        }
        System.out.println(max);
        return max;
    }
    public static void main(String[] args) {
        String[] friends = new String[]{"muzi", "ryan", "frodo", "neo"};
        String[] gifts = new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        solution(friends, gifts);

        friends = new String[]{"joy", "brad", "alessandro", "conan", "david"};
        gifts = new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        solution(friends,gifts);

        friends = new String[]{"a", "b", "c"};
        gifts = new String[]{"a b", "b a", "c a", "a c", "a c", "c a"};
        solution(friends,gifts);
    }
}
