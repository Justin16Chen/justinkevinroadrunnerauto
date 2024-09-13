public class TickChecker {
    public int max;
    public int cur;
    public TickChecker(int maxTicks) {
        max = maxTicks;
        cur = 0;
    }
    public boolean valid() {
        if(cur < max) {
            return true;
            cur++;
        }
        return false;
    }
}