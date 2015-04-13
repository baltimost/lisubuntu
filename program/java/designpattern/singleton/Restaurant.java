public class Restaurant {
    public static Restaurant instance = null;

    public static Restaurant getInstance() {
        if(instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }
/*    
    public Restaurant() {
        ;
    }
    */

    public static void main(String[] args) {
        Restaurant r = Restaurant.getInstance();
    }
}
