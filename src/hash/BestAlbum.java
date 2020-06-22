package hash;


import java.util.*;

public class BestAlbum {

    public static void main(String arg[]){
        String[] genres ={"a", "a", "a"};
        int [] plays ={1, 1, 1};
        Queue<Integer> queue = new LinkedList<>();
        int [] answer = {};

        ArrayList<String> sortArr = new ArrayList<>();
        for(String g : genres){
            if(!sortArr.contains(g))
                sortArr.add(g);
        }
        HashMap<String, int[][]> info = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        for(int i=0; i<sortArr.size();i++)
            count.put(sortArr.get(i), 0);

        for(int i=0; i<plays.length; i++){
            String g = genres[i];
            int cnt = count.get(g);
            if(!info.containsKey(g)){
                int[][] tmp = new int[plays.length+1][2] ;
                tmp[cnt][0]=i;
                tmp[cnt][1]=plays[i];
                info.put(g,tmp);
            }else{
                int[][] data = info.get(g);
                data[cnt][0]=i;
                data[cnt][1]=plays[i];
                info.put(g,data);
            }
            count.put(g,++cnt);
        }
        //장르별 조회수
        int[] gSum = new int [sortArr.size()];
        for(int i=0; i<sortArr.size(); i++){
            String g=sortArr.get(i);
            int[][] data = info.get(g);
            for(int j=0; data[j][1]>0; j++){
                gSum[i]=gSum[i]+data[j][1];
            }
        }

        for(int k=0; k<gSum.length ; k++) {
            int max = gSum[k];
            int maxIdx = k;
            String g;
            for (int i = 0; i < gSum.length; i++) {
                if (max < gSum[i]) {
                    max = gSum[i];
                    maxIdx = i;
                }
            }
            gSum[maxIdx]=0;
            g = sortArr.get(maxIdx);
            int[][] tmp = info.get(g);
            for (int n = 0; n < 2; n++) {
            int maxPlays = 0;
            int maxNum = 0;
            int b=0;
            int c=count.get(g);
                for (int i = 0; i <c; i++) {
                    if (maxPlays < tmp[i][1]) {
                        maxPlays = tmp[i][1];
                        maxNum = tmp[i][0];
                        b=i;
                    }
                }
                tmp[b][1]=0;
                queue.add(maxNum);
                if(count.get(g)==1){
                    n++;
                }
            }
        }
        int i=0;
        answer= new int [queue.size()];
        while (!queue.isEmpty()){
            answer[i]=queue.poll();
            i++;
        }
        for(int k=0; k<answer.length; k++)
            System.out.println("["+k+"] : "+answer[k]);
    }
}
