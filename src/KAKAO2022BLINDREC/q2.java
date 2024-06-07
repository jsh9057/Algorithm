package KAKAO2022BLINDREC;

public class q2 {
    public static int solution(int n, int k) {
        int answer = 0;
        String[] split = Integer.toString(n,k).split("0");

        for (int i = 0; i < split.length; i++) {
            if(split[i].length()==0) continue;
            if(isPrime(Long.parseLong(split[i]))) answer++;
        }

        System.out.println(answer);
        return answer;
    }

    public static boolean isPrime(long n){
        if(n<2){ return false; }
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if(n%i==0){return false;}
        }
        return true;
    }

    public static void main(String[] args) {
        solution(437674,3);     // 3
        solution(110011,10);    // 2
    }
}
