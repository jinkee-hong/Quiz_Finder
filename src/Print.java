public class Print {
    public enum menu{
        KEEP("문제 선택"),
        QUIT("종료");
        
        private String str;

        menu(String str)
        {this.str = str;}

        public String getStr()
        {
            return str;
        }

    }

    Print()
    {}

    public void printInstruction(String msg)
    {
        System.out.println(msg);
        if(msg!= null) {
            for (int i = 0; i < msg.length(); i++) {
                System.out.print("--");
            }
            System.out.println();
        }
    }

    public void printMenu()
    {
        int count = 1 ;
        printInstruction("메뉴");
        for(menu i : menu.values())
        {
            System.out.println(count +" " + i.getStr());
            count++;
        }
    }


}
