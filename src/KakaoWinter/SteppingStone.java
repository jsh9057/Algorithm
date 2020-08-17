package KakaoWinter;

public class SteppingStone {
    public static void main(String args[]) {
        int[] stones={2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k=3;
        SteppingStone steppingStone = new SteppingStone();
        System.out.println(steppingStone.binarySearch(stones,k));
    }

    public int binarySearch(int[] stones, int k){
        int left=1;
        int right=200000000;
        int mid=0;
        int answer =0;

        while(left <= right){
            mid=(left+right)/2;
            System.out.println(mid);
            int cnt=0;
            boolean isPossible=true;
            for(int i=0; i<stones.length; i++){
                int now = stones[i];
                now-=mid;
                if(now>=0){cnt=0;}
                else if(now<0){ cnt++;}
                if(cnt>=k){isPossible=false; break;}
            }
            if(isPossible==false){
                right=mid-1;
            }
            else{
                left=mid+1;
                answer = answer>mid ? answer:mid;
            }
        }

        return answer;
    }
}
