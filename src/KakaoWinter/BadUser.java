package KakaoWinter;

import java.util.*;

public class BadUser {
    private static HashSet<HashSet<String>> result = new HashSet<>();

    public static void main(String args[]){
        BadUser badUser =new BadUser();
        String[] user_id ={"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id={"fr*d*", "*rodo", "******", "******"};
        result = new HashSet<>();
        badUser.dfs(user_id,banned_id,new LinkedHashSet<>());
        System.out.println(result.size());
    }

    public void dfs(String[] user_id, String[] banned_id, Set<String> set){
        if (set.size() == banned_id.length) {
            if (isBannedUsers(set, banned_id)) {
                result.add(new HashSet<>(set));
            }
            return;
        }

        for (String userId : user_id) {
            if (!set.contains(userId)) {
                set.add(userId);
                dfs(user_id, banned_id, set);
                set.remove(userId);
            }
        }
    }

    private boolean isBannedUsers(Set<String> set, String[] banned_id) {
        int i = 0;

        for (String user : set) {
            if (!isSameString(user, banned_id[i++])) {
                return false;
            }
        }

        return true;
    }

    private boolean isSameString(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            if (b.charAt(i) == '*') continue;

            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }

        return true;
    }


}