package 릿코드;
import java.util.*;

public class Q1079 {
    static HashSet<String> set;
    public int numTilePossibilities(String tiles) {
        set = new HashSet<>();
        bt(tiles,"",new boolean[tiles.length()]);
        return set.size()-1;
    }

    public void bt(String tiles, String now, boolean[] visit){
        set.add(now);
        for(int i=0;i<tiles.length(); i++){
            if(!visit[i]){
                visit[i]=true;
                bt(tiles, now+tiles.charAt(i), visit);
                visit[i]=false;
            }
        }
    }
}
