import java.util.concurrent.locks.ReentrantLock;

class BetterSafe implements State {
    private final ReentrantLock lock;
    private byte[] value;
    private byte maxval;

    BetterSafe(byte[] v) { value = v; maxval = 127; lock = new ReentrantLock();}

    BetterSafe(byte[] v, byte m) { value = v; maxval = m; lock = new ReentrantLock(); }

    public int size() { return value.length; }

    public byte[] current() { return value; }

    public boolean swap(int i, int j) {
       lock.lock();
	   try {
             if (value[i] <= 0 || value[j] >= maxval) 
             {
	           return false;
	         }
	         value[i]--;
	         value[j]++;
	         return true;
        } finally {
        lock.unlock();
      }
    }
}
