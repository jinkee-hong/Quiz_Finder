import java.io.*;
import java.util.Calendar;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            // put file path

            String line = "";
            StringBuilder strToNum = new StringBuilder();
            int idx = 0, idx2 = 0,temp_idx =0;
            boolean isInstructionOn = true;
            Calendar currTime = Calendar.getInstance();
            Calendar endTime = Calendar.getInstance();
            endTime.add(Calendar.HOUR, 1);

            Print print = new Print();
            Input input = new Input();
            Timer timer = new Timer();

             while (true) {
                File file = new File("C:\\Users\\user\\Desktop\\자료구조 질문.txt");
                FileReader fr = new FileReader(file);
                 BufferedReader bufReader = new BufferedReader(fr);

                // TODO :
                timer.interviewTimer(print, currTime, endTime);
                print.printMenu();
                switch (input.selection()) {
                    case 1:
                        // print question
                        int desired = input.inputQuestionNumber();

                        while ((line = bufReader.readLine()) != null) {

                            if (!line.isEmpty()) {
                                    //loop till found alphabet
                                    while(Character.isDigit(line.charAt(idx)))
                                    {
                                        // add to string
                                        strToNum.append(line.charAt(idx));
                                        idx++;
                                    }
                                 System.out.println(strToNum);
                                // TODO
                                    if (desired == Integer.parseInt(strToNum.toString()))
                                    {
                                        // if the number is same as we inputted
                                        // TODO
                                        if (isInstructionOn) {
                                            System.out.println(line);
                                        }
                                        while(!Objects.equals(line = bufReader.readLine(), ""))
                                        {
                                            System.out.println(line);
                                        }
                                        //currTime = timer.answerTimer(print);
                                        idx = 0;
                                        isInstructionOn = false;
                                        strToNum.replace(0,strToNum.length(),""); // re-initialize String
                                        break;
                                    }
                                idx = 0;
                                strToNum.replace(0,strToNum.length(),""); // re-initialize String

                             }
                            else
                            {
                                idx = 0;
                                strToNum.replace(0,strToNum.length(),""); // re-initialize String
                            }
                        }
                        isInstructionOn = true;
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