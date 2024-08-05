package study;

/*
    1. dp
 */
public class Operation {
    public static int solution(String arr[]) {
        int[] num = new int[arr.length/2+1];
        String[] op = new String[arr.length/2];
        int n=0 ,o=0;
        for (String a: arr){
            if(a.equals("+")||a.equals("-")){ op[o++]=a; }
            else { num[n++]=Integer.parseInt(a); }
        }

        int[][] maxDp = new int[num.length][num.length];
        int[][] minDp = new int[num.length][num.length];
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                maxDp[i][j]=Integer.MIN_VALUE/2;
                minDp[i][j]=Integer.MAX_VALUE/2;
            }
        }

        for (int step = 0; step < num.length; step++) {
            for (int start = 0; start < num.length-step; start++) {
                int end = start+step;
                if(step==0){
                    maxDp[start][start]=num[start];
                    minDp[start][start]=num[start];
                }
                else{
                    for (int mid = start; mid < end; mid++) {
                        if(op[mid].equals("+")){
                            maxDp[start][end] = Math.max(maxDp[start][end],maxDp[start][mid]+maxDp[mid+1][end]);
                            minDp[start][end] = Math.min(minDp[start][end],minDp[start][mid]+minDp[mid+1][end]);
                        }
                        else{
                            maxDp[start][end] = Math.max(maxDp[start][end],maxDp[start][mid]-minDp[mid+1][end]);
                            minDp[start][end] = Math.min(minDp[start][end],minDp[start][mid]-maxDp[mid+1][end]);
                        }
                    }
                }
            }
        }
        System.out.println(maxDp[0][num.length-1]);
        return maxDp[0][num.length-1];
    }
    public static void main(String[] args) {
        solution(new String[]{"1", "-", "3", "+", "5", "-", "8"});
        solution(new String[]{"5", "-", "3", "+", "1", "+", "2", "-", "4"});
    }
}
