package KAKAO2020BLIND;

import java.util.*;

public class q5 {
    static final int STICK = 0;
    static final int CREATE = 1;
    static int N;
    static int[][] stick;
    static int[][] panel;

    public static int[][] solution(int n, int[][] build_frame) {
        stick = new int[n+1][n+1];
        panel = new int[n+1][n+1];
        N = n;

        for (int[] b :build_frame){
            int r = b[1];
            int c = b[0];
            if(b[2]==STICK){
                if(b[3]==CREATE){ if(isCreateStick(r,c)){ stick[r][c]=1; } }
                else{ if(isDeleteStick(r,c)){ stick[r][c]=0; } }
            }
            else{
                if(b[3]==CREATE){ if(isCreatePanel(r,c)){ panel[r][c]=1;} }
                else{ if(isDeletePanel(r,c)){ panel[r][c]=0; } }
            }
        }

        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i <=N; i++) {
            for(int j = 0 ; j<=N; j++){
                if(stick[j][i]==1){ answer.add(new int[]{i,j,0}); }
                if(panel[j][i]==1){ answer.add(new int[]{i,j,1}); }
            }
        }
        int[][] ret = new int[answer.size()][3];
        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < 3; j++) {
                ret[i][j]=answer.get(i)[j];
            }
        }
        return ret;
    }
    static boolean isRange(int r, int c){ return 0<=r && r<=N && 0<=c && c<=N; }
    static boolean isCreateStick(int r, int c){

        return ((r==0)
                || (isRange(r-1,c) && stick[r-1][c]==1)
                || (isRange(r,c-1) && panel[r][c-1]==1)
                || (panel[r][c]==1));
    }
    static boolean isCreatePanel(int r, int c){
        return ((isRange(r-1,c) && stick[r-1][c]==1)
                || (isRange(r-1,c+1) && stick[r-1][c+1]==1)
                || ((isRange(r,c-1) && panel[r][c-1]==1) && (isRange(r,c+1) && panel[r][c+1]==1)));
    }
    static boolean isDeleteStick(int r, int c){
        stick[r][c]=0;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if(panel[i][j]==1){ if(!isCreatePanel(i,j)){ stick[r][c]=1; return false;} }
                if(stick[i][j]==1){ if(!isCreateStick(i,j)){ stick[r][c]=1; return false;} }
            }
        }
        return true;
    }
    static boolean isDeletePanel(int r, int c){
        panel[r][c]=0;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if(panel[i][j]==1){ if(!isCreatePanel(i,j)){ panel[r][c]=1; return false;} }
                if(stick[i][j]==1){ if(!isCreateStick(i,j)){ panel[r][c]=1; return false;} }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        solution(5,new int[][]{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}});
//        solution(5,new int[][]{{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}});
    }
}