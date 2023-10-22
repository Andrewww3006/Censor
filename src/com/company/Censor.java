package com.company;

import java.io.*;
import java.util.ArrayList;

public class Censor {

    private ArrayList<String> censoredWords = new ArrayList<String>();

    Censor (String str){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            String s;
            while ((s=bufferedReader.readLine()) != null)
            {
                censoredWords.add(s.toLowerCase());
            }
        }
        catch (FileNotFoundException e)
        {
            e.getMessage();
        }
        catch (IOException e)
        {
            e.getMessage();
        }
    }

    public void getCensor()
    {
        for(String i: censoredWords)
            System.out.println(i);
    }

    public void checkFile(String str){

        int amount = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            int s;
            int start;
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer1 = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            while ((s=bufferedReader.read()) != -1) {
                stringBuffer.append((char) s);
            }
            for (int i = 0; i < stringBuffer.length()-1; i++) {
                start = i;
                while (stringBuffer.charAt(i) != '.' && stringBuffer.charAt(i) != '!'
                        && stringBuffer.charAt(i) != '?'){
                    if (i == stringBuffer.length())
                        break;
                    i++;
                }
                stringBuffer1.append(stringBuffer.substring(start, i)+stringBuffer.charAt(i));
                for (int j = 0; j < stringBuffer1.length()-1; j++) {
                    int start1 = j;
                    while (stringBuffer1.charAt(j) != '.' && stringBuffer1.charAt(j) != '!'
                            && stringBuffer1.charAt(j) != '?' && stringBuffer1.charAt(j) != ' ') {
                        if (i == stringBuffer1.length())
                            break;
                        j++;
                    }
                    for (String x:censoredWords) {
                        if (stringBuffer1.substring(start1, j).toLowerCase().equals(x)) {
                            stringBuffer2.append(stringBuffer1+" ");
                            amount++;
                            System.out.println(stringBuffer1);
                            break;
                        }
                    }
                    //j++;
                }
                stringBuffer1.delete(0,stringBuffer1.length());
                i++;
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out3.txt"));
            bufferedWriter.write(stringBuffer2.substring(0));
            bufferedWriter.close();
            System.out.println(amount);
            if (amount == 0)
                System.out.println("Текст прошел цензуру");

        }

        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }



    }



}
