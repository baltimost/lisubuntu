import java.util.*;

public class Achievement {
    String name;
    List<Requirement> requirements;

    public Achievement(String name) {
        this.name = name;
    }
    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    public String getName() {
        return name;
    } 

    public boolean isSatisfied() {
        for(Requirement r : requirements) {
            if(!r.isSatisfied()) {
                return false;
            }
        }
        return true;
    }
}
