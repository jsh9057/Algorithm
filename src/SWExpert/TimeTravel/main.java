package SWExpert.TimeTravel;

import java.util.LinkedList;

public class main {
    public static void main(String args[]){
        UserSolution s = new UserSolution();
        s.init();
        s.buy(1,1,5,105);
        s.buy(2,1,5,100);
        s.sell(3,1,12,100);
        System.out.println(s.bestProfit(1));
        s.sell(4, 1, 8, 90);
        s.sell(5, 1, 1, 110);
        for(LinkedList<Sell> l : s.sellStockList){
            System.out.println(l.toString());
        }
        s.buy(6, 1, 11, 110);
        for(LinkedList<Integer> l : s.costList){
            System.out.println(l.toString());
        }
        System.out.println(s.bestProfit(1));

    }

    static class UserSolution
    {
        private LinkedList<Buy>[] buyStockList ;
        private LinkedList<Sell>[] sellStockList ;
        private LinkedList<Integer>[] costList;


        public void init()
        {
            buyStockList = new LinkedList[5];
            sellStockList = new LinkedList[5];
            costList=new LinkedList[5];
            for(int i=0; i<5;i++){
                buyStockList[i]=new LinkedList<>();
                sellStockList[i]=new LinkedList<>();
                costList[i]=new LinkedList<>();
            }


        }

        public int buy(int mNumber, int mStock, int mQuantity, int mPrice)
        {
            main.Buy newBuy = new Buy(mNumber,mStock,mQuantity,mPrice);
            LinkedList<Sell> sells = sellStockList[mStock];
            LinkedList<Buy> buys = buyStockList[mStock];

            if(sells.isEmpty()){ buys.add(newBuy); }                               // 미체결 매수가 없을 때.
            else{
                sells.sort((o1, o2) -> {
                    if(o1.mPrice!=o2.mPrice){return o1.mPrice-o2.mPrice;}   // 가격 오름차순
                    return o1.mNumber-o2.mNumber;                           // 주문 번호 오름 차순
                });
                while( !sells.isEmpty() && sells.get(0).mPrice <= mPrice ){
                    Sell s = sells.get(0);
                    int minQ = Math.min(newBuy.mQuantity, s.mQuantity);
                    newBuy.mQuantity -= minQ;
                    s.mQuantity -= minQ;
                    costList[mStock].add(s.mPrice);
                    if(s.mQuantity==0){sells.remove(s);}
                    if(newBuy.mQuantity==0){break;}
                }
                if(newBuy.mQuantity!=0){buys.add(newBuy);}
            }
            return newBuy.mQuantity;
        }

        public int sell(int mNumber, int mStock, int mQuantity, int mPrice)
        {
            Sell newSell = new Sell(mNumber,mStock,mQuantity,mPrice);
            LinkedList<Sell> sells = sellStockList[mStock];
            LinkedList<Buy> buys = buyStockList[mStock];

            if(buys.isEmpty()){sells.add(newSell);}
            else{
                buys.sort((o1, o2) -> {
                    if(o2.mPrice!=o1.mPrice){return o2.mPrice-o1.mPrice;}
                    return o1.mNumber-o2.mNumber;
                });

                while( !buys.isEmpty() && buys.get(0).mPrice >= mPrice ){
                    Buy b = buys.get(0);
                    int minQ = Math.min(newSell.mQuantity, b.mQuantity);
                    newSell.mQuantity -= minQ;
                    b.mQuantity -= minQ;
                    costList[mStock].add(b.mPrice);
                    if(b.mQuantity==0){buys.remove(b);}
                    if(newSell.mQuantity==0){break;}
                }
                if(newSell.mQuantity!=0){sells.add(newSell);}
            }
            return newSell.mQuantity;
        }

        public void cancel(int mNumber)
        {
            for(LinkedList<Buy> bl : buyStockList){
                for(Buy b : bl){ if(b.mNumber == mNumber){bl.remove(b);} }
            }
            for(LinkedList<Sell> sl : sellStockList){
                for(Sell s : sl){if(s.mNumber == mNumber){sl.remove(s);}}
            }
        }

        public int bestProfit(int mStock)
        {
            int max = 0;
            LinkedList<Integer> costs = costList[mStock];
            for(int i=0; i<costs.size(); i++){
                for(int j=i; j<costs.size(); j++){
                    int a = costs.get(i);
                    int b = costs.get(j);
                    max= Math.max(b-a,max);
                }
            }
            return max;
        }
    }
    static class Buy {
        @Override
        public String toString() {
            return "Buy{" +
                    "mNumber=" + mNumber +
                    ", mStock=" + mStock +
                    ", mQuantity=" + mQuantity +
                    ", mPrice=" + mPrice +
                    '}';
        }

        int mNumber;        // 매수 주문
        int mStock;         // 주식 종목
        int mQuantity;      // 수량
        int mPrice;         // 희망가격

        public Buy(int mNumber, int mStock, int mQuantity, int mPrice) {
            this.mNumber = mNumber;
            this.mStock = mStock;
            this.mQuantity = mQuantity;
            this.mPrice = mPrice;
        }
    }
    static class Sell {
        @Override
        public String toString() {
            return "Sell{" +
                    "mNumber=" + mNumber +
                    ", mStock=" + mStock +
                    ", mQuantity=" + mQuantity +
                    ", mPrice=" + mPrice +
                    '}';
        }

        int mNumber;        // 매수 주문
        int mStock;         // 주식 종목
        int mQuantity;      // 수량
        int mPrice;         // 희망가격

        public Sell(int mNumber, int mStock, int mQuantity, int mPrice) {
            this.mNumber = mNumber;
            this.mStock = mStock;
            this.mQuantity = mQuantity;
            this.mPrice = mPrice;
        }
    }
}
