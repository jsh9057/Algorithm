package hash;

import java.util.HashMap;

public class PhoneBook {

    public static void main(String args[]){
        // testcase
        String[] phoneBook = {"119","11", "97674223", "1195524421"};
//        String[] phoneBook = {"123","456","789"};
//        String[] phoneBook = {"12","123","1235","567","88"};
        boolean result=true;
        HashMap<String,Integer> hashMap = new HashMap<>();

        for(int i=0; i<phoneBook.length; i++){
            hashMap.put(phoneBook[i],i);
        }
        for(int i=0; i<phoneBook.length; i++){
            for(int j=0; j<phoneBook[i].length(); j++){
                if(hashMap.containsKey(phoneBook[i].substring(0,j)))
                {
                    //return
                    result = false;}
                }
        }
        //return
    }

}
