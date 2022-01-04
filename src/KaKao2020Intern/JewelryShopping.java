package KaKao2020Intern;
/**
 *
 *  절반이 효율성이 떨어져 풀이를 참고하였습니다.
 *  기존 방식 :
 *      map 은 가장 최신 보석의 인덱스를 가지고있습니다.
 *      보석의 종류와 map 사이즈가 같고, map 보석인덱스의 최소값이 변했다면
 *
 */

import java.util.*;

public class JewelryShopping {
    public static void main(String args[]) {
//        String[] s1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//        System.out.println(Arrays.toString(solution(s1)));
//        String[] s2 = {"AA", "AB", "AC", "AA", "AC"};
//        System.out.println(Arrays.toString(solution(s2)));
//        String[] s3 = {"XYZ", "XYZ", "XYZ"};
//        System.out.println(Arrays.toString(solution(s3)));
//        String[] s4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
//        System.out.println(Arrays.toString(solution(s4)));
        String[] s5 = {"1", "2", "2", "2", "3", "1", "1", "3", "2"};
        System.out.println(Arrays.toString(solution(s5)));
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();                          // <보석,갯수>
        Queue<String> q = new LinkedList<>();
        int start = 0;
        int leng = Integer.MAX_VALUE;

        for (String gem : gems) {
            map.put(gem, map.getOrDefault(gem, 0) + 1);
            q.add(gem);
            while (true) {
                if (map.get(q.peek()) > 1) {
                    String tmp = q.poll();
                    map.put(tmp, map.get(tmp) - 1);
                    start++;
                } else {
                    break;
                }
            }
            if (map.size() == set.size() && leng > q.size()) {
                leng = q.size();
                answer[0] = start + 1;
                answer[1] = start + leng;
            }
        }
        return answer;
    }
}
