package com.integrum.application.utills;

import java.text.ParseException;
import com.integrum.application.base.BasePage;

/**
 * Created by rajender.koyyeda on 06-10-2023.
 */
public class test extends BasePage {

  public static void main(String[] args) throws ParseException {


    System.out.println(422.52002 / 422.52);
    int val = (int) (422.52002 / 422.52);
    System.out.println(val);
       /* String date_s = "12/22/2023";
        String date_s1 = date_s.replaceAll("/", "-");
        String a[] = date_s1.split("-");
        String f = a[2] + "-" + a[0] + "-" + a[1];
        System.out.println(f);*/

        /*final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        final Date date = format.parse("01/14/2023");
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 2);
        System.out.println( format.format(calendar.getTime()));*/


        /*Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        String t1 = formatter.format(calendar.getTime());
        Calendar calendar1 = new GregorianCalendar(TimeZone.getTimeZone("IST"));
        formatter.setTimeZone(TimeZone.getTimeZone("IST"));
        String t2 = formatter.format(calendar1.getTime());
        System.out.println(" UTC time with format " + t1);
        System.out.println(" IST time with format " + t2);
        System.out.println("Retrieving IST date is : " + t2);*/
  }
}
