package KAKAO2024WINTERINTERNSHIP;


import java.util.HashMap;
import java.util.PriorityQueue;

public class q4 {

    static boolean[] isUsed;
    static int len;
    static int startIdx;

    public static int solution(int coin, int[] cards) {
        len = cards.length;
        startIdx = cards.length/3;
        isUsed = new boolean[len];

        HashMap<Integer,Integer> cardInfo = new HashMap<>();

        for (int i = 0; i < len; i++) {
            cardInfo.put(cards[i],i);
        }

        PriorityQueue<Card> coin0 = new PriorityQueue<>();
        PriorityQueue<Card> coin1 = new PriorityQueue<>();
        PriorityQueue<Card> coin2 = new PriorityQueue<>();

        for(int i=0;i<len; i++){
            if(!isUsed[i]){
                int nowCard = cards[i];
                int pair = len+1-nowCard;
                Card pairCard = new Card(pair, cardInfo.get(pair));
                if(i<startIdx && pairCard.idx<startIdx){
                    isUsed[i] = true;
                    isUsed[pairCard.idx] = true;
                    coin0.add(pairCard);
                }
                else if(i<startIdx){
                    isUsed[i] = true;
                    isUsed[pairCard.idx] = true;
                    coin1.add(pairCard);
                }
                else{
                    isUsed[i] = true;
                    isUsed[pairCard.idx] = true;
                    coin2.add(pairCard);
                }
            }
        }

        int round = 0;
        int maxRound = (len-startIdx)/2;
        while (round<maxRound){
            round++;
            if(!coin0.isEmpty()){ coin0.poll();}
            else if(!coin1.isEmpty() && round >= coin1.peek().round && coin>=1){
                coin1.poll(); coin-=1;
            }else if(!coin2.isEmpty() && round >= coin2.peek().round && coin>=2){
                coin2.poll(); coin-=2;
            }
            else{
                return round;
            }
        }
        return maxRound;
    }

    static class Card implements Comparable<Card> {
        int n;

        int idx;
        int round;


        public Card(int n, int idx) {
            this.n = n;
            this.idx = idx;
            this.round = Math.round((float) (idx- (startIdx - 1)) /2);
        }

        @Override
        public int compareTo(Card o) {
            if(this.round > o.round ){ return 1; }
            else if(this.round == o.round){ return 0; }
            return -1;
        }
    }

    public static void main(String[] args) {
        solution(4,new int [] {3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4});
        solution(3,new int [] {1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12});
        solution(2,new int[] {5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7});
        solution(10,new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18});
    }


}
