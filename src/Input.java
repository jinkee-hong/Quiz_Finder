import java.util.*;

public class Input {
    private final int MAX_QUESTION = 100;
    public Print print = new Print();
    public int inputQuestionNumber()
    {
        print.printInstruction(MAX_QUESTION + "개의 질문 중 하나를 선택해주세요.");
        Scanner sc= new Scanner(System.in);
        int num = 0 ;
        do{
            num = sc.nextInt();
            if(Character.isDigit(num) || num > MAX_QUESTION || num < 0)
            {
                System.out.println("올바른 입력이 아닙니다.");
            }
            //check num variable is not character or over max range
        }while(Character.isDigit(num) || num > MAX_QUESTION || num < 0);
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


}
