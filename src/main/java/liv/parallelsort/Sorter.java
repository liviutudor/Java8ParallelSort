package liv.parallelsort;

/**
 * Just a simple interface for a sorting method.
 *
 * @author Liviu Tudor http://about.me/liviutudor
 */
public interface Sorter {
    /**
     * Sorts the given array in-place.
     *
     * @param arr
     *            Array to sort.
     */
    void sort(int[] arr);

    /**
     * Descriptive name to use in debug logging.
     *
     * @return name of the sorter
     */
    String getName();
}
