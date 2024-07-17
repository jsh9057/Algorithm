package study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Puzzle {
    static final int[] dx={1,-1,0,0};
    static final int[] dy={0,0,1,-1};
    static int[][] board;
    static int[][] table;
    static int boardSize;
    static boolean[][] boardVisit;
    static boolean[][] tableVisit;
    static ArrayList<Figure> tableList;
    static ArrayList<Figure> boardList;
    public static int solution(int[][] game_board, int[][] tables) {
        int answer = 0;
        boardSize = game_board.length;
        board = new int[boardSize+12][boardSize+12];
        table = new int[boardSize][boardSize];
        boardVisit = new boolean[boardSize+12][boardSize+12];
        tableVisit = new boolean[boardSize][boardSize];
        boardList = new ArrayList<>();
        tableList = new ArrayList<>();

        for (int i = 0; i < boardSize+12; i++) {
            for (int j = 0; j < boardSize+12; j++) {
                board[i][j]=1;
            }
        }

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i+6][j+6] = game_board[i][j];
                table[i][j] = tables[i][j];
            }
        }

        for (int i = 6; i < boardSize+6; i++) {
            for (int j = 6; j < boardSize+6; j++) {
                if(board[i][j]==1 || boardVisit[i][j]){continue;}
                boardList.add(findFigure(i,j,0));
            }
        }
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if(table[i][j]==0 || tableVisit[i][j]){ continue; }
                tableList.add(findFigure(i,j,1));
            }
        }

        for (int i = 0; i < boardList.size(); i++) {
            for (int j = 0; j < tableList.size(); j++) {
                if(boardList.get(i)==null){continue;}
                Figure boardFigure = boardList.get(i);
                if(tableList.get(j)==null){ continue; }
                Figure tableFigure = tableList.get(j);
                for (int k = 0; k < 4; k++) {
                    if (boardFigure.isSameFigure(tableFigure)) {
                        System.out.println("i:"+i+"/ j:"+j+" 같음("+boardFigure.size+")");
                        answer += boardFigure.size;
                        tableList.set(j,null);
                        boardList.set(i,null);
                        break;
                    }
                    tableFigure.rotation();
                }
            }
        }

        printBoard();
        System.out.println("--------");
        printTable();
        System.out.println(answer);
        return answer;
    }
    static Figure findFigure(int y, int x, int targetNum){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});

        ArrayList<int[]> location = new ArrayList<>();
        location.add(new int[]{y,x});
        setVisit(y,x,targetNum);

        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[1]+dx[i];
                int ny = now[0]+dy[i];
                if(isRange(ny,nx,targetNum) && !isVisit(ny,nx,targetNum) && isNext(ny,nx,targetNum)){
                    location.add(new int[]{ny,nx});
                    setVisit(ny,nx,targetNum);
                    q.add(new int[]{ny,nx});
                }
            }
        }
        return new Figure(location);
    }

    static boolean isRange(int y, int x, int targetNum){
        if(targetNum==0){ return 0<=x && x<boardSize+12 && 0<=y && y<boardSize+12; }
        return 0<=x && x<boardSize && 0<=y && y<boardSize;
    }
    static void setVisit(int y, int x, int targetNum){
        if(targetNum==0){ boardVisit[y][x]= true; }
        else tableVisit[y][x]=true;
    }

    static boolean isVisit(int y, int x, int targetNum){
        if(targetNum==0){ return boardVisit[y][x]; }
        else return tableVisit[y][x];
    }

    static boolean isNext(int y, int x, int targetNum){
        if(targetNum==0){ return board[y][x]==0; }
        else return table[y][x]==1;
    }

    static class Figure{
        int size;
        ArrayList<int[]> location;

        int[] minYX;

        public Figure(ArrayList<int[]> location) {
            this.location = location;
            size = location.size();
            setMinYX();
        }

        public boolean isSameFigure(Figure f){
            if(this.size!=f.size){ return false; }
            int difY = minYX[0] - f.minYX[0];
            int difX = minYX[1] - f.minYX[1];
            for (int[] l : f.location) {
                if(board[l[0] + difY][l[1] + difX]==1){ return false; }
            }
            return true;
        }

        public void rotation(){
            for (int i = 0; i < location.size(); i++) {
                int[] nowYX = location.get(i);
                location.set(i,new int[]{nowYX[1],boardSize-nowYX[0]});
            }
            setMinYX();
        }

        private void setMinYX(){
            minYX = new int[2];
            minYX[0] = minYX[1] = Integer.MAX_VALUE;

            for (int[] l :location){
                if(minYX[0] > l[0]){ minYX[0]=l[0]; minYX[1]=l[1]; }
                else if(minYX[0]== l[0]){ minYX[1]=Math.min(minYX[1],l[1]); }
            }
        }
    }
    public static void printBoard(){
        for (int i = 6; i < boardSize+6; i++) {
            for (int j = 6; j < boardSize+6; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void printTable(){
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        solution(new int[][]{{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}}, new int[][]{{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}});
//        solution(new int[][]{{0,0,0},{1,1,0},{1,1,1}}, new int[][]{{1,1,1},{1,0,0},{0,0,0}});
        solution(new int[][]{{0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1}, {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0}, {1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0}, {0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0}}, new int[][]{{1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1}, {1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0}, {0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0}, {1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1}, {1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1}, {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1}, {1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1}, {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1}, {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1}});
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