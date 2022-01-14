package CodePlus.Basic1.BruteForce;
/**
 *  처음에 dfs 로 각 자릿수에서 +1 -1 하는 식으로 접근 하였지만
 *  자릿수가 달라지는 경우,
 *  target = 1000
 *  999+ 하는게 정답입니다.
 *  이런 예외부분이 많았고, 입력값의 범주가 작다는걸 깨닫고 완전탐색으로 풀이하였습니다.
 *
 *  풀이
 *      0. 기본 최소값은 100 에서 부터 + - 를 하여 걸리는 횟수로 초기화 한다.
 *      1. 1 ~ 만들수있는 최대 숫자 까지 반복문을 돈다.
 *      2. 반복문을 돌며, 버튼이 고장나지 않아 만들수있는 숫자라면 최솟값을 비교한다.
 *  팁:
 *      만들수있는 최대값은 target=500000 이므로, 999999 입니다.
 *          - 9만 고장이 안났을 경우를 생각해보면 999999 에서 접근하는게 100에서 접근하는거 보다 빠르기 때문에.
 *
 *  처음 작동시간 : 1028ms (만들수 있는 최대값을      가장큰멀쩡한버튼.repeat(target.length+1)  로 잡음 )
 *  마지막 제출 작동시간 : 260ms (검사해야하는 최소값을 생각해서 만들수 있는 최대값을 줄임. 느려질거같은 부분 리팩토링)
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1107_Remote {
    static boolean[] isErrorBtn;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strTarget = br.readLine();
        int target = Integer.parseInt(strTarget);
        int M = Integer.parseInt(br.readLine());
        isErrorBtn = new boolean[10];

        if (M != 0) {
            String[] errorBtn = br.readLine().split(" ");
            for (int i = 0; i < M; i++) { isErrorBtn[Integer.parseInt(errorBtn[i])] = true; }   // 고장난 버튼 체크
        }
        min = Math.abs(target-100);                                                             // 100에서 접근하는 횟수
        for (int i = 0; i < 1000000; i++) {
            String s = String.valueOf(i);
            if (isTrance(s)) {                                                                  // 만들수있는 숫자라면
                int length = s.length();
                min = Math.min(Math.abs(target - i) + length, min);                             // 만드는데 들인 횟수와 최소값 비교
            }
        }
        System.out.println(min);
    }

    public static boolean isTrance(String s){
        int m=s.length();
        for(int i=0; i<m; i++){
            int tmp = s.charAt(i)-'0';                                                          // char to int 간단하게 바꾸는 방법
            if(isErrorBtn[tmp]){return false;}
        }
        return true;
    }
}
