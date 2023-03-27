package com.cws.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zsw
 * @create 2023-03-27 18:43
 */
public class test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(PushUtil.auntTime());
//        boolean b = TxtUtil.writeTxt("src/main/day.txt", "2023-3-27");
//        System.out.println(b);
        int Day = TxtUtil.writeTxtFileOnJar("static/errorday.txt",1);
//        System.out.println(Day.substring(1, Day.length() - 1));
        System.out.println(Day);
//        String errorDay  = TxtUtil.readTxtFileByFileSystem("src/main/doc/errorday.txt");
//        System.out.println(errorDay);
//        String[] split = s.split(",");
//        for (int i = 0; i < split.length; i++) {
//            System.out.println(split[i]);
//        }
//        boolean b = TxtUtil.writeTxtByFileSystem("src/main/doc/errorday.txt", 1,false);

//        int errorNum = Integer.parseInt(errorDay);
//        errorNum=errorNum+1;
//        errorDay=errorNum+"";
//        TxtUtil.writeTxtByFileSystem("src/main/doc/errorday.txt",errorNum,false);
//


    }
}
