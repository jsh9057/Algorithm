package study;

public class Immigration {
    public static long solution(int n, int[] times) {
        long answer = 0;
        int max = 0;
        for (int t: times){ max = Math.max(max,t); }

        long end = (long) n/times.length*max;
        long start = 1L;
        while (start<end){
            long mid = (end + start)/2;
            int how = 0;
            boolean isOver = false;
            for (int i = 0; i < times.length; i++) {
                how += Math.floor((double) mid / times[i]);
                if(how>=n){ isOver = true; break;}
            }
            if(isOver){ end = mid;}
            else{ start = mid+1; }
            System.out.println(end);
        }
        return end;
    }

    public static void main(String[] args) {
        solution(6, new int[]{7,10});
    }
}
