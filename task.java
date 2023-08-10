package home3;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.*;
import java.io.IOException;

public class task {

    public static void main(String[] args) {
        System.out.println("Введите ФИО, дату рождения, номер телефона и пол (указав f или m)");
        Scanner iScanner = new Scanner(System.in);
        String s = iScanner.nextLine();
        String [] ss= s.split(" ");
        int spaceCount = ss.length - 1;
        if(spaceCount<5)
        {
            System.out.println("Введено меньшее количество данных");
            return;
        }
        else if(spaceCount>5)
        {
            System.out.println("Введено большее количество данных");
            return;
        }
        String familiya="";
        String name="";
        String otchestvo="";
        String pol="";
        long phone=0;
        String date="";
        boolean parsepol=false;
        boolean parsedate=false;
        int countstr=0;
        for(int i=0;i<ss.length;i++)
        {
            if(ss[i]=="f"&(!parsepol)) 
                {
                    pol=ss[i];
                    parsepol=true;
                    break;
                }
            else if(ss[i]=="m"&(!parsepol)) 
                {
                    pol=ss[i];
                    parsepol=true;
                    break;
                }
            
            String[] sst=ss[i].split(".");
            if(sst.length==3)
            {
                try{
                if((Integer.parseInt(sst[0])<100)&(Integer.parseInt(sst[1])<100)&(Integer.parseInt(sst[0])<10000))
                {
                    date=ss[i];
                    parsedate=true;
                    break;
                }
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Неверный формат даты");
                    return;
                }
            }
            if(phone==0)
                try{
                    phone=Long.parseLong(ss[i]);
                    break;
                }
                catch(NumberFormatException e)
                {

                }
            switch(countstr)
            {
                case 0:
                familiya=ss[i];
                countstr+=1;
                break;
                case 1:
                    name=ss[i];
                    countstr+=1;
                break;
                case 2:
                    otchestvo=ss[i];
                    countstr+=1;
                break;
            }



        }
        if(phone==0)
        {
            System.out.println("Неверный формат телефона");
            return;
        }
        if(countstr!=3)
        {
            System.out.println("Неверный формат введенных данных");
            return;
        }
        if(parsepol)
        {
            System.out.println("Неверный формат пола");
            return;
        }
        if(parsedate)
        {
            System.out.println("Неверный формат даты");
            return;
        }
        try (FileWriter writer = new FileWriter(new
        File(""+familiya+".txt"),true)) {
        
            writer.write(familiya);
            writer.append(' ');
            writer.write(name);
            writer.append(' ');
            writer.write(otchestvo);
            writer.append(' ');
            writer.write(date);
            writer.append(' ');
            writer.write(""+phone);
            writer.append(' ');
            writer.write(pol);
            writer.append('\n');
            writer.append('E');
            writer.flush();
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
}