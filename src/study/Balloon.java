package study;

public class Balloon {
    public static int solution(int[] a) {
        int answer = 0;
        int mid = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[mid]>a[i]){ mid = i; }
        }
        answer++;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mid; i++) {
            if(min > a[i]){
                min = a[i];
                answer++;
            }
        }

        min = Integer.MAX_VALUE;
        for (int i = a.length-1; i > mid ; i--) {
            if(min > a[i]){
                min = a[i];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{9,-1,-5});
        solution(new int[]{-16,27,65,-2,58,-92,-71,-68,-61,-33});
    }
}
