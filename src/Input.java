import java.util.*;

public class Input {
    private final int MAX_QUESTION = 100;
    public Print print = new Print();
    public int inputQuestionNumber()
    {
        print.printInstruction(MAX_QUESTION + "개의 질문 중 하나를 선택해주세요.");
        Scanner sc= new Scanner(System.in);
        int num = 0 ;
        //TODO : 55
        num = sc.nextInt();
        print.printInstruction(num+"번이 선택되었습니다.");
        return num;
    }

    public int selection()
    {
        Scanner sc = new Scanner(System.in);
        int num = 0 ;
        do{
            num = sc.nextInt();
            if(num >Print.menu.values().length )
                System.out.println("메뉴 번호가 아닙니다. 다시 선택해주세요.");
        }while(num > Print.menu.values().length);

        print.printInstruction(num + "번을 선택하셨습니다.");
        return num;
    }

    public int parseIntoNumber(String line)
    {
        int idx = 0,count=0,radix =0,exp=-1 ;

        while(Character.isDigit(line.charAt(idx)))
        {
            count++;
            exp++;
             idx++;
             if(!Character.isDigit(line.charAt(idx)))
             {
                 for (int i = 0; i < count; i++)
                 {
                     radix += (int)Math.pow(10,exp) * (line.charAt(i)-48);
                     exp--;
                 }
                 break;
             }
        }

        return radix;
    }


}
