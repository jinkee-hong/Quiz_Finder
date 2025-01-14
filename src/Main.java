import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            String line  ;
            int  desired ,currNum  ;

            Calendar endTime = Calendar.getInstance();

            boolean isFirstSentence = true;

            Print print = new Print();
            Input input = new Input();
            Timer timer = new Timer();

            File file = new File("C:\\Users\\user\\Desktop\\자료구조 질문.txt");

             while (true) {
                 Calendar currTime = Calendar.getInstance();
                 BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
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
                                            print.printJumpedLine(line);
                                        }
                                         currTime = timer.answerTimer(print);
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
        catch(InterruptedException e)
        {
            System.out.println("INTERRUPT EXCEPTION ");
        }
    }
}