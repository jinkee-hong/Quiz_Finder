import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Timer {

    private final int MAX_INTERVIEW_TIME = 60;// mins
    private final int MAX_ANSWER_TIME = 2; // mins


    public Calendar createCalendar()
    {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }


    public Calendar answerTimer(Print print) throws InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = createCalendar();
        print.printInstruction("시작 시각 : " + sdf.format(cal.getTime()));
        TimeUnit.MILLISECONDS.sleep(1000*60*2);
        cal.add(Calendar.MINUTE,2);
        print.printInstruction("종료 시각 :  "+sdf.format(cal.getTime()));
        print.printInstruction("주어진 2분이 종료되었습니다.");
        return cal;
    }

    public void interviewTimer(Print print,Calendar curr,Calendar end)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        int diff_m = 60 - (curr.get(Calendar.MINUTE) -  end.get(Calendar.MINUTE));

        if(curr.getTime().equals(end.getTime()))
        {
            print.printInstruction(sdf.format(end.getTime()) + "으로 면접 시간이 종료되었습니다.");
        }
        else
        {
            print.printInstruction("현재 시간 : "+sdf.format(curr.getTime()));
            print.printInstruction("남은 시간 : " + diff_m+"분 남았습니다.");
        }
    }

}
