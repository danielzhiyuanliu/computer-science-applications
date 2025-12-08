import java.util.Calendar;

public class DateUtils
{
  public static String getDateTime()
  {
    Calendar cal = Calendar.getInstance();
    String dateTimeStr = cal.getTime().toString();
    return dateTimeStr;
  }
}