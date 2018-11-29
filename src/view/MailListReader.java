package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import model.Mail;

public class MailListReader {

    private MailListReader() {}

    private static class ReaderHolder {
        private static final MailListReader instance = new MailListReader();
    }

    public static MailListReader getInstance() {
        return ReaderHolder.instance;
    }

    public List<Mail> read(String filePath)  {
        List<Mail> mailList = new ArrayList<>();

        File f;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            f = new File(filePath);
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String line = "";
            line = br.readLine();
            while(line != null) {
                if(line.matches("\\w+(\\.\\w+)*@\\w+(\\.\\w+)*")) {
                    Mail mail = new Mail(line);
                    mailList.add(mail);
                }
                line = br.readLine();
            }

        } catch(Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                if(fr != null) fr.close();
                if(br != null) br.close();
            } catch(Exception ex) {
                System.out.println(ex.toString());
            }
        }

        return mailList;
    }

}