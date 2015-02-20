import java.util.concurrent.ThreadLocalRandom;

class SwapTest implements Runnable {
    private int nTransitions;
    private State state;

    SwapTest(int n, State s) {
	nTransitions = n;
	state = s;
    }

    public void run() {
	int n = state.size();
	if (n != 0)
	    for (int i = 0; i < nTransitions; ) {
	    //generate two random indices
		int a = ThreadLocalRandom.current().nextInt(0, n);
		int b = ThreadLocalRandom.current().nextInt(0, n - 1);
		if (a == b)
		    b = n - 1;
		//potential issue here
		if (state.swap(a, b))
		    i++;
	    }
    }
}
