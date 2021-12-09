package BinarySearch;

/*

    이진탐색으로 풀어보았습니다.
    탐색에 앞서, 좁은 탐색 범위를 지정하는것이 반복문을 최소로 돌리기때문에
    탐색의 최소 범위를 지정해 줍니다.

    심사관이 각각 걸리는 시간을 오름차순으로 정렬한 뒤,

    탐색의 left 를 지정하는 방법은
    times[0]*n/times.length 입니다.

    탐색의 right 를 지정하는 방법은
    times[times.length-1]*n/times.length 입니다.

    여기서 mid = (left + right)/2 입니다.
    한 가지 주의 할 점은 mid 라는 시간동안 n명이 심사를 받는다고 하더라도
    문제가 원하는 답을 충족하지않을 수 있습니다.
    왜냐하면, n명이 심사하는 최소시간을 보장하지 않기 때문입니다.
    문제를 그대로 가져올경우
    28분 뿐만 아니라 29분도 6명이 심사를 받기때문입니다.

    if(sum<n){left=mid+1;}  mid 를 기준으로 오른쪽을 탐색해야 합니다.
                            여기서 left 를 mid+1 로 설정한 이유는, 이미 mid 의 값은 답을 절대로 충족하지 않기 때문입니다.

    else{ right=mid; answer=mid;}      right 를 mid 로 설정한 이유는 right 는 답을 충족할 수도 있기 때문입니다.
                                       그러므로 right 값을 계속 mid 로 고정하고(답을 충족하는 mid 값의 최소를 알기 위해) 결국 left 의 값이 증가하여
                                       반복문을 나올때까지 합니다.
                                       27, 28, 29, 30, 31      left=27, mid=29, right=31, sum=6    : answer = 29
                                                               left=27, mid=28, right=29, sum=6    : answer = 28
                                                               left=27, mid=27, right=28, sum=5
                                                               left = 28 == right  반복문 탈출.

                                                               만약 -1 을 할경우
                                                               left=27, mid=29, right=31, sum=6    : answer =29
                                                               left=27, mid=27, right=28, sum=5
                                                               left = 28 == right 반복문 탈출.
    시간복잡도: O(logN)

 */
import java.util.Arrays;

public class Immigration {
    public static void main(String args[]){
        int n=6;
        int[] times = {7,10};
        long answer=0;

        Arrays.sort(times);
        long left = (long)times[0]*(long)n/times.length;                  // 가장 적은 시간은 7*6/2 = 21
        long right =(long)times[times.length-1]*(long)n/times.length;     // 가장 오래걸리는 시간은 10*6/2 = 30
        long mid=0;
        answer = right;
        while(left<right){
            mid = (left + right)/2;
            long sum =0;
            for(int i=0; i<times.length; i++){
                sum += mid/times[i];                                // 몇명이 심사를 받는지 확인하기 위한 sum
            }
            if(sum<n){left=mid+1;}                                  // 답일 가능성이 전혀 없으므로 +1
            else{right=mid; answer=mid;}                            // 답이 포함되어있을 수도 있으므로 right 를 mid 로 계속 고정
        }
        System.out.println(answer);
    }
}
