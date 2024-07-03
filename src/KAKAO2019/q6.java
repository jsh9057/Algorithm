package KAKAO2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class q6 {
    static HashMap<String,Site> siteMap;
    public static int solution(String word, String[] pages) {
        Pattern addressPattern  =  Pattern.compile("<meta[^>]*content=\"https://[\"']?([^>\"']+)[\"']?[^>]*>");
        Pattern linkPattern  =  Pattern.compile("<a[^>]*href=\"https://[\"']?([^>\"']+)[\"']?[^>]*>");
        Pattern wordPattern = Pattern.compile("\\b(?i)"+word+"\\b");

        siteMap = new HashMap<>();

        for (int i = 0; i < pages.length; i++) {
            Matcher addressMatcher = addressPattern.matcher(pages[i]);
            addressMatcher.find();
            String address=addressMatcher.group(1);

            Matcher wordMatcher = wordPattern.matcher(pages[i].toLowerCase().replaceAll("[^a-z]"," "));
            int score = 0;
            while (wordMatcher.find()){ score++; }
            siteMap.put(address,new Site(score,i));
        }

        for (int i = 0; i < pages.length; i++) {
            Matcher addressMatcher = addressPattern.matcher(pages[i]);
            addressMatcher.find();
            String address=addressMatcher.group(1);

            Matcher linkMatcher = linkPattern.matcher(pages[i]);

            while (linkMatcher.find()){
                String link = linkMatcher.group(1);
                siteMap.get(address).addOutLink(link);
                if(siteMap.containsKey(link)){ siteMap.get(link).addInLink(address); }
            }
        }

        double max = -1;
        int maxIdx = -1;
        for (String key :siteMap.keySet()){
            Site now = siteMap.get(key);
            double total = now.basicScore;
            for (String next :now.inLink){
                total+=siteMap.get(next).getTotalScore();
            }

            if(total>max){
                max = total;
                maxIdx = now.n;
            }
        }
        System.out.println(maxIdx);
        return maxIdx;
    }

    static class Site{
        int basicScore;
        int n;
        List<String> outLink;
        List<String> inLink;

        public Site(int basicScore, int n) {
            this.basicScore = basicScore;
            outLink = new ArrayList<>();
            inLink = new ArrayList<>();
            this.n = n;
        }

        public void addOutLink(String link){ outLink.add(link); }
        public void addInLink(String link){ inLink.add(link); }

        public double getTotalScore(){
            return (double) basicScore/outLink.size();
        }

    }

    public static void main(String[] args) {
        solution("blind",new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"});
        solution("Muzi",new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"});
    }
}
