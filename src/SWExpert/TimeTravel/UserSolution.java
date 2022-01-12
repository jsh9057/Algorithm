package SWExpert.TimeTravel;

import java.util.*;


class UserSolution
{
    private PriorityQueue<Buy>[] buyStockList ;
    private PriorityQueue<Sell>[] sellStockList ;
    private LinkedList<Integer>[] costList;
    private int[] bestPro;

    public void init()
    {
        bestPro = new int[6];
        buyStockList = new PriorityQueue[6];
        sellStockList = new PriorityQueue[6];
        costList=new LinkedList[6];
        for(int i=0; i<6;i++){
            buyStockList[i]=new PriorityQueue<>();
            sellStockList[i]=new PriorityQueue<>();
            costList[i]=new LinkedList<>();
        }
    }

    public int buy(int mNumber, int mStock, int mQuantity, int mPrice)
    {
        Buy newBuy = new Buy(mNumber,mStock,mQuantity,mPrice);
        PriorityQueue<Sell> sells = sellStockList[mStock];
        PriorityQueue<Buy> buys = buyStockList[mStock];

        if(sells.isEmpty()){ buys.add(newBuy); }                               // 미체결 매수가 없을 때.
        else{
            while( !sells.isEmpty() && sells.peek().mPrice <= mPrice ){
                Sell s = sells.peek();
                int minQ = Math.min(newBuy.mQuantity, s.mQuantity);
                newBuy.mQuantity -= minQ;
                s.mQuantity -= minQ;
                LinkedList<Integer> costs =costList[mStock];
                costs.add(s.mPrice);
                for(int i=0; i<costs.size()-1; i++){
                    bestPro[mStock] = Math.max(bestPro[mStock],s.mPrice - costs.get(i));
                }
                if(s.mQuantity==0){sells.poll();}
                if(newBuy.mQuantity==0){break;}
            }
            if(newBuy.mQuantity!=0){buys.add(newBuy);}
        }
        return newBuy.mQuantity;
    }

    public int sell(int mNumber, int mStock, int mQuantity, int mPrice)
    {
        Sell newSell = new Sell(mNumber,mStock,mQuantity,mPrice);
        PriorityQueue<Sell> sells = sellStockList[mStock];
        PriorityQueue<Buy> buys = buyStockList[mStock];

        if(buys.isEmpty()){sells.add(newSell);}
        else{
            while( !buys.isEmpty() && buys.peek().mPrice >= mPrice ){
                Buy b = buys.peek();
                int minQ = Math.min(newSell.mQuantity, b.mQuantity);
                newSell.mQuantity -= minQ;
                b.mQuantity -= minQ;
                LinkedList<Integer> costs =costList[mStock];
                costs.add(b.mPrice);
                for(int i=0; i<costs.size()-1; i++){
                    bestPro[mStock] = Math.max(bestPro[mStock],b.mPrice - costs.get(i));
                }
                if(b.mQuantity==0){buys.poll();}
                if(newSell.mQuantity==0){break;}
            }
            if(newSell.mQuantity!=0){sells.add(newSell);}
        }
        return newSell.mQuantity;
    }

    public void cancel(int mNumber)
    {
        for(PriorityQueue<Buy> bl : buyStockList){
            for(Buy b : bl){ if(b.mNumber == mNumber){bl.remove(b); return;} }
        }

        for(PriorityQueue<Sell> sl : sellStockList){
            for(Sell s : sl){if(s.mNumber == mNumber){sl.remove(s); return;}}
        }
    }

    public int bestProfit(int mStock)
    {
        return bestPro[mStock];
    }
}
class Buy implements Comparable<Buy>{
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

    @Override
    public int compareTo(Buy o) {
        if(this.mPrice!=o.mPrice){return o.mPrice-this.mPrice;}
        return this.mNumber-o.mNumber;
    }
}
class Sell implements Comparable<Sell>{
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

    @Override
    public int compareTo(Sell o) {
        if(this.mPrice!=o.mPrice){return this.mPrice-o.mPrice;}
        return this.mNumber-o.mNumber;
    }
}
