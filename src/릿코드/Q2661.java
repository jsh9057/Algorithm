package 릿코드;

import java.util.HashMap;

public class Q2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int[] yCnt = new int[mat.length];
        int[] xCnt = new int[mat[0].length];

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                map.put(mat[i][j], new int[]{i,j});
            }
        }

        for(int i=0; i<arr.length; i++){
            int[] now = map.get(arr[i]);
            int y = now[0];
            int x = now[1];
            yCnt[y]++;
            xCnt[x]++;
            if(yCnt[y]==mat[0].length || xCnt[x]==mat.length){ return i;}
        }
        return 0;
    }
}
