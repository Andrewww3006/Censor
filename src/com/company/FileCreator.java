package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {

    private BufferedWriter bw;

    FileCreator(String str, String str2)  {
        try {
            bw = new BufferedWriter(new FileWriter(str2));
            bw.write(str);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                bw.close();
            }
            catch (IOException e)
            {
                e.getMessage();
            }

        }

    }




}
