import java.util.Scanner;
import static java.lang.System.*;
import java.util.*;
import java.lang.*;

public class Week3Test1 {
    public static void main(String[] args) {
        String temp = null;
        String []tempStrings = null;
        ArrayList <String> stringArray = new ArrayList<String>(); 
        int total = 0;
        while(true)
        {
            total = 0;
            Scanner enter = new Scanner(System.in);
            System.out.printf("Enter the String-1)break:");
            temp = enter.nextLine();
            if(temp.equals("-1") == true)
                break;
            else
            {
                tempStrings = temp.split(",|\\.| |!|:|;");
                for(int i = 0;i<tempStrings.length;i++)
                {
                    if(tempStrings[i].matches("^[a-zA-Z]*") == true && tempStrings[i].isEmpty() != true)
                        stringArray.add(tempStrings[i].toLowerCase());
                    else if(tempStrings[i].matches("^[0-9]*") == true)
                    {
                        total += Integer.parseInt(tempStrings[i]);
                    }
                }
                for(int i = 0;i<stringArray.size();i++)
                    System.out.println(stringArray.get(i));
                stringArray.removeAll(stringArray);
                System.out.println("Total = "+total);
            }
        }
    }
}
