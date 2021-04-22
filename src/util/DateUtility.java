package util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DateUtility {
    
    public static final String DAYS = "DAYS";
    public static final String HOURS = "HRS";
    public static final String MINUTES = "MIN";
    public static final String SECONDS = "SEC";
    public final static int SECOND_MILLIS = 1000;
    public final static int MINUTE_MILLIS = SECOND_MILLIS * 60;
    public final static int HOUR_MILLIS = MINUTE_MILLIS * 60;
    public final static int DAY_MILLIS = HOUR_MILLIS * 24;
    public final static int YEAR_MILLIS = DAY_MILLIS * 365;
    public static Hashtable hashTab;
    public static final String FORMAT_DT_TIME = "dd-MMM-yy kkmmss";
    public static final String FORMAT_DT_TIMESTAMP = "dd-MMM-yy, HH:mm:ss";
    
    //public static final int DATE_EPOCH_DIFF=3600000;
    public static final int DATE_EPOCH_DIFF=0;
    public static final int DATE_EXPIRY_TIME_TEN_MINUTES = MINUTE_MILLIS * 10;
    
    
    public DateUtility() {
        super();
    }
    
    public static void main(String arg[]) throws Exception {
    	String date= "06-Jan-17";
    	String format = "dd-MMM-yy";
    	System.out.print(parseStringToDate(date, format));
    }
   
    public static Timestamp getCurSQLTimeStamp() {
        
        java.util.Date dt=new java.util.Date(System.currentTimeMillis()+DATE_EPOCH_DIFF);
        
//        java.sql.Timestamp today = new Timestamp(System.currentTimeMillis());
        
        return new java.sql.Timestamp(dt.getTime());
    }
public static Date getCurrentDate() {
        
        java.util.Date dt=new java.util.Date(System.currentTimeMillis());
       return dt; 
//        java.sql.Timestamp today = new Timestamp(System.currentTimeMillis());
        
        
    }
  
  
    public static final SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
    public static final SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");

    public static String getStartFinancialYear() {
        Timestamp dt = new Timestamp(System.currentTimeMillis()+DATE_EPOCH_DIFF);
        String strStartFinancialYear = null;
        Integer currentYear = Integer.parseInt(sdfYear.format(dt));
        Integer preYear = currentYear - 1;
        Integer currentMonth = Integer.parseInt(sdfMonth.format(dt));

        if (currentMonth < 4) {
            strStartFinancialYear = preYear.toString();
        }
        if (currentMonth >= 4) {
            strStartFinancialYear = currentYear.toString();
        }

        return strStartFinancialYear;
    }
    
    public static String getEndFinancialYear() {
        Timestamp dt = new Timestamp(System.currentTimeMillis()+DATE_EPOCH_DIFF);
        String strEndFinancialYear = null;
        Integer currentYear = Integer.parseInt(sdfYear.format(dt));
        Integer nextYear = currentYear + 1;
        Integer currentMonth = Integer.parseInt(sdfMonth.format(dt));

        if (currentMonth < 4) {
            strEndFinancialYear = currentYear.toString();
        }
        if (currentMonth >= 4) {
            strEndFinancialYear = nextYear.toString();
        }

        return strEndFinancialYear;
    }


    
  
    
    /*public static Timestamp getExpiryTimeTenMins() {
        
        java.util.Date dt=new java.util.Date(System.currentTimeMillis()+DATE_EXPIRY_TIME_TEN_MINUTES);
        
//        java.sql.Timestamp today = new Timestamp(System.currentTimeMillis());
        
        return new java.sql.Timestamp(dt.getTime());
    }*/
    
   /* public static Timestamp getFirstDateOfWeek(Timestamp tm) {
        Timestamp dt = new Timestamp(System.currentTimeMillis()+DATE_EPOCH_DIFF);
        Calendar cal = Calendar.getInstance();
        int currDay = dt.getDay(); // getting the current day
        int startDay = (currDay - cal.getFirstDayOfWeek()) + 1; // calculate the difference of number days to the current date from the first day of week
        dt.setDate(dt.getDate() - startDay); // setting the date accordingly.

        return new java.sql.Timestamp(dt.getTime());
    }*/

    public static Timestamp addDays(Timestamp timestamp, int intDays) {
        Calendar c1 = GregorianCalendar.getInstance();
        c1.set(Integer.parseInt(timestamp.toString().substring(0, 4)), timestamp.getMonth(), timestamp.getDate()); // 1999 jan 20
        c1.add(Calendar.DATE, intDays);
        java.util.Date date = c1.getTime();
        return new java.sql.Timestamp(date.getTime());
    }

       
    
    public static Timestamp stripTime(Timestamp timestamp) {
        return timestamp.valueOf(timestamp.toString().substring(0, 10) + " 00:00:00.000");
    }

    public static Timestamp appendTime(Timestamp timestamp) {
        return timestamp.valueOf(timestamp.toString().substring(0, 10) + " 23:59:59.000");
    }

    public static Timestamp parseStringToDate(String strDate)
            throws Exception {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try {
            java.util.Date today = df.parse(strDate);
            return new java.sql.Timestamp(today.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            throw new Exception("Unable to parse Date");
        }


    }

    public static Timestamp parseStringToTimeStamp(String strDate, String strFormat)
            throws Exception {
        DateFormat df = new SimpleDateFormat(strFormat);
        try {
            java.util.Date today = df.parse(strDate);
            return new java.sql.Timestamp(today.getTime());
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;


    }
    
    public static Date parseStringToDate(String strDate, String strFormat)
            throws Exception {
        DateFormat df = new SimpleDateFormat(strFormat);
        try {
            return  df.parse(strDate);
           
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;


    }
    public static String oneDateStrToOther(String strDate, String curFormat, String newFormat)
            throws Exception {
        DateFormat df = new SimpleDateFormat(curFormat);
        try {
        	return parseDateToString( df.parse(strDate),newFormat);
        
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;


    }

    public static String parseDateToString(java.util.Date today) {
        DateFormat df = new SimpleDateFormat("dd-MMM-yy");
        return df.format(today);
    }
   
    public static String parseDateToString(java.util.Date today, String strFormat) {
        DateFormat df = new SimpleDateFormat(strFormat);
        return df.format(today);
    }

    public static Integer getTimeInInteger() {
        java.util.Date today = new java.util.Date(System.currentTimeMillis()+DATE_EPOCH_DIFF);
        DateFormat df = new SimpleDateFormat("kkmmssSSS");
        return Integer.parseInt(df.format(today));
    }

    public static String formatDate(Timestamp tDate, int iDateFormat, Locale userLocale) throws Exception {
        DateFormat df = null;

        if (tDate == null) {
            return ("");
        }

        if (iDateFormat < 3) {
            df = DateFormat.getDateInstance(DateFormat.SHORT, userLocale);
        } else {
            df = DateFormat.getDateInstance(DateFormat.MEDIUM, userLocale);
        }

        try {
            String formattedDate = df.format(tDate);
            return formattedDate;
        } catch (IllegalArgumentException e) {
            return ("");
        }

    }

    public static long getDaysDifference(Timestamp time1, Timestamp time2, String strType) {

        long timeDifference = time1.getTime() - time2.getTime();

        if (strType.equals(DAYS)) {
            time1 = stripTime(time1);
            time2 = stripTime(time2);
            timeDifference = time1.getTime() - time2.getTime();
            timeDifference = timeDifference / (24 * 60 * 60 * 1000);
        } else if (strType.equals(HOURS)) {
            timeDifference = timeDifference / (60 * 60 * 1000);
        } else if (strType.equals(MINUTES)) {
            timeDifference = timeDifference / (60 * 1000);
        } else if (strType.equals(SECONDS)) {
            timeDifference = timeDifference / (1000);
        } else {
            timeDifference = 0L;
        }
        return timeDifference;
    }
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String TIME24HOURS_PATTERN = "([0-1]\\d|2[0-3]):([0-5]\\d)";

    public static boolean validateTime(String strTime) {
        pattern = Pattern.compile(TIME24HOURS_PATTERN);
        matcher = pattern.matcher(strTime);
        return matcher.matches();
    }

    public static int hoursDiff(Date earlierDate, Date laterDate) {
        if (earlierDate == null || laterDate == null) {
            return 0;
        }

        return (int) ((laterDate.getTime() / HOUR_MILLIS) - (earlierDate.getTime() / HOUR_MILLIS));
    }
    
    public static String getConnectFormatDateTime(Timestamp date)
    {
        SimpleDateFormat formatter = formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        StringBuffer isoDate = new StringBuffer();
        isoDate=formatter.format(date,isoDate,new FieldPosition(0));
        return isoDate.toString();
    }    
    public static String getConnectFormatDate(Timestamp date)
    {
        SimpleDateFormat formatter = formatter = new SimpleDateFormat("yyyyMMdd");
        StringBuffer isoDate = new StringBuffer();
        isoDate=formatter.format(date,isoDate,new FieldPosition(0));
        return isoDate.toString();
    }   
 public static Timestamp parseCoreFormatDate(String date)
            throws Exception {

        if (date == null || date.trim().equals("")) {
            return (Timestamp.valueOf("1900-01-01 00:00:00.000000000"));
        }

        SimpleDateFormat formatter = formatter = new SimpleDateFormat("yyyyMMdd");
        Timestamp isoFormat;
        try {
            isoFormat = new Timestamp(formatter.parse(date).getTime());
        } catch (ParseException e) {
            throw new Exception("Invalid Date in Message: " + date + ", " + e.getMessage());
        }
        return isoFormat;
    }
 
 
 public static Timestamp addMinutes(int min){
	 long MINUTE_IN_MILLIS = 60000;//millisecs
	 long t = getCurSQLTimeStamp().getTime();
	 Date afterAddingTenMins = new Date(t + (min * MINUTE_IN_MILLIS));
	 return new java.sql.Timestamp(afterAddingTenMins.getTime());
 }
 
 public static Timestamp addMinutesToStartDate(Date startDate, int min){
	 long MINUTE_IN_MILLIS = 60000;//millisecs
	 long t = startDate.getTime();
	 Date afterAddingTenMins = new Date(t + (min * MINUTE_IN_MILLIS));
	 return new java.sql.Timestamp(afterAddingTenMins.getTime());
 
}
    
    
}
