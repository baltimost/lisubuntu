import java.util.*;

public class Player {
    private String name;
    private int id;
    private List<Achievement> achieved, left;
    private List<Requirement> requirements;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        achieved = new LinkedList<Achievement>();
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }
    public void setAchievements(List<Achievement> achievements) {
        this.left = achievements;
    }
    public List<Achievement> getAchievements() {
        for(int i = 0;i < left.size();) {
            if(left.get(i).isSatisfied()) {
                achieved.add(left.get(i));
                left.remove(i);
            }
            else {
                break;
            }
        }
        return achieved;
    }
}
