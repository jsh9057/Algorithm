package KAKAO2023BLINDRE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q5 {
    public static String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        int[][][] merge = new int[51][51][2];
        String[][] content = new String[51][51];

        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                merge[i][j][0]=i;
                merge[i][j][1]=j;
                content[i][j] = "EMPTY";
            }
        }

        for(String command :commands){
            String[] split = command.split(" ");
            String kind = split[0];
            switch (kind){
                case "UPDATE":
                    if(split.length==4){    // UPDATE r c value
                        int r = Integer.parseInt(split[1]);
                        int c = Integer.parseInt(split[2]);
                        String value = split[3];

                        int mR = merge[r][c][0];
                        int mC = merge[r][c][1];
                        content[mR][mC] = value;
                    }
                    else{   // UPDATE value1 value2
                        String value1 = split[1];
                        String value2 = split[2];
                        for (int i = 1; i < 51; i++) {
                            for (int j = 1; j < 51; j++) {
                                if(content[i][j].equals(value1)){ content[i][j]=value2; }
                            }
                        }
                    }
                    break;

                case "MERGE":   // MERGE r1 c1 r2 c2
                    int r1 = Integer.parseInt(split[1]);
                    int c1 = Integer.parseInt(split[2]);
                    int r2 = Integer.parseInt(split[3]);
                    int c2 = Integer.parseInt(split[4]);

                    int mR1 = merge[r1][c1][0];
                    int mC1 = merge[r1][c1][1];
                    int mR2 = merge[r2][c2][0];
                    int mC2 = merge[r2][c2][1];

                    for (int i = 1; i < 51; i++) {
                        for (int j = 1; j < 51; j++) {
                            if(merge[i][j][0]==mR2 && merge[i][j][1]==mC2){
                                merge[i][j][0] = mR1;
                                merge[i][j][1] = mC1;
                                if(content[mR1][mC1].equals("EMPTY")){ content[mR1][mC1] = content[mR2][mC2]; }
                            }
                        }
                    }
                    break;

                case "UNMERGE": // UNMERGE r c
                    int r = Integer.parseInt(split[1]);
                    int c = Integer.parseInt(split[2]);

                    int mR = merge[r][c][0];
                    int mC = merge[r][c][1];

                    String tmp = content[mR][mC];

                    for (int i = 1; i < 51; i++) {
                        for (int j = 1; j < 51; j++) {
                            if(merge[i][j][0]==mR && merge[i][j][1]==mC){
                                merge[i][j][0]=i;
                                merge[i][j][1]=j;
                                content[i][j]="EMPTY";
                            }
                        }
                    }
                    content[r][c]=tmp;
                    break;

                case "PRINT":   //PRINT r c
                    int row = Integer.parseInt(split[1]);
                    int col = Integer.parseInt(split[2]);
                    answer.add(content[merge[row][col][0]][merge[row][col][1]]);
                    break;
            }
        }
        String[] list = answer.toArray(String[]::new);
        System.out.println(Arrays.toString(list));
        return list;
    }
    public static void main(String[] args) {
        solution(new String[]{"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"});
        // ["EMPTY", "group"]
        solution(new String[]{"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"});
        // ["d", "EMPTY"]
    }
}
