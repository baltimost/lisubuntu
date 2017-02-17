public class CoinReq implements Requirement {
    private int threshold, count;
    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public boolean isSatisfied() {
        return count >= threshold;
    }
}
