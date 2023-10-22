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

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            int s;
            int start;
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer1 = new StringBuffer();
            while ((s=bufferedReader.read()) != -1) {
                stringBuffer.append((char) s);
            }
            for (int i = 0; i < stringBuffer.length()-1; i++) {
                start = i;
                while (stringBuffer.charAt(i) != '.'&&stringBuffer.charAt(i) != '!'){
                    if (i == stringBuffer.length())
                        break;
                    i++;
                }
                for (String x:censoredWords) {
                    if (x == stringBuffer.substring(start, i).toLowerCase()) {
                        System.out.println(stringBuffer.substring(start, i) + stringBuffer.charAt(i) + " ");
                        //break;
                    }
                    }
                i++;
            }


            //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out3.txt"));
            //bufferedWriter.write(stringBuffer1.substring(0));
            //bufferedWriter.close();


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
