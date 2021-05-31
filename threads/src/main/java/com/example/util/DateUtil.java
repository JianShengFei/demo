/*--------------------------------------------------------------------------------------------------
 *Name:		Archive.java
 *Directory:		/com/jgoal/util/
 *Author:		Annia qian
 *Description:	common methods of Archive
 *Amend record
 *Date		Version		Member		Description
 *DD/MM/YYYY	1.0		Firstname Lastname	Createtion
 *--------------------------------------------------------------------------------------------------
 */
package com.example.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {
    public static final long DAY_MILLI = 0x5265c00L;
    public static int DAY_OF_MONTH_LEAP_YEAR[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static int DAY_OF_MONTH_NON_LEAP_YEAR[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static String DATE_FORMAT_DATEONLY = "yyyy-MM-dd";
    public static String DATE_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    private static SimpleDateFormat sdfDateOnly = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat sdfDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private GregorianCalendar gcal;
    private Timestamp time;
    private String holidayString;

    /**
     * @roseuid 3D225F360171
     */
    public DateUtil() {
        gcal = null;
        time = null;
        gcal = new GregorianCalendar();
        time = new Timestamp(System.currentTimeMillis());
    }

    /**
     * 判断日期格式是否正确
     *
     * @param date
     * @return
     */
    public static boolean isDate(String date) {
        String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
        Pattern pat = Pattern.compile(rexp);
        Matcher mat = pat.matcher(date);
        return mat.matches();
    }

    /**
     * @roseuid 3D225F36017B
     */
    public static Date toDate(String sDate) {
        return toDate(sDate, sdfDateOnly);
    }

    /**
     * @roseuid 3D225F360185
     */
    public static Date toDate(String sDate, String sFmt) {
        if (sFmt.equals(DATE_FORMAT_DATETIME)) {
            return toDate(sDate, sdfDateTime);
        }
        if (sFmt.equals(DATE_FORMAT_DATEONLY)) {
            return toDate(sDate, sdfDateOnly);
        } else {
            return toDate(sDate, sdfDateOnly);
        }
    }

    /**
     * @roseuid 3D225F360190
     */
    public static Date toDate(String sDate, SimpleDateFormat formatter) {
        return toDateA(sDate, formatter);
    }

    private synchronized static Date toDateA(String sDate, SimpleDateFormat formatter) {
        Date dt = null;
        try {
            if (formatter == null) {
                formatter = new SimpleDateFormat("yyyy-MM-dd");
            }
            dt = formatter.parse(sDate);
        } catch (Exception e) {
            e.printStackTrace();
            dt = null;
        } finally {
            return dt;
        }
    }

    private static Date toDateA(String sDate, String DateFormat) {
        Date dt = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(DateFormat);
            dt = formatter.parse(sDate);
        } catch (Exception e) {
            e.printStackTrace();
            dt = null;
        }
        return dt;
    }

    public static Date parseDate(String sDate, String DateFormat) {
        return toDateA(sDate, DateFormat);
    }

    public static Date toDateTime(String sDate, SimpleDateFormat formatter) {
        return toDateTimeA(sDate, formatter);
    }

    public static Date toDateTime(String sDate) {
        return toDateTimeA(sDate, sdfDateTime);
    }

    private static Date toDateTimeA(String sDate, SimpleDateFormat formatter) {
        Date dt = null;
        try {
            if (formatter == null) {
                formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }
            dt = formatter.parse(sDate);
        } catch (Exception e) {
            e.printStackTrace();
            dt = null;
        }
        return dt;
    }

    /**
     * @roseuid 3D225F3601A3
     */
    public static String toString(Date dt) {
        return toString(dt, sdfDateOnly);
    }

    /**
     * @roseuid 3D225F3601AD
     */
    public static String toString(Date dt, String sFmt) {
        if (dt == null) {
            return "";
        }
        if (sFmt.equals(DATE_FORMAT_DATETIME)) {
            return toString(dt, sdfDateTime);
        } else {
            return toString(dt, sdfDateOnly);
        }
    }

    /**
     * @roseuid 3D225F3601C1
     */
    public static String toString(Date dt, SimpleDateFormat formatter) {
        String sRet = null;
        try {
            sRet = formatter.format(dt).toString();
        } catch (Exception e) {
            e.printStackTrace();
            sRet = null;
        }
        return sRet;
    }

    /**
     * @roseuid 3D225F3601CC
     */
    public static boolean isSameDay(Timestamp date1, Timestamp date2) {
        String s2 = null;
        String s1 = date1.toString().substring(0, DATE_FORMAT_DATEONLY.length());
        s2 = date2.toString().substring(0, DATE_FORMAT_DATEONLY.length());
        return s1.equalsIgnoreCase(s2);
    }

    public static boolean isSameDay(Date date1, Date date2) {
        String s1 = DateToString(date1, "yyyy-MM-dd");
        String s2 = DateToString(date2, "yyyy-MM-dd");
        return s1.equalsIgnoreCase(s2);
    }

    /**
     * @roseuid 3D225F3601DF
     */
    public static Timestamp getFirstDayOfWeek(Timestamp timestamp) {
        int no = getWeekdayOfTimestamp(timestamp);
        Timestamp out = addDays(timestamp, 1 - no);
        return out;
    }

    /**
     * @roseuid 3D225F3601E9
     */
    public static Timestamp getLastDayOfWeek(Timestamp timestamp) {
        int no = getWeekdayOfTimestamp(timestamp);
        Timestamp out = addDays(timestamp, 7 - no);
        return out;
    }

    /**
     * @roseuid 3D225F3601F3
     */
    public static Timestamp getFirstSundayOfMonth(Timestamp timestamp) {
        Timestamp out = null;
        if (timestamp == null) {
            return null;
        } else {
            out = getFirstDayOfMonth(timestamp);
            out = getFirstDayOfWeek(out);
            return out;
        }
    }

    /**
     * @roseuid 3D225F3601FD
     */
    public static Timestamp getLastSaturdayOfMonth(Timestamp timestamp) {
        Timestamp out = null;
        if (timestamp == null) {
            return null;
        } else {
            out = getLastDayOfMonth(timestamp);
            out = getLastDayOfWeek(out);
            return out;
        }
    }

    /**
     * @roseuid 3D225F360207
     */
    public static Timestamp getFirstDayOfMonth(Timestamp timestamp) {
        Timestamp out = null;
        if (timestamp == null) {
            return null;
        } else {
            int day = getDayOfTimestamp(timestamp);
            out = addDays(timestamp, 1 - day);
            return out;
        }
    }

    /**
     * @roseuid 3D225F360211
     */
    public static long daysBetween(Timestamp t1, Timestamp t2) {
        return (t2.getTime() - t1.getTime()) / 0x5265c00L;
    }

    /**
     * @roseuid 3D225F360225
     */
    public static String formatYMD(int year, int month, int day) {
        return formatYMDA(year, month, day, "/");
    }

    public static String formatYMD(int year, int month, int day, String midstr) {
        return formatYMDA(year, month, day, midstr);
    }

    private static String formatYMDA(int year, int month, int day, String midstr) {
        String temp = String.valueOf(String.valueOf(String.valueOf(year))).concat(midstr);
        if (month < 10) {
            temp = String.valueOf(temp) + String.valueOf(String.valueOf(String.valueOf((new StringBuffer("0")).append(String.valueOf(month)).append(midstr))));
        } else {
            temp = String.valueOf(temp) + String.valueOf(String.valueOf(String.valueOf(String.valueOf(month))).concat(midstr));
        }
        if (day < 10) {
            temp = String.valueOf(temp) + String.valueOf("0".concat(String.valueOf(String.valueOf(String.valueOf(day)))));
        } else {
            temp = String.valueOf(temp) + String.valueOf(String.valueOf(day));
        }
        return temp;
    }

    /**
     * @roseuid 3D225F360239
     */
    public static Timestamp getLastDayOfMonth(Timestamp timestamp) {
        Timestamp out = null;
        if (timestamp == null) {
            return null;
        }
        GregorianCalendar obj = convertTimestampToCalendar(timestamp);
        int day = 0;
        int year = obj.get(1);
        int month = obj.get(2) + 1;
        if (obj.isLeapYear(obj.get(1))) {
            day = DAY_OF_MONTH_LEAP_YEAR[month - 1];
        } else {
            day = DAY_OF_MONTH_NON_LEAP_YEAR[month - 1];
        }
        out = toSqlTimestamp(formatYMD(year, month, day));
        return out;
    }

    /**
     * @roseuid 3D225F360243
     */
    public static int getYearOfTimestamp(Timestamp timestamp) {
        GregorianCalendar obj = convertTimestampToCalendar(timestamp);
        return obj.get(1);
    }

    /**
     * @roseuid 3D225F36024D
     */
    public static int getMonthOfTimestamp(Timestamp timestamp) {
        GregorianCalendar obj = convertTimestampToCalendar(timestamp);
        return obj.get(2) + 1;
    }

    /**
     * @roseuid 3D225F360257
     */
    public static int getDayOfTimestamp(Timestamp timestamp) {
        GregorianCalendar obj = convertTimestampToCalendar(timestamp);
        return obj.get(5);
    }

    /**
     * @roseuid 3D225F360261
     */
    public static int getWeekdayOfTimestamp() {
        GregorianCalendar obj = convertTimestampToCalendar(getSysDateTimestamp());
        return obj.get(7);
    }

    public static int getWeekdayOfTimestamp(Timestamp timestamp) {
        GregorianCalendar obj = convertTimestampToCalendar(timestamp);
        return obj.get(7);
    }

    /**
     * @roseuid 3D225F36026B
     */
    public static Timestamp getZeroTime(Timestamp timestamp) {
        String tempStr = timestamp.toString().substring(0, 10);
        return toSqlTimestamp(tempStr);
    }

    /**
     * @roseuid 3D225F360275
     */
    public static String getHourAndMinuteString(Timestamp timestamp) {
        String out = null;
        GregorianCalendar obj = convertTimestampToCalendar(timestamp);
        int hour = obj.get(11);
        int minute = obj.get(12);
        if (minute < 10) {
            out = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(String.valueOf(hour))))).append(":0").append(String.valueOf(minute))));
        } else {
            out = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(String.valueOf(hour))))).append(":").append(String.valueOf(minute))));
        }
        return out;
    }

    /**
     * @roseuid 3D225F36027F
     */
    public static int getHourOfTimestamp(Timestamp timestamp) {
        GregorianCalendar obj = convertTimestampToCalendar(timestamp);
        return obj.get(11);
    }

    /**
     * @roseuid 3D225F360289
     */
    public static int getMinuteOfTimestamp(Timestamp timestamp) {
        GregorianCalendar obj = convertTimestampToCalendar(timestamp);
        return obj.get(12);
    }

    /**
     * @roseuid 3D225F360293
     */
    public static int getSecondOfTimestamp(Timestamp timestamp) {
        GregorianCalendar obj = convertTimestampToCalendar(timestamp);
        return obj.get(13);
    }

    /**
     * @roseuid 3D225F36029D
     */
    public static GregorianCalendar convertTimestampToCalendar(Timestamp timestamp) {
        return convertToCalendar(timestamp);
    }

    /**
     * @roseuid 3D225F3602A7
     */
    public static GregorianCalendar convertToCalendar(Timestamp timestamp) {
        GregorianCalendar obj = new GregorianCalendar();
        obj.setTime(convertTimestampToDate(timestamp));
        return obj;
    }

    /**
     * @roseuid 3D225F3602B1
     */
    public static Date convertTimestampToDate(Timestamp timestamp) {
        Date date = null;
        date = new java.sql.Date(timestamp.getTime());
        return date;
    }

    public static String getSysDateTime() {
        return getSysDate("yyyy-MM-dd") + " " + getSysDate("HH:mm:ss");
    }

    public static int getDayOfWeek(Date d1) {
        return d1.getDay();
    }

    public static int getDayOfWeek() {
        Date d1 = getSysDate();
        return d1.getDay();
    }

    public static Date getSysDate() {
        return getSysDateA();
    }

    private static Date getSysDateA() {
        Date currentTime = new Date();
        return currentTime;
    }

    /**
     * ��ȡbirthday ��û�й�ȥ�Ľ���
     *
     * @param birthday ����
     * @return
     */
    public static Date getNextBirthDay(Date birthday) {
        Date now = new Date();
        Date nextbirthday = birthday;
        if (birthday.getMonth() * 12 + birthday.getDate() < now.getMonth() * 12 + now.getDate()) {
            nextbirthday = new Date(now.getYear() + 1, birthday.getMonth(), birthday.getDate());
        } else {
            nextbirthday = new Date(now.getYear(), birthday.getMonth(), birthday.getDate());
        }
        return nextbirthday;
    }

    private static String DateToStringA(Date currentTime, String DateFormat) {
        if (currentTime == null) {
            return "";
        }
        String rst = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(DateFormat);
            rst = formatter.format(currentTime);
        } catch (Exception E) {
            rst = "Convert Date To String Error: Examples:yyyy-MM-dd HH:mm:ss,your format is " + DateFormat;
        }
        return rst;
    }

    public static String DateToString(Date currentTime) {
        return DateToStringA(currentTime, "yyyy-MM-dd");
    }

    public static String DateToStr(Date currentTime) {
        return DateToStringA(currentTime, "yyyy-MM-dd HH:mm:ss");
    }

    public static String DateToString(Date currentTime, String DateFormat) {
        return DateToStringA(currentTime, DateFormat);
    }


    public static String DateToString() {
        return DateToStringA(getSysDate(), "yyyy-MM-dd");
    }

    public static String TimeToString() {
        return DateToStringA(getSysDate(), "HH-mm-ss");
    }

    public static String getSysDate(String DateFormat) {
        return DateToStringA(getSysDateA(), DateFormat);
    }


    public static int getSysYear() {
        return Integer.parseInt(getSysDate("yyyy"));
    }

    private static String getYearOptionA(int years, int maxyear, int curyear) {
        String Str = "";
        for (int i = maxyear; i > maxyear - years; i--) {
            if (i == curyear) {
                Str += "<option value=\"" + i + "\" selected>" + i + "</option>";
            } else {
                Str += "<option value=\"" + i + "\">" + i + "</option>";
            }
        }
        return Str;
    }

    public static String getYearOption(int years, int maxyear, int curyear) {
        return getYearOptionA(years, maxyear, curyear);
    }

    public static String getYearOption(int years, int curyear) {
        return getYearOptionA(years, getSysYear(), curyear);
    }

    public static String getYearOption(int years) {
        return getYearOptionA(years, getSysYear(), 0);
    }

    public static String getYearOption() {
        return getYearOptionA(100, getSysYear(), 0);
    }

    public static int getSysMonth() {
        return Integer.parseInt(getSysDate("MM"));
    }

    private static String getMonthOptionA(int curmonth) {
        String Str = "";
        for (int i = 1; i <= 12; i++) {
            if (i == curmonth) {
                Str += "<option value=\"" + i + "\" selected>" + i + "</option>";
            } else {
                Str += "<option value=\"" + i + "\">" + i + "</option>";
            }
        }
        return Str;
    }

    public static String getMonthOption(int curmonth) {
        return getMonthOptionA(curmonth);
    }

    public static String getMonthOption() {
        return getMonthOptionA(0);
    }

    public static int getSysDay() {
        return Integer.parseInt(getSysDate("dd"));
    }

    private static String getDayOptionA(int curday) {
        String Str = "";
        for (int i = 1; i <= 31; i++) {
            if (i == curday) {
                Str += "<option value=\"" + i + "\" selected>" + i + "</option>";
            } else {
                Str += "<option value=\"" + i + "\">" + i + "</option>";
            }
        }
        return Str;
    }

    public static String getDayOption(int curday) {
        return getDayOptionA(curday);
    }

    public static String getDayOption() {
        return getDayOptionA(0);
    }

    public static int getSysDateDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static String getSysDayOfWeek() {
        return getSysDayOfWeek(getSysDateDayOfWeek());
    }

    public static String getSysDayOfWeek(int day) {
        String rst = "";
        String daystr[] = {"", "��", "һ", "��", "��", "��", "��", "��"};
        return daystr[day];
    }

    public static void setConvertFormat(String FormatString) {
        sdfDateFormat = new SimpleDateFormat(FormatString);
    }

    /**
     * @roseuid 3D225F3602BB
     */
    public static long getSysDateLong() {
        return System.currentTimeMillis();
    }

    /**
     * @roseuid 3D225F3602BC
     */
    public static Timestamp getSysDateTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * @roseuid 3D225F3602BD
     */
    public static String getSysDateString() {
        return toString(new Date(System.currentTimeMillis()), sdfDateOnly);
    }

    /**
     * @roseuid 3D225F3602C5
     */
    public static String getSysDateTimeString() {
        return toString(new Date(System.currentTimeMillis()), sdfDateTime);
    }

    /**
     * @roseuid 3D225F3602C6
     */
    public static java.sql.Date toSqlDate(String sDate) {
        return java.sql.Date.valueOf(sDate.replace('/', '-'));
    }

    /**
     * @roseuid 3D225F3602CF
     */
    public static String toSqlDateString(java.sql.Date dt) {
        String temp = null;
        temp = dt.toString();
        return temp.replace('-', '/');
    }

    /**
     * @roseuid 3D225F3602D9
     */
    public static Timestamp toSqlTimestamp(String sDate) {
        if (sDate == null) {
            return null;
        }
        if (sDate.length() != DATE_FORMAT_DATEONLY.length()) {
            return null;
        } else {
            return toSqlTimestamp(sDate, DATE_FORMAT_DATEONLY);
        }
    }

    /**
     * @roseuid 3D225F3602E3
     */
    public static Timestamp toSqlTimestamp(String sDate, String sFmt) {
        String temp = null;
        if (sDate == null || sFmt == null) {
            return null;
        }
        if (sDate.length() != sFmt.length()) {
            return null;
        }
        if (sFmt.equals(DATE_FORMAT_DATETIME)) {
            temp = sDate.replace('/', '-');
            temp = String.valueOf(String.valueOf(temp)).concat(".000000000");
        } else if (sFmt.equals(DATE_FORMAT_DATEONLY)) {
            temp = sDate.replace('/', '-');
            temp = String.valueOf(String.valueOf(temp)).concat(" 00:00:00.000000000");
        } else {
            return null;
        }
        return Timestamp.valueOf(temp);
    }

    /**
     * @roseuid 3D225F3602EE
     */
    public static String toSqlTimestampString(Timestamp dt) {
        if (dt == null) {
            return null;
        } else {
            return toSqlTimestampString(dt, DATE_FORMAT_DATEONLY);
        }
    }

    /**
     * @roseuid 3D225F3602F8
     */
    public static String toSqlTimestampString2(Timestamp dt) {
        if (dt == null) {
            return null;
        } else {
            String temp = toSqlTimestampString(dt, DATE_FORMAT_DATETIME);
            return temp.substring(0, 16);
        }
    }

    /**
     * @roseuid 3D225F360302
     */
    public static String toString(Timestamp dt) {
        return dt != null ? toSqlTimestampString2(dt) : "";
    }

    /**
     * @roseuid 3D225F36030C
     */
    public static String convertTimestampToChinaCalendar(Timestamp timestamp) {
        StringBuffer sb = new StringBuffer();
        if (timestamp == null) {
            sb.append("&nbsp");
        } else {
            sb = new StringBuffer();
            sb.append(getYearOfTimestamp(timestamp));
            sb.append("\u5E74");
            sb.append(getMonthOfTimestamp(timestamp));
            sb.append("\u6708");
            sb.append(getDayOfTimestamp(timestamp));
            sb.append("\u65E5");
            sb.append("\u3000");
            sb.append(getHourOfTimestamp(timestamp));
            sb.append(":");
            if (getMinuteOfTimestamp(timestamp) < 10) {
                sb.append(0);
                sb.append(getMinuteOfTimestamp(timestamp));
            } else {
                sb.append(getMinuteOfTimestamp(timestamp));
            }
            sb.append(":");
            if (getSecondOfTimestamp(timestamp) < 10) {
                sb.append(0);
                sb.append(getSecondOfTimestamp(timestamp));
            } else {
                sb.append(getSecondOfTimestamp(timestamp));
            }
        }
        return sb.toString();
    }

    /**
     * @roseuid 3D225F360316
     */
    public static String toSqlTimestampString(Timestamp dt, String sFmt) {
        String temp = null;
        String out = null;
        if (dt == null || sFmt == null) {
            return null;
        }
        temp = dt.toString();
        if (sFmt.equals(DATE_FORMAT_DATETIME) || sFmt.equals(DATE_FORMAT_DATEONLY)) {
            temp = temp.substring(0, sFmt.length());
            out = temp.replace('-', '/');
        }
        return out;
    }

    /**
     * @roseuid 3D225F360329
     */
    public static String toHourMinString(Timestamp dt) {
        String temp = null;
        temp = dt.toString();
        temp = temp.substring(11, 16);
        return temp;
    }

    /**
     * @roseuid 3D225F360333
     */
    private static boolean isLastDayOfMonth(GregorianCalendar obj) {
        int year = obj.get(1);
        int month = obj.get(2) + 1;
        int day = obj.get(5);
        if (obj.isLeapYear(year)) {
            if (day == DAY_OF_MONTH_LEAP_YEAR[month - 1]) {
                return true;
            }
        } else if (day == DAY_OF_MONTH_NON_LEAP_YEAR[month - 1]) {
            return true;
        }
        return false;
    }

    /**
     * @roseuid 3D225F36033D
     */
    public static Timestamp addMonths(Timestamp timestamp, int mon) {
        Timestamp out = null;
        GregorianCalendar obj = convertTimestampToCalendar(timestamp);
        int year = obj.get(1);
        int month = obj.get(2) + 1;
        int day = obj.get(5);
        month += mon;
        while (month > 12) {
            month -= 12;
            year++;
        }
        while (month < 1) {
            month += 12;
            year--;
        }
        if (isLastDayOfMonth(obj)) {
            if (obj.isLeapYear(year)) {
                day = DAY_OF_MONTH_LEAP_YEAR[month - 1];
            } else {
                day = DAY_OF_MONTH_NON_LEAP_YEAR[month - 1];
            }
        }
        String temp = formatYMD(year, month, day);
        out = toSqlTimestamp(temp);
        return out;
    }

    /**
     * @roseuid 3D225F360351
     */
    public static Timestamp addDays(Timestamp timestamp, int days) {
        Date date = convertTimestampToDate(timestamp);
        long temp = date.getTime();
        return new Timestamp(temp + 0x5265c00L * (long) days);
    }

    public static long DaysDifferen(Date d1, Date d2) {
        long temp1 = d1.getTime();
        long temp2 = d2.getTime();
        return (long) ((temp2 - temp1) / 0x5265c00L);
    }

    //
    public static long SecondsDifferen(Date d1, Date d2) {
        long temp1 = d1.getTime();
        long temp2 = d2.getTime();
        return (long) ((temp2 - temp1) / 1000);
    }

    public static Date getDay(int day) {
        return getDay(new Date(), day);
    }

    public static Date getDay(Date d1, int day) {
        long temp1 = d1.getTime();
        temp1 = temp1 + day * 0x5265c00L;
        return (new Date(temp1));
    }

    /**
     * 多少月后的时间
     */
    public static Date getMonth(int month) {
        return getMonth(new Date(), month);
    }

    public static Date getMonth(Date m1, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(m1);
        c.add(Calendar.MONTH, month);
        Date m = c.getTime();
        return m;
    }

    //获取多少小时后的时间
    public static Date getDayTime(Date d1, int hour) {
        long temp1 = d1.getTime();
        temp1 = temp1 + hour * 3600 * 1000L;
        return (new Date(temp1));
    }

    public static Date getDayTime(int hour) {//几小时后的时间

        return getDayTime(new Date(), hour);
    }

    public static Date getDayTimeMin(int min) {//几分钟后的时间

        return getDayTimeMin(new Date(), min);
    }

    public static Date getDayTimeScend(int scend) {//几秒钟后的时间

        return getDayTimeScend(new Date(), scend);
    }

    public static Date getDayTimeScend(Date d1, int scend) {
        long temp1 = d1.getTime();
        temp1 = temp1 + scend * 1000L;
        return (new Date(temp1));
    }

    public static Date getDayTimeMin(Date d1, int min) {
        long temp1 = d1.getTime();
        temp1 = temp1 + min * 60 * 1000L;
        return (new Date(temp1));
    }

    public static Date getWeek(Date d1, int week) {
        long temp1 = d1.getTime();
        temp1 = temp1 + week * 0x240C8400L;
        return (new Date(temp1));
    }

    public static Date getWeek(int week) {
        return getWeek(new Date(), week);
    }

    public static Date getLastWeek() {
        return getWeek(new Date(), -1);
    }

    public static Date getNextWeek() {
        return getWeek(new Date(), 1);
    }

    public static long DaysDifferen(Date d1) {
        long temp1 = d1.getTime();
        Date d2 = getSysDate();
        long temp2 = d2.getTime();
        return (long) ((temp2 - temp1) / 0x5265c00L);
    }

    public static long Differen(Date d1) {
        long temp1 = d1.getTime();
        Date d2 = getSysDate();
        long temp2 = d2.getTime();
        return (long) (temp2 - temp1);
    }


    public static long Differen(Date d1, Date d2) {
        long temp1 = d1.getTime();
        long temp2 = d2.getTime();
        return (long) (temp2 - temp1);
    }

    /**
     * @roseuid 3D225F360365
     */
    public static Date addDays(Date date, int days) {
        long temp = date.getTime();
        return new Date(temp + 0x5265c00L * (long) days);
    }

    public static long getTimeUnit() {
        long l = 24 * 60 * 60 * 1000;
        return l;
    }

    public static String[] getMonthShort() {
        String rst[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return rst;
    }

    public static String[] getWeekShort() {
        String rst[] = {"Mon", "Tue", "Wed", "Thi", "Fri", "Sat", "Sun"};
        return rst;
    }

    /**
     * 某日期與當前時間比較大小
     *
     * @param da
     * @return
     */
    public static String compareDateTime(Date da) {
        if (da == null) {
            return "error";
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            Date md = sdf.parse(DateUtil.DateToString(da, "yyyy-MM-dd"));
            Date nd = sdf.parse(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(md);
            c2.setTime(nd);
            int result = c1.compareTo(c2);//傳�?來的日期和當前日期比�?
            if (result < 0) {//傳�?來的日期小於當前日期
                return "lq";
            } else if (result == 0) {//傳�?來的日期等於當前日期
                return "eq";
            } else {
                return "bg";
            }
        } catch (Exception e) {
            return "error";
        }
    }

    /**
     * 获取指定时间前n小时的时间
     *
     * @param day
     * @param hour
     * @return
     */
    public static String getFristDateMonth(String day, Integer hour) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//12小时制
        Date date = null;
        try {
            date = format.parse(day);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (date == null) {
            return "";
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, hour);//24小时制
        //cal.add(Calendar.HOUR, x);12小时制
        date = cal.getTime();
        cal = null;
        return format.format(date);
    }

    /**
     * 获取当前时间的前n个月
     *
     * @param date
     * @param month
     * @return
     */
    public static String getFristDateMonth(Date date, Integer month) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//24小时制
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//12小时制
        if (date == null) {
            return "";
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);//24小时制
        //cal.add(Calendar.HOUR, x);12小时制
        date = cal.getTime();
        cal = null;
        return format.format(date);
    }


    public static Long getFristDateDay(Date date, Integer day) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//12小时制
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -day);//24小时制
        date = cal.getTime();
        cal = null;
        return date.getTime();
    }

    /**
     * 返回前N天
     *
     * @param date
     * @param day
     * @return
     */
    public static String getFristDate(Date date, Integer day) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//12小时制
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, day);//24小时制
        date = cal.getTime();
        cal = null;
        return format.format(date);
    }

    /**
     * 返回前N天 yyyy-MM-dd
     *
     * @param sDate
     * @param day
     * @return
     */
    public static String getFristTostring(String sDate, Integer day) {
        if (sDate == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//24小时制
        Date date = toDate(sDate, DATE_FORMAT_DATEONLY);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, day);//24小时制
        date = cal.getTime();
        cal = null;
        return format.format(date);
    }

    /**
     * 获取多少秒之后的日期
     *
     * @param date
     * @param second
     * @return
     */
    public static Date getLastDateBySecond(Date date, Integer second) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//12小时制
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, second);//24小时制
        date = cal.getTime();
        cal = null;
        return date;
    }

    /**
     * 计算两个日期之间的天数
     *
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public static int DateBetweenToCondition(String dateStart, String dateEnd) {
        int intervalMilli = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date dateOnce;
        Date dateTwo;
        try {
            dateOnce = sdf.parse(dateStart);
            dateTwo = sdf.parse(dateEnd);
            intervalMilli = (int) (dateTwo.getTime() - dateOnce.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return intervalMilli;
    }

    /**
     * 计算两个日期之间的分钟数
     *
     * @param dateStart
     * @return
     */
    public static int DateBetweenTominute(String dateStart) {
        int intervalMilli = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Date dateOnce;
        Date dateTwo;
        try {
            dateOnce = sdf.parse(dateStart);
            dateTwo = new Date();
            intervalMilli = (int) (dateTwo.getTime() - dateOnce.getTime()) / (1000 * 60);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return intervalMilli;
    }

    /**
     * 两个日期相差的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDateSpace(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar2.setTime(date2);
        long milliseconds1 = calendar1.getTimeInMillis();
        long milliseconds2 = calendar2.getTimeInMillis();
        long diff = milliseconds2 - milliseconds1;
        long diffDays = diff / (24 * 60 * 60 * 1000);
        return Math.abs(diffDays);
    }

    /**
     * 两个日期相差的分钟数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getMinuteSpace(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar2.setTime(date2);
        long milliseconds1 = calendar1.getTimeInMillis();
        long milliseconds2 = calendar2.getTimeInMillis();
        long diff = milliseconds2 - milliseconds1;
        long diffDays = diff / (60 * 1000);
        return Math.abs(diffDays);
    }


    /**
     * 将字符串计算成分钟数
     * 格式 9：00 / 10：30
     *
     * @return
     */
    public static long getDateStrToMinute(String dateStr) {
        long dateMin = 0L;
        String[] split = dateStr.split(":");
        for (int i = 0; i < split.length; i++) {
            long intStr = Long.valueOf(split[i]);
            if (i == 0) {
                dateMin = 60 * intStr;
            } else if (i == 1) {
                dateMin = dateMin + intStr;
            }
        }
        return dateMin;
    }


    /**
     * 把number转换成日期类型
     */
    public static String numberDateToString(Long dateTime, String format) {
        if (dateTime == 0) {
            return null;
        }
        Date date = new Date();
        date.setTime(dateTime);
        return DateToString(date, format);
    }

    /**
     * 获取指定日期的零点
     *
     * @param date
     * @return
     */
    public static Date getZeroDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        return zero;
    }

    /**
     * 获取俩个日期之间相差多少天
     *
     * @param dateX
     * @param dateY
     * @return
     */
    public static int getDiffDays(Date dateX, Date dateY) {
        if ((dateX == null) || (dateY == null)) {
            return 0;
        }

        long dayX = dateX.getTime();
        long dayY = dateY.getTime();

        return dayX > dayY ? (int) ((dayX - dayY) / (60 * 60 * 1000 * 24)) : (int) ((dayY - dayX) / (60 * 60 * 1000 * 24));
    }

    /**
     * 获取下一日零点
     *
     * @return
     * @throws ParseException
     */
    public static Date getTomorrowDay() throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return sdfDateTime.parse(sdfDateOnly.format(cal.getTime()) + " 00:00:00");
    }

    public static LocalDateTime toLocalDateTime(String sDate, String sFmt) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(sFmt);
        return LocalDateTime.parse(sDate, df);
    }

    /**
     * date转LocalDateTime
     *
     * @param date
     * @param sFmt date的格式
     * @return
     */
    public static LocalDateTime toLocalDateTime(Date date, String sFmt) {
        return toLocalDateTime(toString(date, sFmt), sFmt);
    }

    /**
     * LocalDateTime -> String
     *
     * @param localDateTime
     * @param format
     * @return
     */
    public static String localDateTimeToString(LocalDateTime localDateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(formatter);
    }

    /**
     * LocalDateTime -> Date
     *
     * @param localDateTime
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * 根据传入的时间 增加分钟
     *
     * @param time
     * @param min
     * @return
     */
    public static LocalDateTime getlocalDateTimeWithMin(LocalDateTime time, Integer min) {
        return time.plusMinutes(NumberUtils.toLong(min));
    }

    /**
     * 根据传入的时间 增加小时
     *
     * @param time
     * @param hours
     * @return
     */
    public static LocalDateTime getlocalDateTimeWithHours(LocalDateTime time, Integer hours) {
        return time.plusHours(NumberUtils.toLong(hours));
    }

    /**
     * 根据传入的时间 增加天数
     *
     * @param time
     * @param day
     * @return
     */
    public static LocalDateTime getLocalDateTimeWithDay(LocalDateTime time, Integer day) {
        if (time == null) {
            return null;
        }
        return time.plusDays(NumberUtils.toLong(day));
    }


    public static LocalDateTime getLocalDateTimeWithDay(Integer day) {
        return getLocalDateTimeWithDay(LocalDateTime.now(), day);
    }

    /**
     * 根据传入的小时，获取发送时间，超过时间则延时到第二天
     *
     * @param hour
     * @return
     */
    public static LocalDateTime getTimmingSendTime(Integer hour) {
        int tsign = Integer.parseInt(DateUtil.DateToString(new Date(), "HH"));
        Integer dayInteger = 1;
        if (tsign >= 0 && tsign <= hour) {
            dayInteger = 0;
        }
        LocalDateTime dateTime = LocalDateTime.now().plusDays(dayInteger).withHour(hour).withMinute(0).withSecond(0);
        return dateTime;
    }

    /**
     * 获取当前时间距离下一日零点还剩多少秒
     */
    public static Integer getTodaySurplusSecond() throws ParseException {
        Long nextDateMillSecond = getTomorrowDay().getTime();
        Long nowDateMillSecond = System.currentTimeMillis();
        Long second = (nextDateMillSecond - nowDateMillSecond) / 1000;
        return second.intValue();
    }

    /**
     * 获取参数时间多少分钟前或后的时间
     * @param date
     * @param minute
     * @return
     */
    public static String getLastDateByMinute(Date date,Integer minute){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        if (date == null){
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minute);//24小时制
        date = cal.getTime();
        cal = null;
        return format.format(date);
    }

    public static void main(String[] args) {
        System.out.println(-Integer.valueOf(5) - 1);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, -5);//24小时制
        date = cal.getTime();
        System.out.println(format.format(date));
    }
}
