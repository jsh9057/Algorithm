package Stack_Queeue;

public class SkillTree {
    public static void main(String args[]){
        String skill="CBD";
        String[] skill_trees={"BACDE", "CBADF", "AECB", "BDA"};
        int answer=0;
        for(int i=0; i<skill_trees.length; i++){
            answer+=check(skill,skill_trees[i]);
        }
        System.out.println(answer);
    }
    public static int check(String skillList, String skillTree){
        boolean check = false;
        boolean notLean = false;
        int start = -1;

        for(int sl=0; sl<skillList.length(); sl++){
            for(int st=0; st<skillTree.length(); st++){
                if(skillList.charAt(sl)==skillTree.charAt(st)){
                    if(!notLean && start < st) {
                        start = st;
                        check = true;
                        break;
                    }
                    else { return 0;}
                }
                else {check =false;}
            }
            if(!check) {notLean = true;}
        }
        return 1;
    }
}
