package liv.parallelsort;

import java.util.Arrays;

/**
 * Uses the Java 8 <code>Arrays.parallelSort()</code>.
 *
 * @author Liviu Tudor http://about.me/liviutudor
 */
public class ParallelSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        Arrays.parallelSort(arr);
    }

    @Override
    public String getName() {
        return "parallel";
    }
}
