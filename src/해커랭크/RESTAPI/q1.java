package 해커랭크.RESTAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class q1 {
    static class PageGame{
        int page;
        int per_page;
        int total;
        int total_pages;
        Game[] data;
        static class Game{
            String competition;
            int year;
            String round;
            String team1;
            String team2;
            String team1goals;
            String team3goals;
        }
    }

    /*
    {
  "page": 1,
  "per_page": 10,
  "total": 6,
  "total_pages": 1,
  "data": [
    {
      "competition": "UEFA Champions League",
      "year": 2011,
      "round": "GroupH",
      "team1": "Barcelona",
      "team2": "AC Milan",
      "team1goals": "2",
      "team2goals": "2"
    },
    {
      "competition": "UEFA Champions League",
      "year": 2011,
      "round": "GroupH",
      "team1": "Barcelona",
      "team2": "Viktoria Plzen",
      "team1goals": "2",
      "team2goals": "0"
    },
    {
      "competition": "UEFA Champions League",
      "year": 2011,
      "round": "GroupH",
      "team1": "Barcelona",
      "team2": "BATE Borisov",
      "team1goals": "4",
      "team2goals": "0"
    },
    {
      "competition": "UEFA Champions League",
      "year": 2011,
      "round": "R16",
      "team1": "Barcelona",
      "team2": "Bayer Leverkusen",
      "team1goals": "7",
      "team2goals": "1"
    },
    {
      "competition": "UEFA Champions League",
      "year": 2011,
      "round": "QF",
      "team1": "Barcelona",
      "team2": "AC Milan",
      "team1goals": "3",
      "team2goals": "1"
    },
    {
      "competition": "UEFA Champions League",
      "year": 2011,
      "round": "SF",
      "team1": "Barcelona",
      "team2": "Chelsea",
      "team1goals": "2",
      "team2goals": "2"
    }
  ]
}
     */
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int year=2011;
        String team="Barcelona";
        int page=1;
        sb.append("https://jsonmock.hackerrank.com/api/football_matches?year=").append(year);
        sb.append("&team1=").append(team);
        sb.append("&page=").append(page);

        URL url = new URL(sb.toString());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = br.readLine();
        Gson gson = new Gson();
        PageGame pageGame = gson.fromJson(line, PageGame.class);
        System.out.println(pageGame.data[0].toString());
//        while ((line = br.readLine())!=null){
//            System.out.println(line);
//        }
    }
}
