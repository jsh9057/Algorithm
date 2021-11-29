package Greedy;

/*

            JJAAAJ 앞의 갯수+1보다 연속된 A의 길이 크다면 앞으로갓다가 뒤로  pre > A.length +1
                    앞의 갯수+1 연속된 A의 길이랑 같으면 어디로가나 같음   pre == A.length+1 anyway
            JJJAJ  앞의 갯수-1보다 연속된 A의 길이가 작거으면 앞으로가야 함.  pre < A.length-1

            BBAAABBB
            01234567
 */



public class Joystick {
    public static void main(String args[]) {
        String name = "BBAAAB";

        int answer = 0;

        int len = name.length();

        //최대로 가질 수 있는 min값은 끝까지 가는것
        int min_move = len - 1;

        for (int i = 0; i < len; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            //좌우: 연속된 A의 등장에 따라 최소 움직임이 달라진다
            int next = i + 1;// 현재 다음 위치부터
            //내 다음이 A라면 계속 NEXT++
            while (next < len && name.charAt(next) == 'A')
                next++;
            //                      5     1 + 6 - 5 + 1
            min_move = Math.min(min_move, i + len - next + i);
        }//for

        answer += min_move;

        System.out.println(answer);
    }

}
