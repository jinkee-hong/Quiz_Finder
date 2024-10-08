import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
public class Timer {
    private final int MIN = 600000;
    private final int MAX_INTERVIEW_TIME = 60;// mins
    private final int MAX_ANSWER_TIME = 2; // mins


    public Calendar createCalendar()
    {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }


    public void answerTimer(Print print)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = createCalendar();
        for (int i = 1; ; i++) {
            if(i % MIN == 0)
            {
                cal.add(Calendar.MINUTE,1);
                print.printInstruction("현재 시각 : " + sdf.format(cal.getTime()));
            }
            else if(( i > MAX_ANSWER_TIME*MIN))
            {
                break;
            }
        }
    }

    public void interviewTimer(Print print,Calendar curr,Calendar end)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        int diff_h = end.get(Calendar.HOUR) - curr.get(Calendar.HOUR);
        int diff_m = end.get(Calendar.MINUTE) - curr.get(Calendar.MINUTE);
        int diff_s = end.get(Calendar.SECOND) - curr.get(Calendar.SECOND);

        if(curr.getTime().equals(end.getTime()))
        {
            print.printInstruction(sdf.format(end.getTime()) + "으로 면접 시간이 종료되었습니다.");
        }
        else
        {
            print.printInstruction("현재 시간 : "+sdf.format(curr.getTime()));
            print.printInstruction("남은 시간 : " + diff_h+"시" +" " + diff_m+"분"+" " + diff_s+"초");
        }
    }

}
