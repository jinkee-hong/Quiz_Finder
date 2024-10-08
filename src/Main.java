import java.io.*;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("C:\\Users\\user\\Desktop\\자료구조 질문.txt");
            FileReader fr = new FileReader(file);
            String line = "",strToNum ="" ;
            int idx = 0,idx2 = 0;
            Calendar currTime = Calendar.getInstance();
            Calendar endTime = Calendar.getInstance();
            endTime.add(Calendar.HOUR,1);
            Print print = new Print();
            Input input = new Input();
            Timer timer = new Timer();


            BufferedReader bufReader = new BufferedReader(fr);
            while(true)
            {
                timer.interviewTimer(print,currTime,endTime);
                print.printMenu();
                switch(input.selection())
                {
                    case 1: // print question
                        int desired = input.inputQuestionNumber();
                        while ((line = bufReader.readLine()) != null) {
                            if(Character.isDigit(line.charAt(idx)))
                            {
                                strToNum += line.charAt(idx);
                                 // if the number from input and number from question is matched
                                if(Integer.parseInt(strToNum) == desired && idx == 1)
                                {
                                    idx = 0; // initialize idx
                                    while((line.charAt(idx2))!='.')
                                    {
                                        System.out.println(line);
                                    }
                                    break;
                                }
                            }
                            idx += line.length();
                        }
                        timer.answerTimer(print);
                        break;
                    case 2: //quit
                        bufReader.close();
                        System.exit(1);
                        break;
                }
            }
         }
        catch(FileNotFoundException e)
        {
            System.out.println();
        }
    }
}