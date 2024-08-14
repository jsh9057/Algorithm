package study;

import java.util.*;

public class Problem {
    public static String[] solution(String[][] plans) {
        Stack<Plan> stack = new Stack<>();
        ArrayList<Plan> arrayList = new ArrayList<>();
        for (String[] p :plans){ arrayList.add(new Plan(p[0],timeToMinute(p[1]),Integer.parseInt(p[2]))); }
        arrayList.sort((o1, o2) -> o1.start-o2.start);
        int ret = 0;
        String[] answer = new String[arrayList.size()];

        int idx = 0;
        int time = arrayList.get(0).start;
        while (true){
            // 시간이 남는경우 -> 스택에서 꺼내기
            if(idx+1 == arrayList.size()){
                answer[ret++] = arrayList.get(idx).name;
                while (!stack.isEmpty()){ answer[ret++]=stack.pop().name; }
                break;
            }
            Plan now = arrayList.get(idx);
            Plan next = arrayList.get(idx+1);
            if(time+now.playTime < next.start){
                time+=now.playTime;
                answer[ret++]=now.name;
                now.playTime = 0;
                while ( !stack.isEmpty() && time + stack.peek().playTime < next.start ){
                    Plan temp = stack.pop();
                    time+=temp.playTime;
                    answer[ret++]=temp.name;
                }
                if( !stack.isEmpty() && time + stack.peek().playTime >= next.start ){// 남은 자투리 시간에 조금 더 하기
                    Plan temp = stack.pop();
                    temp.playTime = temp.playTime - (next.start-time);
                    time = next.start;
                    if(temp.playTime==0){ answer[ret++]=temp.name; }
                    if(temp.playTime!=0){ stack.push(temp); }
                }
                if(time<next.start){ time = next.start; }
            }
            else if(time+now.playTime == next.start){
                time = next.start;
                now.playTime = 0;
                answer[ret++]=now.name;
            }
            else{// 시간이 안남는 경우 -> 현재꺼할만큼하고 스택에 넣기
                now.playTime = now.playTime - (next.start - time);
                time += (next.start - time);
                stack.push(now);
            }
            idx++;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    static class Plan{
        String name;
        Integer start;
        Integer playTime;

        public Plan(String name, Integer start, Integer playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }
    static int timeToMinute(String time){
        String[] split = time.split(":");
        int ret = Integer.parseInt(split[0])*60;
        ret += Integer.parseInt(split[1]);
        return ret;
    }

    public static void main(String[] args) {
        solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}});
        solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}});
        solution(new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}});
        solution(new String[][]{{"korean", "11:40", "20"}, {"english", "12:10", "30"}, {"math", "12:30", "40"}});
    }
}
