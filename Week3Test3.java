import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import static java.util.Objects.hash;
import java.util.Scanner;
import java.util.Set;

public class Week3Test3 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String []tempStrings = null;
        String strings = null;        
        ArrayList <String> stringArray = new ArrayList<String>(); 
        String tempstring = new String();
        HashMap hasharray = new HashMap();
        
        Scanner enter = new Scanner(System.in);
        
        int opt,tempkey;
        
        try(FileReader fr=new FileReader("hashdata.txt"))
        {
            BufferedReader bufferin=new BufferedReader(fr);
            String read;
            while((read=bufferin.readLine()) != null){
                    String[] token=read.split(",|\\.| |!|:|;");
                    hasharray.put(token[0],Integer.parseInt(token[1]));
            }
            fr.close();
            System.out.println("開啟舊檔案成功!\n");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error:找不到檔案");
        }
        catch(final IOException e)
        {
            System.out.println("Error:檔案錯誤!\n");
        }
        
        while(true)
        {
            System.out.printf("1.)Insert 2.)Search -1)End:");
            opt = enter.nextInt();
            if(opt == 1)
            {
                try{
                    System.out.printf("Enter the String -1)back:");
                    enter.nextLine();
                    strings = enter.nextLine();
                    
                    if(strings.equals("-1") == true)
                        break;
                    else
                    {
                        tempStrings = strings.split(",|\\.| |!|:|;");
                        for(int i = 0;i<tempStrings.length;i++)
                        {
                            if(tempStrings[i].matches("^[a-zA-Z]*") == true && tempStrings[i].isEmpty() != true)
                                stringArray.add(tempStrings[i].toLowerCase());
                        }
                        for(int i = 0;i < stringArray.size();i++)
                        {
                            if(hasharray.get(stringArray.get(i)) == null)
                            {
                                hasharray.put(stringArray.get(i),1);
                            }
                            else
                            {
                                tempkey = ((int)hasharray.get(stringArray.get(i))+1);
                                hasharray.remove(stringArray.get(i));
                                hasharray.put(stringArray.get(i),tempkey);
                            }
                        }
                        stringArray.removeAll(stringArray);
                    }
                }
                catch(Exception e)
                {
                    enter.nextLine();
                    System.out.println(e);
                }
            }
            else if(opt == 2)
            {
                try{
		    System.out.printf("Search word:");
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
                String data="";
                Set<String> hashStr=hasharray.keySet();
                for(String h:hashStr){
                        data+=h+" "+hasharray.get(h)+"\n";
                }
                FileWriter fw=new FileWriter("hashdata.txt");
                fw.write(data);
                fw.close();              
                break;
            }
        }
    }
    
}
