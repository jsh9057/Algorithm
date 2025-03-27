package 릿코드;
import java.util.*;

public class Q3394 {
    public boolean check(int n, int[][] rectangles, int dir){
        Arrays.sort(rectangles,(a,b)->a[dir]-b[dir]);
        int end = rectangles[0][dir+2];
        int cnt = 0;
        for(int i=1;i<rectangles.length;i++){
            if(end <= rectangles[i][dir]){
                cnt++;
                if(cnt>=2){return true;}
            }
            end = Math.max(end, rectangles[i][dir+2]);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        map.getOrDefault(list.get(1),1);
        return false;
    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return check(n,rectangles,0) || check(n,rectangles,1);
    }
}
