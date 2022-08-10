package Toss;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class LR {
    public static void main(String[] args) {
        int server =2;
        boolean sticky = false;
        int[] request = new int[]{1,2,3,4};
        int[][] result = solution(server,sticky,request);
        for(int[] arr: result){
            System.out.println(Arrays.toString(arr));
        }
    }
    static public int[][] solution(int servers, boolean sticky, int[] requests) {

        if(!sticky){
            ArrayList<Integer>[] list = new ArrayList[servers];
            for(int i=0; i<requests.length; i++){
                if(list[i%servers]==null){ list[i%servers]= new ArrayList<>();}
                list[i%servers].add(requests[i]);
            }
            int[][] answer = new int[servers][requests.length];
            for(int i=0;i<servers;i++){
                for(int j=0;j<list[i].size();j++){
                    answer[i][j]=list[i].get(j);
                }
            }
            return answer;
        }

        else{
            LinkedHashSet<Integer>[] setList= new LinkedHashSet[servers];
            for(int i=0;i<requests.length;i++){
                if(setList[i%servers]==null){ setList[i%servers] = new LinkedHashSet<>(); }
            }


        }


       return null;
    }
}
