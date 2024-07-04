package KAKAO2019.INTERN;

public class q2 {
    public static int solution(int[] stones, int k) {
        int answer = 0;
        int max = 200000000;
        int min = 0;
        while (min<=max){
            int mid = (min+max)/2;
            int cnt=0;
            boolean isJump = true;
            for (int s :stones){
                if(s-mid<0){
                    cnt++;
                    if(cnt>=k){ isJump = false; break; }
                }
                else{ cnt = 0; }
            }
            if(isJump){ min = mid+1; answer = mid;}
            else { max = mid-1; }
        }
        return answer;
    }
    public static void main(String[] args) {
        solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
    }
}
