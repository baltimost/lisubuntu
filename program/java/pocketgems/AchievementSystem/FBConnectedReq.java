public class FBConnectedReq implements Requirement {
    private boolean isConnected;
    public boolean isSatisfied() {
        return isConnected;
    }

    public void setConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }
}
