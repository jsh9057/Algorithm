package 해커랭크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class q1 {
    static int[] contry;
    static int[] cnt;
    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        // Write your code here
        contry = new int[n];
        cnt = new int[n];
        for (int i = 0; i < n; i++) { contry[i] = i; }
        for (int i = 0; i < astronaut.size(); i++) {
            int a = astronaut.get(i).get(0);
            int b = astronaut.get(i).get(1);
            union(a,b);
        }

        for (int i = 0; i < n; i++) {
            cnt[find(i)]++;
        }

        int groupCnt=0;
        for (int i = 0; i < n; i++) {
            groupCnt+=((n-cnt[i])*cnt[i]);
        }
        return groupCnt/2;
    }
//    5 3
//0 1
//2 3
//0 4

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        List<List<Integer>> input = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            input.add(new ArrayList<>());
            input.get(i).add(a);
            input.get(i).add(b);
        }
        System.out.println(journeyToMoon(n,input));
    }

    static int find(int a){
        if(contry[a]==a){ return a;}
        contry[a]=find(contry[a]);
        return contry[a];
    }
    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootB>rootA){
            int tmp = rootA;
            rootA=rootB;
            rootB=tmp;
        }
        contry[rootA]=rootB;
    }
}
