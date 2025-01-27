package 릿코드;
import java.util.*;

public class Q1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isPre = new boolean[numCourses][numCourses];
        for(int[] pre: prerequisites){
            isPre[pre[0]][pre[1]]=true;
        }

        for(int mid=0; mid<numCourses; mid++){
            for(int start=0; start<numCourses; start++){
                for(int end=0; end<numCourses; end++){
                    if(isPre[start][mid]&&isPre[mid][end]){
                        isPre[start][end]=true;
                    }
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] q: queries){
            res.add(isPre[q[0]][q[1]]);
        }

        return res;
    }
}
