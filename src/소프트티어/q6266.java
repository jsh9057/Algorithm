package 소프트티어;
import java.io.*;
import java.util.*;

public class q6266 {
    static final int START = 9;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        HashMap<String,Integer[]> map = new HashMap<>();
        for(int i=0;i<N;i++){
            Integer[] tmp = new Integer[19];
            Arrays.fill(tmp,0);
            map.put(br.readLine(), tmp);
        }

        for(int i=0; i<M ;i++){
            split = br.readLine().split(" ");
            Integer[] tmp = map.get(split[0]);
            int s = Integer.parseInt(split[1]);
            int e = Integer.parseInt(split[2]);
            for(int j=s; j<e; j++){ tmp[j]=1; }
            map.put(split[0],tmp);

        }

        ArrayList<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList,(k1,k2)-> k1.compareTo(k2));

        for(int i=0; i<N; i++){
            String name = keyList.get(i);
            System.out.print(getTimeTable(name,map.get(name)));
            if(i!=N-1){ System.out.println("-----"); }
        }

    }
    static final String ROOM ="Room ";
    static String getTimeTable(String name, Integer[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append(ROOM).append(name).append(":\n");
        StringBuilder sb2 = new StringBuilder();

        int start = 0;
        int end = 0;
        boolean isIng = false;
        arr[18]=1;
        int cnt = 0;
        for(int i=9; i<19; i++){
            if(!isIng && arr[i]==0){
                start = i;
                isIng=true;
            }
            if(isIng && arr[i]==1 && arr[i-1]==0){
                end = i;
                isIng=false;
                sb2.append(String.format("%02d-%02d\n",start,end));
                cnt++;
            }
        }
        if(cnt>=1){
            sb.append(cnt).append(" available:\n");
            sb.append(sb2.toString());
        }else{
            sb.append("Not available\n");
        }

        return sb.toString();
    }
}
