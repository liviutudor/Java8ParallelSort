package liv.parallelsort;

import java.util.Arrays;

/**
 * Uses the standard <code>Arrays.sort()</code>.
 *
 * @author Liviu Tudor http://about.me/liviutudor
 */
public class StandardSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        Arrays.sort(arr);
    }

    @Override
    public String getName() {
        return "standard";
    }
}
