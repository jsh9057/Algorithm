package DevMatching2021;

import java.util.Arrays;
import java.util.HashMap;

public class q3 {
    static HashMap<String, String> parents;
    static HashMap<String, Integer> nameMap;
    static int[] totalAmount;

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        parents = new HashMap<>();
        nameMap = new HashMap<>();
        totalAmount = new int[enroll.length];

        for (int i = 0; i < referral.length; i++) {
            parents.put(enroll[i],referral[i]);
            nameMap.put(enroll[i],i);
        }

        for (int i = 0; i < seller.length; i++) { dfs(seller[i],amount[i]*100); }

        System.out.println(Arrays.toString(totalAmount));
        return totalAmount;
    }

    public static void dfs(String seller, int amount){
        if(amount==0){return;}

        int toParent = amount/10;
        totalAmount[nameMap.get(seller)] += (amount - toParent);
        if(!parents.get(seller).equals("-")){ dfs(parents.get(seller),toParent); }
    }

    public static void main(String[] args) {
        solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}, new String[]{"young", "john", "tod", "emily", "mary"}, new int[]{12, 4, 2, 5, 10});
        solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}, new String[]{"sam", "emily", "jaimie", "edward"}, new int[]{2, 3, 5, 4});
    }
}
