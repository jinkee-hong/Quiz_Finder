import java.io.*;
import java.util.Calendar;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            String line = "";
            int  desired=0,currNum=0 ;
            Calendar currTime = Calendar.getInstance();
            Calendar endTime = Calendar.getInstance();
            endTime.add(Calendar.HOUR, 1);
            boolean isFirstSentence = true;
            Print print = new Print();
            Input input = new Input();
            Timer timer = new Timer();

            File file = new File("C:\\Users\\user\\Desktop\\자료구조 질문.txt");

             while (true) {
                 FileReader fr = new FileReader(file);
                 BufferedReader bufReader = new BufferedReader(fr);

                timer.interviewTimer(print, currTime, endTime);
                print.printMenu();
                switch (input.selection()) {
                    case 1:
                        // print question
                        desired = input.inputQuestionNumber();
                        while ((line = bufReader.readLine()) != null)
                        {
                            if (!line.isEmpty())
                            {
                                if(isFirstSentence)
                                {
                                    currNum = input.parseIntoNumber(line);
                                    if(desired == currNum)
                                    {
                                        // print instruction
                                        print.printInstruction(line);
                                        while(!(line = bufReader.readLine()).isEmpty())
                                        {
                                            print.printInstruction(line);
                                        }
                                    }
                                    isFirstSentence = false;
                                }
                            }
                            else
                            {
                                isFirstSentence = true;
                            }
                        }
                          break;
                    case 2: //quit
                        print.printInstruction("종료합니다.");
                        bufReader.close();
                        System.exit(1);
                        break;
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("FILE DO NOT FOUND");
        }
//        catch(InterruptedException e)
//        {
//            System.out.println("INTERRUPT EXCEPTION ");
//        }
    }
}