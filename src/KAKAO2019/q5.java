package KAKAO2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q5 {
    static Node[] nodes;
    static boolean[] visit;
    static List<Integer> preList;
    static List<Integer> postList;

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};

        nodes = new Node[nodeinfo.length];
        visit = new boolean[nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i]=new Node(nodeinfo[i][0],nodeinfo[i][1],i+1);
        }
        Arrays.sort(nodes);
        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) { root.addNode(nodes[i]); }

        preList = new ArrayList<>();
        postList = new ArrayList<>();

        preorder(root);
        postorder(root);

        answer = new int[2][nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i]=preList.get(i);
            answer[1][i]=postList.get(i);
        }

        for(int[] a: answer){
            System.out.println(Arrays.toString(a));
        }


        return answer;
    }

    public static void preorder(Node node){
        if(node!=null){
            preList.add(node.n);
            if(node.left!=null){ preorder(node.left); }
            if(node.right!=null){ preorder(node.right);}
        }
    }

    public static void postorder(Node node){
        if(node!=null){
            if(node.left!=null){ postorder(node.left); }
            if(node.right!=null){ postorder(node.right);}
            postList.add(node.n);
        }
    }

    public static class Node implements Comparable<Node>{
        int x,y,n;
        Node right;
        Node left;

        public Node(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }

        @Override
        public int compareTo(Node o) {
            if (o.y == this.y){ return this.x-o.x; }
            return o.y-this.y;
        }

        public void addNode(Node node){
            if(this.x<node.x){  // right
                if(this.right==null){ this.right = node; }
                else{this.right.addNode(node);}
            }
            else{   // left
                if(this.left==null){ this.left = node; }
                else{this.left.addNode(node);}
            }
        }
    }
    public static void main(String[] args) {
        solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});
    }
}