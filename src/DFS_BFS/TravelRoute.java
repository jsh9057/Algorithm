package DFS_BFS;
import java.util.*;

public class TravelRoute {
    static HashMap<String,ArrayList<Boolean>> visitMap = new HashMap<>();
    static HashMap<String,ArrayList<String>> hashMap = new HashMap<>();
    static ArrayList<String> rout= new ArrayList<>();

    public static void main(String args[]) {
//        String[][] tickets = {{"ICN", "A"}, {"ICN", "B"},{"B","ICN"}};
//        String[][] tickets ={{"ICN", "COO"}, {"COO", "ICN"},{"ICN", "COO"}};
        String [][] tickets={ {"ICN","BOO" }, { "ICN", "COO" }, { "COO", "DOO" }, {"DOO", "COO"},{ "BOO", "DOO"},{"DOO", "BOO"}, {"BOO", "ICN" }, {"COO", "BOO"}};
//        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
//        String[][] tickets = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};
//        String[][] tickets = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "DOO"}, {"BOO", "ICN"}};
        int ticketCount =tickets.length;

        for (int i = 0; i < ticketCount; i++) {
            if(hashMap.get(tickets[i][0])==null){
                ArrayList<String> a =new ArrayList<>();
                a.add(tickets[i][1]);
                hashMap.put(tickets[i][0],a);
                ArrayList<Boolean> v = new ArrayList<>();
                v.add(false);
                visitMap.put(tickets[i][0],v);
            }else{
                hashMap.get(tickets[i][0]).add(tickets[i][1]);
                hashMap.get(tickets[i][0]).sort(String::compareTo);
                visitMap.get(tickets[i][0]).add(false);
            }
        }
        rout.add("ICN");
        for(int i=0; i<hashMap.get("ICN").size(); i++){
            dfs("ICN",i,ticketCount);
            //visit 초기화
            Iterator itv2 = visitMap.keySet().iterator();
            System.out.println(Arrays.deepToString(reAnswer(rout))) ;
            if(rout.size()==ticketCount+1){
                System.out.println(Arrays.deepToString(reAnswer(rout)));
                break;
            }
            rout.clear();
            rout.add("ICN");
            while(itv2.hasNext()) {
                ArrayList<Boolean> s = visitMap.get(itv2.next());
                for(int j=0; j<s.size(); j++)
                    visitMap.get(s.set(j,false));
            }
        }
        System.out.println(Arrays.deepToString(reAnswer(rout)));
    }
    public static void dfs (String start, int n, int ticketCount){
        if(ticketCount == 0){return ;}
        if(hashMap.get(start)==null){return;}
        ArrayList<String> list = hashMap.get(start);
        ArrayList<Boolean> visitList = visitMap.get(start);

        int listSize = list.size();
        if(n==listSize){return;}

        if(visitList.get(n)==true) {
            System.out.println("will start: "+start +" end: "+(n+1));
            dfs(start,n+1,ticketCount);
            return;}

        rout.add(list.get(n));
        visitMap.put(start,visitList);
        visitList.set(n,true);
        dfs(list.get(n),0,ticketCount-1);
    }
    static String[] reAnswer(ArrayList<String> arrayList){
        String[] arr = new String[arrayList.size()];
        for(int i=0; i<arrayList.size(); i++)
            arr[i]=arrayList.get(i);
        return arr;
    }
}
