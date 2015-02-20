import java.util.concurrent.atomic.AtomicIntegerArray;

class BetterSorry implements State {

    //GetNset is supposed to use get and set methods in java.util.concurrent.atomic.AtomicIntegerArray
    //create a AtomicIntegerArray first
    private volatile AtomicIntegerArray value;
    private byte maxval;

    BetterSorry(byte[] v) { 
        int[] vi = new int[v.length];
        for (int i = 0; i < v.length; i++)
            vi[i] = v[i];
        value = new AtomicIntegerArray(vi);
        maxval = 127; }

    BetterSorry(byte[] v, byte m) { 
        int[] vi = new int[v.length];
        for (int i = 0; i < v.length; i++)
            vi[i] = v[i];
        value = new AtomicIntegerArray(vi); 
        maxval = m; }

    public int size() { return value.length(); }

    public byte[] current() { 
        byte[] b = new byte[value.length()];
        for (int i = 0; i < value.length(); i++)
            b[i] = (byte) value.get(i);

        return b; 
    }

    public boolean swap(int i, int j) {
  if (value.get(i) <= 0 || value.get(j) >= maxval) {
      return false;
  }

    //use get and set

    value.getAndDecrement(i);
    value.getAndIncrement(j);
    // value.set(i, value.get(i)-1);
    // value.set(j, value.get(j)+1);

  return true;
    }
}
