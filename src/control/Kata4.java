package control;

import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;

public class Kata4 {

    public static void main(String[] args) {
        List<Mail> list = MailListReader.getInstance().read("/Users/adriangodoymartinez/IdeaProjects/Kata4/src/email.txt");
        Histogram<String> histogram = MailHistogramBuilder.getInstance().build(list);
        HistogramDisplay display = new HistogramDisplay(histogram);
        display.execute();
    }

}