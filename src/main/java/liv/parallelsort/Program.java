package liv.parallelsort;

import java.io.IOException;

import liv.randomfile.RandomIntReader;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 * Runs the comparison of sorting.
 *
 * @author Liviu Tudor http://about.me/liviutudor
 */
public class Program {
    /** Name of the files to sort (included in the jar). */
    public static final String[] FILES   = new String[] {"100.txt", "1000.txt", "10000.txt", "100000.txt",
            "1000000.txt"                };

    /** Attempt each sorting so many times. */
    public static final int      N_TRIES = 1000;

    /** Sorting methods used. */
    private Sorter[]             sorting = new Sorter[] {new StandardSorter(), new ParallelSorter()};

    /**
     * Program entry point.
     *
     * @param args
     *            Command-line parameters. Ignored.
     */
    public static void main(String args[]) {
        Program p = new Program();
        try {
            p.run();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void printNanos(String ms, double nanos) {
        System.out.println(ms + "\t = " + String.format("%1$10.2f", nanos) + " ns \t= "
                + String.format("%1$10.2f", (nanos / 1000000)) + " ms");
    }

    public void run() throws IOException {
        StopWatch timer = new StopWatch();
        double timing[] = new double[N_TRIES];
        for (Sorter s : sorting) {
            for (String f : FILES) {
                for (int i = 0; i < N_TRIES; i++) {
                    RandomIntReader reader = new RandomIntReader(Program.class.getResourceAsStream("/" + f));
                    reader.read();
                    timer.reset();
                    timer.start();
                    s.sort(reader.getArray());
                    timer.stop();
                    timing[i] = timer.getNanoTime();
                    // cleanup
                    /*
                     * System.gc(); try { TimeUnit.SECONDS.sleep(2); } catch
                     * (InterruptedException e) { // nothing }
                     */
                }
                // now compute stats
                DescriptiveStatistics stats = new DescriptiveStatistics(timing);
                System.out.println("\n" + s.getName() + " -- " + f);
                printNanos("average", stats.getMean());
                printNanos("95 perc", stats.getPercentile(0.95));
                printNanos("stddev", stats.getStandardDeviation());
            }
        }
    }
}
