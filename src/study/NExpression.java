package study;

import java.util.ArrayList;

public class NExpression {
    public static int solution(int N, int number) {
        ArrayList<Integer>[] arr = new ArrayList[9];
        for (int i = 0; i < 9; i++) { arr[i] = new ArrayList<>(); }

        arr[1].add(N);
        int tmp = 1;
        for (int i = 2; i <= 8; i++) {
            tmp = tmp*10+1;
            arr[i].add(N*tmp);
            for (int j = 1; j <= i-1; j++) {
                for (int k = 0; k <arr[j].size(); k++) {
                    for (int l = 0; l <arr[i-j].size(); l++) {
                        int a = arr[j].get(k);
                        int b = arr[i-j].get(l);
                        arr[i].add(a+b);
                        arr[i].add(a-b);
                        arr[i].add(a*b);
                        if(b==0){ continue; }
                        arr[i].add(a/b);
                    }
                }
            }
        }
        int answer = -1;
        for (int i = 1; i <=8; i++) {
            if(arr[i].contains(number)){ answer=i; break; }
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution(5,12);
        solution(2,11);
    }
}
