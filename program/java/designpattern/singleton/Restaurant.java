public class Restaurant{
    private String name;
    public Restaurant(String name) { this.name = name;}
    public String getName() { return name;}
    

    public static void main(String[] args){
        Restaurant r = new Restaurant("Orient Express");
        System.out.println(r.getName());
    }
}

