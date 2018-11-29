package view;
import java.util.List;
import model.Histogram;
import model.Mail;
public class MailHistogramBuilder {

    private MailHistogramBuilder() {}

    private static class BuilderHolder {
        private static final MailHistogramBuilder instance = new MailHistogramBuilder();
    }

    public static MailHistogramBuilder getInstance() {
        return BuilderHolder.instance;
    }

    public Histogram<String> build(List<Mail> mailList) {
        Histogram<String> histogram = new Histogram<>();
        mailList.forEach((mail) -> {
            histogram.increment(mail.getDomain());
        });
        return histogram;
    }
}