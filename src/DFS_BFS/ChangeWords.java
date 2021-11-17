package DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ChangeWords {
    static int WORDS_LEN;

    public static void main(String args[]){
        String begin="hit";
        String target="cog";
        String[] words= {"hot", "dot", "dog", "lot", "log", "cog"};
        int answer = 0;

        WORDS_LEN = words.length;
        LinkedList<Node> nodes = new LinkedList<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        boolean[] visit = new boolean[WORDS_LEN];


        for(int i=0; i<WORDS_LEN; i++){
            Node node =new Node(words[i],i);
            for(int j=0; j<WORDS_LEN; j++){
                if(i!=j&& isChange(words[i],words[j])){node.list.add(new Node(words[j],j));}
            }
            nodes.add(node);
        }

        for(int i=0; i<WORDS_LEN; i++){
            if(isChange(begin,words[i])){ nodeQueue.add(nodes.get(i)); visit[i]=true;}
        }


//        for(int i=0; i<WORDS_LEN; i++){
//            Node node = nodes.get(i);
//            System.out.println("node: "+node.word);
//            for(int j=0; j<node.list.size(); j++){
//                System.out.print(node.list.get(j).word+" ");
//            }
//            System.out.println();
//        }




        while (!nodeQueue.isEmpty()){
            Node node = nodeQueue.poll();
            System.out.println("node: "+node.word);
            if(node.word.equals(target)){ System.out.println("answer: "+answer);return;}
            for(int i=0; i<node.list.size(); i++){
                int num = node.list.get(i).num;
                if(!visit[num]){
                    System.out.println("push: "+node.list.get(i).word);
                    nodeQueue.add(nodes.get(num));
                    visit[num]=true;
                }
            }
            System.out.println();
            System.out.println("answer++");
            answer++;
        }

    }
    static class Node {
        String word;
        int num;
        LinkedList<Node> list = new LinkedList<>();

        public Node(String word, int num) {
            this.word = word;
            this.num = num;
        }
    }

    public static Boolean isChange(String a, String b){
        String[] splitA = a.split("");
        String[] splitB = b.split("");
        int diffNum=0;
        for(int i=0; i<splitA.length; i++){
            if(!splitA[i].equals(splitB[i])){
                diffNum++;
                if(diffNum>1){return false;}
            }
        }
        return true;
    }
}
