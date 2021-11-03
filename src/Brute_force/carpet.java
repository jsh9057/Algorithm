package Brute_force;


public class carpet{
    public static void main(String args[]){
        int brown=24;
        int yellow=24;
        int[] answer =new int[2];

        int g=yellow;
        int s=1;


        while(g>=s){
            if(yellow%s==0){
                g=yellow/s;
                if(computeBrown(g,s)==brown) {
                    answer[0]=g+2;
                    answer[1]=s+2;
                    System.out.println("가로: "+(g+2)+" 세로: "+(s+2));
                    break ; // return
                }
            }
            s++;
        }


    }

    public static int computeBrown(int g, int s){
        int brown = 2*(g+s+2);
        return brown;
    }
}
