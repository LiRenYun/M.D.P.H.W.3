import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Week3Test2 {
    public static void main(String[] args) {
        HashMap hasharray = new HashMap();
        Scanner enter = new Scanner(System.in);
        String strings;
        int opt,grade;
        while(true)
        {
            System.out.printf("1.)Insert 2.)Search -1)End:");
            opt = enter.nextInt();
            if(opt == 1)
            {
                while(true)
                {
                    try{
                        System.out.printf("StudentName -1)back:");
                        enter.nextLine();
                        strings = enter.nextLine();

                        if(strings.equals("-1") == true)
                            break;
                        else
                        {
			    System.out.printf("StudentGrade:");
                            grade = enter.nextInt();
                            hasharray.put(strings,grade);
                        }
                    }
                    catch(Exception e)
                    {
                        enter.nextLine();
                        System.out.println(e);
                    }
                }
            }
            else if(opt == 2)
            {
                try{
                    System.out.printf("StudentName:");
                    strings = enter.next();    
                    if(hasharray.get(strings) != null)
                        System.out.printf(strings+":"+hasharray.get(strings)+"\n");
                    else
                        System.out.println("Can't find");
                }catch(Exception e)
                {
                    System.out.println(e);
                }
            }
            else if(opt == -1)
            {
                break;
            }
        }
    }
}
