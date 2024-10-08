import java.io.*;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            // put file path
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
                    case 1:
                        // print question
                        int desired = input.inputQuestionNumber();

                        while ((line = bufReader.readLine()) != null) {
                            // if that character is a number
                            if(Character.isDigit(line.charAt(idx)))
                            {
                                // add to string
                                strToNum += line.charAt(idx);
                                idx++;
                            }
                            // if it is not a number
                            else
                            {
                                // if the number is same as we inputted
                                    if(desired == Integer.parseInt(strToNum))
                                    {

                                    }
                            }
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