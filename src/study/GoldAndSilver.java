package study;

public class GoldAndSilver {
    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        long start= 0;
        long end = 200000000000000L;

        while (start<end){
            long mid = (start+end)/2;
            if(isPossible(a,b,g,s,w,t,mid)){ end = mid; answer = mid;}
            else{ start = mid+1;}
        }

        System.out.println(answer);
        return answer;
    }
    static boolean isPossible(int a, int b, int[] g, int[] s, int[] w, int[] t, long time){
        long totalGold = 0;
        long totalSilver = 0;
        long total = 0;

        for (int i = 0; i < g.length; i++) {
            long move = howMove(t[i], time);
            long tmp = Math.min(move*w[i],g[i]+s[i]);
            total += tmp;
            totalGold += Math.min(tmp,g[i]);
            totalSilver += Math.min(tmp,s[i]);
        }
        if(total>=a+b && totalGold>=a && totalSilver>=b){ return true; }
        return false;
    }
    static long howMove(int t, long mid){
        if((mid%(t*2L))>=t){ return mid/(t*2L)+1;}
        else { return mid/(t* 2L); }
    }

    public static void main(String[] args) {
        solution(10,	10,	new int[]{100},	new int[]{100},	new int[]{7},	new int[]{10});
        solution(90, 500	,new int[]{70,70,0}	,new int[]{0,0,500},new int[]{100,100,2},	new int[]{4,8,1});
    }
}
