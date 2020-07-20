package DFS_BFS;

public class TargetNum {
    public static void main(String args[]){
        int[] numbers={1,1,1,1,1};
        int target = 3;
        int answer=0;
        int[][] bfs = new int[numbers.length+1][1048577];

        for(int i=0; i<numbers.length; i++){
            int j=0;
            int pow = (int) Math.pow(2,i);
            while(j<pow) {
                bfs[i+1][j] = bfs[i][j] + numbers[i];
                if(i==numbers.length-1){ if(bfs[i+1][j]==target){answer++;}}
                j++;
            }
            int k =0;
            while(k<pow){
                bfs[i+1][k+j]=bfs[i][(k+j)%j]-numbers[i];
                if(i==numbers.length-1){ if( bfs[i+1][k+j]==target){answer++;}}
                k++;
            }
        }
        System.out.println(answer);
    }
}
