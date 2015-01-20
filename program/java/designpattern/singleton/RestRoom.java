public class RestRoom{
    private String name;
    private RestRoom(String name) { this.name = name;}
    public String getName() { return name;}

    private static RestRoom restroom;

    public static RestRoom getInstance(String name){
        if(restroom == null)
            restroom = new RestRoom(name);
        return restroom;
    }
}

