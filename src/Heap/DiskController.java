package Heap;

import java.util.PriorityQueue;

public class DiskController {
    static class Job implements Comparable<Job>{
        int start;
        int duration;

        public Job(int start, int duration){
            this.start= start;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return "시작시간: "+start+" 소요시간: "+duration;
        }

        @Override
        public int compareTo(Job target) {
            if( this.start < target.start )
                return -1;
            if(this.start == target.start)
                return this.duration <= target.duration ? -1: 1;
            return 1;
        }
    }

    public static void main(String args[]){
//        int [][] jobs = {{0,3},{1,9},{2,6}};
//        int [][] jobs = {{0,3},{4,3},{10,3}};
//        int [][] jobs = {{0,10},{2,3},{9,3}};
//        int [][] jobs = {{1,10},{3,3},{10,3}};
//        int [][] jobs = {{0,10}};
//        int [][] jobs = {{0,10},{4,10},{5,11},{15,2}};
//        int [][] jobs = {{24,10},{18,39},{34,20},{37,5},{47,22},{20,47},{15,2},{15,34},{35,43},{26,1}};
        int [][] jobs = {{24,10},{18,39},{34,20},{37,5},{47,22},{20,47},{15,34},{15,2},{35,43},{26,1}};

        int answer ;
        PriorityQueue <Job>jobQueue= new PriorityQueue<>();

        for(int i=0; i<jobs.length; i++){
            jobQueue.offer(new Job(jobs[i][0], jobs[i][1]));
        }

        int jobSize = jobQueue.size();
        PriorityQueue <Job>jobDurationQueue = new PriorityQueue<>(jobQueue.size(),
                (Job j1, Job j2)-> j1.duration >= j2.duration ? 1: -1);

        int endTime = jobQueue.peek().start;
        int time=0;
        boolean flag = false;
        System.out.println("시작 : "+jobQueue.peek().start +" 듀레 : "+jobQueue.peek().duration);

        while (!jobQueue.isEmpty()){
//            Job nowJ = jobQueue.poll();
//            System.out.println("뽑아냄 - "+nowJ.toString());
//            time = time + endTime - nowJ.start + nowJ.duration;
//            endTime = endTime + nowJ.duration;
//            System.out.println( "endTime: "+endTime );
            while (!jobQueue.isEmpty() && jobQueue.peek().start<= endTime){
                Job j = jobQueue.poll();
                System.out.println("잡듀레이션 - "+j.toString());
                jobDurationQueue.offer(j);
                flag=true;
            }
            if(flag== false){
                Job j = jobQueue.poll();
                jobDurationQueue.offer(j);
                time = time + j.start - endTime;
            }
            if(!jobDurationQueue.isEmpty()){
                Job j = jobDurationQueue.poll();
                System.out.println("뽑아냄 - "+j.toString());
                time = time + endTime - j.start+ j.duration;
                endTime = endTime + j.duration;
                System.out.println("time : "+time);
                System.out.println( "endTime: "+endTime );
            }
            while (!jobDurationQueue.isEmpty()){
                Job j = jobDurationQueue.poll();
                System.out.println("원상복구 - "+j.toString());
                jobQueue.offer(j);
            }
            flag= false;
        }
        answer = (int) time/jobSize;
        System.out.println(time);
        System.out.println(answer);
    }
}
