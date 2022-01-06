package KaKao2020Intern;

import java.util.*;

public class Caving {
    public static void main(String args[]){
        int[][] p1 = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] o1 = {{8,5},{6,7},{4,1}};
        System.out.println(solution(9,p1,o1));

        int[][] p2 = {{8,1},{0,1},{1,2},{0,7},{4,7},{0,3},{7,5},{3,6}};
        int[][] o2 = {{4,1},{5,2}};
        System.out.println(solution(9,p2,o2));

        int[][] p3 = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] o3 = {{4,1},{8,7},{6,5}};
        System.out.println(solution(9,p3,o3));
    }
    static int VISIT = 1;
    static int NOT_VISIT = 0;
    static int CLOSE = -1;
    public static boolean solution(int n, int[][] path, int[][] order){
        int[] visit =new int[n];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer>[] conCave = new ArrayList[n];
        HashMap<Integer,Integer> i_o = new HashMap<>();
        HashMap<Integer,Integer> o_i = new HashMap<>();

        for(int i=0; i<n; i++){
            conCave[i]= new ArrayList<>();
        }

        for(int[] p: path){
            conCave[p[0]].add(p[1]);
            conCave[p[1]].add(p[0]);
        }
        for(int[] o: order){
            i_o.put(o[0],o[1]);
            o_i.put(o[1],o[0]);
        }

        if(o_i.keySet().contains(0)){return false;}
        q.add(0);
        visit[0]=1;

        while (!q.isEmpty()){
            int pq = q.poll();
            for(int i=0; i<conCave[pq].size(); i++){    //연결된 동굴 탐색
                int next = conCave[pq].get(i);
                if(visit[next]==NOT_VISIT){                     // 탐색하지않았고
                    if(o_i.keySet().contains(next)){
                        if(visit[o_i.get(next)]== VISIT){   // 선행 동굴을 탐색했으면
                            q.add(next);                    // 큐에 넣어 줌.
                            visit[next]=VISIT;
                        }
                        else{ visit[next]=CLOSE;}            // 아직 선행동굴에 안갔으므로.
                    }
                    else{
                        if(i_o.keySet().contains(next) && visit[i_o.get(next)]==CLOSE){ // 어딘가의 선행 동굴이라면
                            q.add(i_o.get(next));                                       // 선행 조건을 충족했기 떄문에 바로 넣어줌.
                            visit[i_o.get(next)]=VISIT;                                 // 제한사항에서 임의의 두 동굴끼리 이동 불가능한 경우는 없다고 제시.
                        }
                        q.add(next);
                        visit[next]=VISIT;
                    }
                }

            }
        }

        for(int v : visit){
            if(v!=VISIT) return false;
        }

        return true;
    }
}
