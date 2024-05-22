package KAKAO2023BLINDRE;

import java.util.ArrayList;
import java.util.List;

public class q3 {
    static int[] discount = {10,20,30,40};
    static List<Emoticon[]> priceList;
    public static int[] solution(int[][] users, int[] emoticons) {
        priceList = new ArrayList<>();

        dfs(0,new Emoticon[emoticons.length],emoticons);

        int maxCost=0;
        int maxCount=0;
        for(Emoticon[] list : priceList){
            int totalCost=0;
            int joinCount=0;

            for (int i = 0; i < users.length; i++) {
                int money = 0;
                for (int j = 0; j < list.length; j++) {
                    Emoticon emoticon = list[j];
                    if(users[i][0]<=emoticon.rate){
                        money+=emoticon.price;
                    }
                }
                if(money>=users[i][1]){
                    money =0;
                    joinCount++;
                }
                totalCost+=money;
            }
            if(joinCount>maxCount){
                maxCount = joinCount;
                maxCost = totalCost;
            }
            else if(joinCount == maxCount){
                maxCost = Math.max(maxCost,totalCost);
            }
        }
        return new int[]{maxCount,maxCost};
    }

    public static void main(String[] args) {
        int[][] users = new int[][] {{40, 10000}, {25, 10000}};
        int[] emoticons = new int[] {7000, 9000};
        solution(users,emoticons);  // {1,5400}

        users = new int[][] {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        emoticons = new int[] {1300, 1500, 1600, 4900};
        solution(users,emoticons); // {4,13860}
    }

    static class Emoticon{
        int price;
        int rate;

        public Emoticon(int price, int rate) {
            this.price = price;
            this.rate = rate;
        }
    }

    static void dfs(int now, Emoticon[] list, int[] emoticons) {
        if(now == emoticons.length){
            priceList.add(list.clone());
            return;
        }

        for (int i = 0; i < 4; i++) {
            int cost = (emoticons[now] * (100 - discount[i])) /100;
            list[now] = new Emoticon(cost, discount[i]);
            dfs(now+1, list, emoticons);
        }
    }
}
