package BOJ;
/*

문제
2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.


입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

예제 입력 1
2
예제 출력 1
2
예제 입력 2
9
예제 출력 2
55

 */

import java.util.Scanner;

public class boj11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pib[] = new int[1001];
        pib[1]=1;
        pib[2]=2;
        for(int i=3; i<=n; i++){
            pib[i]=(pib[i-1]+pib[i-2])%10007;
        }
        System.out.println(pib[n]);
    }
}
