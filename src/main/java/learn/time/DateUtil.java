package learn.time;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.time
 * company: SiBu
 * create_date: 2017/08/11
 * description :
 */
public class DateUtil {
    public static final String Y_M_D_HMS = "yyyy-MM-dd HH:mm:ss";

    public static Date getYesterdayStartTime(){
        LocalDateTime localDateTime= LocalDateTime.of(LocalDate.now(),LocalTime.MIN).minus(1,ChronoUnit.DAYS);
        ZonedDateTime zdt = ZonedDateTime.of(localDateTime.toLocalDate(),localDateTime.toLocalTime(),ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }
    public static Date getYesterdayEndTime(){
        LocalDateTime localDateTime= LocalDateTime.of(LocalDate.now(),LocalTime.MIN).minus(1,ChronoUnit.SECONDS);
        ZonedDateTime zdt = ZonedDateTime.of(localDateTime.toLocalDate(),localDateTime.toLocalTime(),ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }
    public static Date getLastYearStartDate(){
        LocalDateTime localDateTime= LocalDateTime.of(LocalDate.now().getYear(),1,1,0,0,0)
                .minus(1,ChronoUnit.YEARS);
        ZonedDateTime zdt = ZonedDateTime.of(localDateTime.toLocalDate(),localDateTime.toLocalTime(),ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }
    public static Date getLastYearEndDate(){
        LocalDateTime localDateTime= LocalDateTime.of(LocalDate.now().getYear(),12,31,23,59,59)
                .minus(1,ChronoUnit.YEARS);
        ZonedDateTime zdt = ZonedDateTime.of(localDateTime.toLocalDate(),localDateTime.toLocalTime(),ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }

    public static void main(String[] args) {
        System.out.println(getYesterdayStartTime());
        System.out.println(getYesterdayEndTime());
        System.out.println(getLastYearStartDate());
        System.out.println(getLastYearEndDate());
    }
}
