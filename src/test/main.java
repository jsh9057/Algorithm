package test;

import java.text.DecimalFormat;

public class main {
    public static void  main(String args[]){
        double s= 176128;
        System.out.println(byteCalculation(s));
    }

    public static String byteCalculation(double bytes) {
        String retFormat = "0";
        Double size = bytes;

        String[] s = { "bytes", "KB", "MB", "GB", "TB", "PB" };


        if (bytes != 0) {
            int idx = (int) Math.floor(Math.log(size) / Math.log(1024));
            DecimalFormat df = new DecimalFormat("#,###.##");
            double ret = ((size / Math.pow(1024, Math.floor(idx))));
            retFormat = df.format(ret) + " " + s[idx];
        } else {
            retFormat += "" + s[0];
        }

        return retFormat;
    }
}
