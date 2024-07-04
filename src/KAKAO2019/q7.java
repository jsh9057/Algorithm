package KAKAO2019;

import java.util.ArrayList;
import java.util.HashMap;

public class q7 {
    static HashMap<Integer,Block> blockMap;
    public static int solution(int[][] board) {
        blockMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]==0){ continue; }
                if(blockMap.containsKey(board[i][j])){
                    blockMap.get(board[i][j]).addBlock(i,j);
                }
                else{
                    Block b = new Block(board[i][j]);
                    b.addBlock(i,j);
                    blockMap.put(board[i][j],b);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]==0){ continue; }
                Block now = blockMap.get(board[i][j]);

                if(now.isDelete){
                    boolean delete = true;
                    int[] yx1 = now.emptySpace.get(0);
                    int[] yx2 = now.emptySpace.get(1);
                    System.out.printf("now:%d / empty:(%d,%d),(%d,%d)\n",now.n,yx1[0],yx1[1],yx2[0],yx2[1]);

                    for(int k= Math.max(yx1[0],yx2[0]); k>=0; k--){
                        if(board[k][yx1[1]]!=0){ delete = false; break;}
                        if(board[k][yx2[1]]!=0){ delete = false; break;}
                    }

                    if(delete){
                        for (int[] a : now.yx){ board[a[0]][a[1]]=0; }
                        blockMap.remove(board[i][j]);
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
        return answer;
    }

    static class Block{
        int n;
        ArrayList<int[]> yx;
        boolean isDelete;
        int minX,minY;
        int maxX,maxY;
        ArrayList<int[]> emptySpace;

        public Block(int n) {
            this.n = n;
            yx = new ArrayList<>();
        }

        public void addBlock(int y, int x){
            yx.add(new int[]{y,x});
            
            if(yx.size()==4){
                yx.sort((o1, o2) -> {
                    if(o1[0]-o2[0]==0){return o1[1]-o2[1];}
                    return o1[0]-o2[0];});
                
                int[] last = yx.get(3);
                isDelete = false;
                
                minX = Integer.MAX_VALUE;
                minY = Integer.MAX_VALUE;
                maxX = Integer.MIN_VALUE;
                maxY = Integer.MIN_VALUE;


                for (int[] a :yx){
                    minX = Math.min(a[1],minX);
                    minY = Math.min(a[0],minY);
                    maxX = Math.max(a[1],maxX);
                    maxY = Math.max(a[0],maxY);
                    if(last[0]==a[0]&&(last[1]==a[1]+1 || last[1]==a[1]-1)){ isDelete = true; }
                }

                if( isDelete ) {
                    emptySpace = new ArrayList<>();
                    int[][] tmp = new int[maxY - minY + 1][maxX - minX + 1];
                    for (int[] a : yx) {
                        tmp[a[0] - minY][a[1] - minX] = 1;
                    }
                    for (int i = 0; i < tmp.length; i++) {
                        for (int j = 0; j < tmp[0].length; j++) {
                            if (tmp[i][j] == 0) {
                                emptySpace.add(new int[]{i+minY, j+minX});
                            }
                        }
                    }

                }
            }
        }
    }
/*
{0, 0, 1, 1, 1},
{0, 0, 0, 1, 0},
{3, 0, 0, 2, 0},
{3, 2, 2, 2, 0},
{3, 3, 0, 0, 0}

 */
    public static void main(String[] args) {
        solution(new int[][]{{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}});
        solution(new int[][]{{0,0,0,0,0,0,0,0,0,0},{0,0,0,2,2,0,0,0,0,0},{0,0,0,2,1,0,0,0,0,0},{0,0,0,2,1,0,0,0,0,0},{0,0,0,0,1,1,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}});
        solution(new int[][]{{0, 0, 1, 1, 1}, {0, 0, 0, 1, 0}, {3, 0, 0, 2, 0}, {3, 2, 2, 2, 0}, {3, 3, 0, 0, 0}});
    }
    public static void changeBracket(String[] bracket) {
        String ret = "solution(";
        String type = "new int[][]";
//        String type = "new String[][]";
        boolean isOne = true;
        for (String b : bracket) {
            ret += type;
            String tmp = b.replaceAll("\\[", "{");
            ret += tmp.replaceAll("\\]", "}");
            if (bracket.length > 1) {
                ret += ", ";
                isOne = false;
            }
        }
        if(isOne) System.out.println(ret+");");
        else System.out.println(ret.substring(0,ret.length()-2)+ ");");
    }
}
