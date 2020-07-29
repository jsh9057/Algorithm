package DFS_BFS;
import java.util.*;

public class TravelRoute {

    static ArrayList<String> route= new ArrayList<>();

    public static void main(String args[]) {
//        String[][] tickets = {{"ICN", "A"}, {"ICN", "B"},{"B","ICN"}};
//        String[][] tickets ={{"ICN", "COO"}, {"COO", "ICN"},{"ICN", "COO"}};
        String[][] tickets = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
//        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
//        String[][] tickets = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};
//        String[][] tickets = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "DOO"}, {"BOO", "ICN"}};
    for(int i=0; i<tickets.length; i++){
        boolean chk[] = new boolean[tickets.length];
        if(tickets[i][0].equals("ICN")){
            chk[i]=true;
            dfs(tickets,"ICN",tickets[i][1],chk,1);
        }
    }
    route.sort(null);
    System.out.println(route.get(0));
    }

    static void dfs(String[][] tickets,String s, String last, boolean[] chk, int cnt){
        s+=","+last;
        if(cnt == tickets.length){
            route.add(s);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(last)&&!chk[i]){
                chk[i]=true;
                dfs(tickets,s,tickets[i][1],chk,cnt+1);
                chk[i]=false;
            }
        }
    }
}