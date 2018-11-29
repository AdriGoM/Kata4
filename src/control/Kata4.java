package control;

import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;

public class Kata4 {

    private List<Mail> list;
    private Histogram<String> histogram;

    public static void main(String[] args) {
        (new Kata4()).control();
    }

    private void control() {
        this.input();
        this.proccess();
        this.output();
    }

    private void input() {
        list = MailListReader.getInstance().read("/Users/adriangodoymartinez/IdeaProjects/Kata4/src/email.txt");
    }

    private void proccess() {
        histogram = MailHistogramBuilder.getInstance().build(list);
    }

    private void output() {
        HistogramDisplay display = new HistogramDisplay(histogram);
        display.execute();
    }

}