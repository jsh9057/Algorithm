package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Ramen {
    public static class Flour implements Comparable<Flour> {
        int date;
        int supplies;

        public Flour(int date, int supplies) {
            this.date = date;
            this.supplies = supplies;
        }

        @Override
        public int compareTo(Flour target) {
            return this.supplies <= target.supplies ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        int stock = 4;
        int[] dates = {4,10,15};
        int[] supplies = {20,5,10};
        int k = 30;
        int answer = 0;

        ArrayList<Flour> floursList = new ArrayList<>();
        for (int i = 0; i < dates.length; i++) {
            floursList.add(new Flour(dates[i], supplies[i]));
        }
        floursList.add(new Flour(k,0));
        PriorityQueue<Flour> flours = new PriorityQueue<>();

        for (int i = 0; i < floursList.size(); i++) {
            while (stock-floursList.get(i).date<0 && !flours.isEmpty()) {
                Flour nowFlour = flours.poll();
                stock = stock + nowFlour.supplies;
                answer++;
            }
            flours.offer(floursList.get(i));
        }

        System.out.println(answer);
    }
}