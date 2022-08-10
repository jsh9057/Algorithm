package Toss;

import java.util.*;

public class n6 {
    public static void main(String[] args) {
        int[] steps_one = {0,5,1};
        String[] names_one = {"ev","ed","ev"};
        int[] steps_two = {9999};
        String[] names_two = {"ro"};
        int[] steps_three = {1};
        String[] names_three = {"ri"};

        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        HashMap<String,Integer> map3 = new HashMap<>();
        for(int i=0;i<steps_one.length;i++){
            map1.put(names_one[i], map1.getOrDefault(names_one[i],0)<steps_one[i]? steps_one[i]:map1.getOrDefault(names_one[i],0));
        }
        for(int i=0;i<steps_two.length;i++){
            map2.put(names_two[i], map2.getOrDefault(names_two[i],0)<steps_two[i]? steps_two[i]:map2.getOrDefault(names_two[i],0));
        }
        for(int i=0;i<steps_three.length;i++){
            map3.put(names_three[i], map3.getOrDefault(names_three[i],0)<steps_three[i]? steps_three[i]:map3.getOrDefault(names_three[i],0));
        }

        HashSet<String> set = new HashSet<>();
        for(String s: names_one){set.add(s);}
        for(String s: names_two){set.add(s);}
        for(String s: names_three){set.add(s);}
        Iterator<String> it = set.iterator();
        PriorityQueue<Person> q = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.n == o2.n) return o1.name.compareTo(o2.name);
                return o2.n - o1.n;
            }
        });
        while (it.hasNext()){
            String key = it.next();
            int tmp = 0;
            tmp+= map1.getOrDefault(key,0);
            tmp+= map2.getOrDefault(key,0);
            tmp+= map3.getOrDefault(key,0);
            q.add(new Person(tmp,key));
        }
        String[] answer = new String[q.size()];
        for(int i=0; i<answer.length;i++){
            answer[i]=q.poll().name;
        }
        System.out.println(Arrays.toString(answer));

    }
    static class Person{
        int n;
        String name;

        public Person(int n, String name) {
            this.n = n;
            this.name = name;
        }
    }
}
