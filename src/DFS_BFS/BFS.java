package DFS_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static LinkedList<Integer>[] linkedList;
    static Boolean[] visit;
    public static void main(String args[]){
        linkedList = new LinkedList[8];
        visit = new Boolean[8];
        Arrays.fill(visit,false);
        for(int i=0; i< linkedList.length; i++){
            linkedList[i]= new LinkedList<>();
        }

        linkedList[1].add(2);
        linkedList[2].add(1);

        linkedList[1].add(3);
        linkedList[3].add(1);

        linkedList[2].add(3);
        linkedList[3].add(2);

        linkedList[2].add(4);
        linkedList[4].add(2);

        linkedList[2].add(5);
        linkedList[5].add(2);

        linkedList[3].add(6);
        linkedList[6].add(3);

        linkedList[3].add(7);
        linkedList[7].add(3);

        linkedList[4].add(5);
        linkedList[5].add(4);

        linkedList[6].add(7);
        linkedList[7].add(6);
        dfs(1);
    }
    static public void dfs(int x){
        if(visit[x]) return;
        visit[x]= true;
        System.out.print(x+" ");
        for(int i=0; i<linkedList[x].size(); i++){
            int num = linkedList[x].get(i);
            dfs(num);
        }
    }
    static public void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;

        while(!q.isEmpty()){
            int num = q.poll();
            System.out.print(num+" ");

            for(LinkedList<Integer> list : linkedList){
                for(int i=0;i<list.size(); i++){
                    int n = list.get(i);
                    if(!visit[n]){
                        visit[n]=true;
                        q.add(n);
                    }
                }
            }
        }

    }
}
