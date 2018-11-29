package view;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
public class HistogramDisplay extends ApplicationFrame {

    private final Histogram<String> histogram;

    public HistogramDisplay(Histogram<String> histogram) {
        super("Histograma");

        this.histogram = histogram;

        this.setContentPane(this.createPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    private JPanel createPanel() {
        JPanel panel = new ChartPanel(createChart(createDataset()));
        panel.setPreferredSize(new Dimension(500,400));
        return panel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        return ChartFactory.createBarChart("Histograma JFreeChart",
                "Dominios email",
                "Nº emails",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                rootPaneCheckingEnabled);
    }

    private DefaultCategoryDataset createDataset() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        histogram.keySet().forEach((key) -> {
            dataset.addValue(histogram.get(key), "", key);
        });
        return dataset;
    }

    public void execute() {
        this.setVisible(true);
    }
}