package 소프트티어;
import java.util.*;
import java.io.*;

public class q6257 {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws Exception{
        arr = new int[N+1];
        ArrayList<Integer>[] uList = new ArrayList[N+1];
        ArrayList<Integer>[] dList = new ArrayList[N+1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] split = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(split[i]);
        }


        for(int i=0; i<N;i++){
            uList[i]=new ArrayList<>();
            dList[i]=new ArrayList<>();
            for(int j=i+1;j<N;j++){
                if(arr[i]<arr[j]){ uList[i].add(j); }
                else{ dList[i].add(j); }
            }
        }
        long cnt = 0;
        for(int i=0;i<N;i++){

            for(int j=0;j<uList[i].size();j++){
                int c = uList[i].get(j);

                if(dList[i].size()==0){ continue; }
                long tmp = up(dList[i],c);
                if(tmp==dList[i].size()){continue;}

                if(tmp>-1){
                    // System.out.print("i:"+arr[i]+", ");
                    // System.out.print("j:"+arr[c]+", ");
                    // System.out.println("k:"+arr[dList[i].get(tmp)]);
                    // System.out.println("dSize:"+ dList[i].size());
                    cnt = cnt+(dList[i].size()-tmp);
                    // System.out.println(arr[i]+","+arr[uList[i].get(j)]+", tmp:"+tmp);
                }
            }
        }
        System.out.println(cnt);
    }
    // 특정 값을 초과하는 첫위치
    public static int upperBound(int[] arr, int value){
        int max = arr.length;
        int min = 0;
        while(min<max){
            int mid = (min+max)/2;
            if(value<arr[mid]){
                max = mid;
            }else{
                min = mid+1;
            }
        }
        return min;
    }
    // 특정 값 이상인 첫 위치
    public static int lowerBound(int[] arr, int value){
        int max = arr.length;
        int min = 0;
        while(min<max){
            int mid = (min+max)/2;
            if(value > arr[mid]){
                min = mid+1;
            }else{
                max = mid;
            }
        }
        return min;
    }
    static int up(ArrayList<Integer> list, int target){
        int start = 0;
        int end = list.size();
        int mid = 0;
        while(start<end){
            mid = (start+end)/2;
            if(list.get(mid) <= target){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return end;
    }
}
