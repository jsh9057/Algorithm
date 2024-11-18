package 소프트티어;
import java.util.*;
import java.io.*;

public class q6250 {
    static int[] rank;
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Score[] arr = new Score[100000];
        StringBuilder sb = new StringBuilder();
        rank = new int[100000];
        PriorityQueue<Score> pq1 = new PriorityQueue<>((s1,s2)-> s2.s[0]-s1.s[0]);
        PriorityQueue<Score> pq2 = new PriorityQueue<>((s1,s2)-> s2.s[1]-s1.s[1]);
        PriorityQueue<Score> pq3 = new PriorityQueue<>((s1,s2)-> s2.s[2]-s1.s[2]);
        PriorityQueue<Score> pq4 = new PriorityQueue<>((s1,s2)-> s2.s[3]-s1.s[3]);

        N = Integer.parseInt(br.readLine());
        for(int i=0;i<3;i++){
            String[] split = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                if(i==0){ arr[j] = new Score(j); }
                arr[j].set(i,Integer.parseInt(split[j]));
            }
        }
        for(int i=0; i<N; i++){
            pq1.add(arr[i]);
            pq2.add(arr[i]);
            pq3.add(arr[i]);
            pq4.add(arr[i]);
        }
        sb.append(getRank(pq1,0)).append("\n");
        sb.append(getRank(pq2,1)).append("\n");
        sb.append(getRank(pq3,2)).append("\n");
        sb.append(getRank(pq4,3));
        System.out.println(sb);
    }


    static String getRank(PriorityQueue<Score> pq, int n){
        int cnt=1;
        int ranking=1;
        int pre=0;
        rankInit();
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Score now = pq.poll();
            // System.out.println(now.idx+":"+now.s[n]);
            if(now.s[n]<pre){ // 이전 사람의 점수가 더 높다면, 내 앞의사람수가 내 등수
                ranking = cnt;
                rank[now.idx] = ranking;
            }
            else{
                rank[now.idx] = ranking;
            }
            cnt++;
            pre = now.s[n];
        }
        for(int i=0;i<N;i++){
            sb.append(rank[i]).append(" ");
        }
        return sb.toString();
    }

    static void rankInit(){ Arrays.fill(rank,0); }

    static class Score {
        int idx;
        int[] s;

        public Score(int idx){
            this.idx = idx;
            this.s = new int[4];
        }
        public void set(int i, int n){
            s[i]=n;
            if(i==2){ s[3]=s[0]+s[1]+s[2]; }
        }
    }
}
