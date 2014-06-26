Java8ParallelSort
=================

This repo contains all the supporting code for my original blog post : http://liviutudor.com/2014/06/26/parallel-sorting-in-java-8/

The blog post looks at a speed comparison in between the original `Arrays.sort` and the new [parallelSort](http://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#parallelSort-int:A- "Arrays.parallelSort") introduced in Java 8.

Follow the link above to get more details regarding the speed comparison.


Running the code
----------------

There are 2 ways of running the code:

* via the executable jar (`java -jar`)
* via maven

I've also created a shell script (`run.sh`) which runs the compilation and executes the test.


Notes
-----

* The code relies on my other library for reading integer files -- code on GitHub too here: https://github.com/liviutudor/RandomIntFile ; note that you will need version 1.1 of this or abobe.
* The project embeds a few test files against which it runs the tests -- feel free to generate other files (I've used my `RandomIntFile` project mentioned above for it) and run your own tests.
* Example of output:

	standard -- 100.txt
	average	 =   32884.00 ns 	=       0.03 ms
	95 perc	 =    2000.00 ns 	=       0.00 ms
	stddev	 =  252204.87 ns 	=       0.25 ms

	standard -- 1000.txt
	average	 =   51187.00 ns 	=       0.05 ms
	95 perc	 =   34000.00 ns 	=       0.03 ms
	stddev	 =   13396.85 ns 	=       0.01 ms

	standard -- 10000.txt
	average	 =  611770.00 ns 	=       0.61 ms
	95 perc	 =  540000.00 ns 	=       0.54 ms
	stddev	 =  114533.55 ns 	=       0.11 ms

	standard -- 100000.txt
	average	 = 7635874.00 ns 	=       7.64 ms
	95 perc	 = 6968509.50 ns 	=       6.97 ms
	stddev	 =  949718.02 ns 	=       0.95 ms

	standard -- 1000000.txt
	average	 = 89002092.00 ns 	=      89.00 ms
	95 perc	 = 83446019.00 ns 	=      83.45 ms
	stddev	 = 6321875.10 ns 	=       6.32 ms

	parallel -- 100.txt
	average	 =    4067.00 ns 	=       0.00 ms
	95 perc	 =    2000.00 ns 	=       0.00 ms
	stddev	 =   19583.05 ns 	=       0.02 ms

	parallel -- 1000.txt
	average	 =   47775.00 ns 	=       0.05 ms
	95 perc	 =   33000.00 ns 	=       0.03 ms
	stddev	 =   14184.91 ns 	=       0.01 ms

	parallel -- 10000.txt
	average	 =  530962.00 ns 	=       0.53 ms
	95 perc	 =  343019.00 ns 	=       0.34 ms
	stddev	 = 3654827.07 ns 	=       3.65 ms

	parallel -- 100000.txt
	average	 = 4205239.00 ns 	=       4.21 ms
	95 perc	 = 3582509.50 ns 	=       3.58 ms
	stddev	 =  681404.40 ns 	=       0.68 ms

	parallel -- 1000000.txt
	average	 = 43857086.00 ns 	=      43.86 ms
	95 perc	 = 41049076.00 ns 	=      41.05 ms
	stddev	 = 3027405.87 ns 	=       3.03 ms

* More details in the code or in my blog post: http://liviutudor.com/2014/06/26/parallel-sorting-in-java-8/
