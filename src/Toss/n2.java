package Toss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class n2 {
    public static void main(String[] args) {
//        int[] levels={1,2,3,4,5,6,7,8,9};
        int[] levels={1,2,3,4};
        if(levels.length<=3){ System.out.println(-1);return; }
        Arrays.sort(levels);
        double cut = (levels.length/4.0)*3.0;
        int tmp = (levels.length/4)*3;
        if(tmp<cut){ System.out.println(levels[tmp+1]);}
        else {System.out.println(levels[tmp]);}
    }
}
