import java.util.*;

public class Game {
    public static void main(String[] args) {
        Player xuli = new Player("xuli", 1);
        FBConnectedReq fb = new FBConnectedReq();
        fb.setConnected(true);
        CoinReq coin = new CoinReq();
        coin.setThreshold(30);
        coin.setCount(50);
        ArrayList<Requirement> requirements = new ArrayList<Requirement>();
        requirements.add(fb);
        requirements.add(coin);

        Achievement tycoon = new Achievement("tycoon");
        tycoon.setRequirements(requirements);

        xuli.setRequirements(requirements);
        LinkedList<Achievement> achievements = new LinkedList<Achievement>();
        achievements.add(tycoon);
        xuli.setAchievements(achievements);

        List<Achievement> achieved = xuli.getAchievements();

        for(Achievement a : achieved) {
            System.out.println(a.getName());
        }
    }
}
