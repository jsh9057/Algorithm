package SWExpert.TimeTravel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    private final static int CMD_INIT				= 1;
    private final static int CMD_BUY				= 2;
    private final static int CMD_SELL				= 3;
    private final static int CMD_CANCEL				= 4;
    private final static int CMD_BEST_PROFIT		= 5;

    private final static UserSolution usersolution = new UserSolution();

    private static boolean run(BufferedReader br) throws Exception
    {
        StringTokenizer st;

        int numQuery;

        int mNumber, mStock, mQuantity, mPrice;

        int userAns, ans;

        boolean isCorrect = false;

        numQuery = Integer.parseInt(br.readLine());

        for (int q = 0; q < numQuery; ++q)
        {
            st = new StringTokenizer(br.readLine(), " ");

            int cmd;
            cmd = Integer.parseInt(st.nextToken());

            switch(cmd)
            {
                case CMD_INIT:
                    usersolution.init();
                    isCorrect = true;
                    break;
                case CMD_BUY:
                    mNumber = Integer.parseInt(st.nextToken());
                    mStock = Integer.parseInt(st.nextToken());
                    mQuantity = Integer.parseInt(st.nextToken());
                    mPrice = Integer.parseInt(st.nextToken());
                    userAns = usersolution.buy(mNumber, mStock, mQuantity, mPrice);
                    ans = Integer.parseInt(st.nextToken());
                    if (userAns != ans) {
                        isCorrect = false;
                    }
                    break;
                case CMD_SELL:
                    mNumber = Integer.parseInt(st.nextToken());
                    mStock = Integer.parseInt(st.nextToken());
                    mQuantity = Integer.parseInt(st.nextToken());
                    mPrice = Integer.parseInt(st.nextToken());
                    userAns = usersolution.sell(mNumber, mStock, mQuantity, mPrice);
                    ans = Integer.parseInt(st.nextToken());
                    if (userAns != ans) {
                        isCorrect = false;
                    }
                    break;
                case CMD_CANCEL:
                    mNumber = Integer.parseInt(st.nextToken());
                    usersolution.cancel(mNumber);
                    break;
                case CMD_BEST_PROFIT:
                    mStock = Integer.parseInt(st.nextToken());
                    userAns = usersolution.bestProfit(mStock);
                    ans = Integer.parseInt(st.nextToken());
                    if (userAns != ans) {
                        isCorrect = false;
                    }
                    break;
                default:
                    isCorrect = false;
                    break;
            }
        }

        return isCorrect;
    }

    public static void main(String[] args) throws Exception
    {
//        int TC, MARK;
//
//        System.setIn(new java.io.FileInputStream("C:\\Users\\jsh90\\IdeaProjects\\Algorithm\\src\\SWExpert\\TimeTravel\\res\\sample_input.txt"));
//
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        TC = Integer.parseInt(st.nextToken());
//        MARK = Integer.parseInt(st.nextToken());
//
//        for (int testcase = 1; testcase <= TC; ++testcase)
//        {
//            int score = run(br) ? MARK : 0;
//            System.out.println("#" + testcase + " " + score);
//        }
//
//        br.close();


        UserSolution s= new UserSolution();
        s.init();
        System.out.println(s.buy(1, 1, 5, 105));
        System.out.println(s.buy(2, 1, 5, 100));
        System.out.println(s.sell(3, 1, 12, 100));
        System.out.println(s.bestProfit(1));
        System.out.println(s.sell(4, 1, 8, 90));
        System.out.println(s.sell(5, 1, 1, 110));
        System.out.println(s.buy(6, 1, 11, 110));
        System.out.println(s.bestProfit(1));
        System.out.println(s.buy(7, 1, 1, 80));
        System.out.println(s.buy(8, 1, 1, 85));
        System.out.println(s.sell(9, 1, 3, 70));
        s.cancel(9);
        System.out.println(s.buy(10, 1, 1, 70));
        System.out.println(s.bestProfit(1));
        System.out.println(s.sell(11, 5, 500000, 1000000));
        System.out.println(s.sell(12, 5, 499999, 999999));
        System.out.println(s.buy(13, 5, 1000000, 1000000));
        System.out.println(s.bestProfit(5));


    }
}