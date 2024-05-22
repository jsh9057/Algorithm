package KAKAO2023BLINDRE;


import java.util.Arrays;

public class q4 {
    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            String binary = setCompleteBinaryTree(Long.toBinaryString(numbers[i]));
            answer[i]= rec(binary) ? 1:0;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    static boolean rec(String str){
        System.out.println(str);
        if(str.length()<3){
            return true;
        }
        int root = str.length()/2;
//        if(str.charAt(root)=='0' && ((str.charAt(root-1) == '1' || str.charAt(root+1) == '1'))){
//            return false;
//        }
        String left = str.substring(0,root);
        String right = str.substring(root+1);

        if(str.charAt(root)=='0'){
            if(left.contains("1")||right.contains("1")){
                return false;
            }
        }
        if (!rec(left)) { return false; }
        return rec(right);
    }

    static String setCompleteBinaryTree(String str){
        int len = str.length();
        int nodeCount = 0;
        int level = 1;
        while (len > nodeCount){
            nodeCount+=level;
            level*=2;
        }
        return "0".repeat(nodeCount - len)+str;
    }
    public static void main(String[] args) {
        solution(new long[] {96});    // 110
        solution(new long[] {63, 111, 95}); // 110
    }
}