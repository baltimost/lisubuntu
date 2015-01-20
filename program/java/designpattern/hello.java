public class hello{
    public static void main(String[] args){
        RestRoom r = RestRoom.getInstance("JHU"); 
        System.out.println(r.getName());
    }
}
