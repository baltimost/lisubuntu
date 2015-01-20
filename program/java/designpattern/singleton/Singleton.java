public class Singleton{
    //Eager initialization
    /*
    private static final Singleton instance = new Singleton();
    
    public static Singleton getInstance(){
        return instance;
    }
    */
    //Lazy initialization

    private static Singleton instance = null;
    
    public static Singleton getInstance(){
        if(instance == null)
            instance = new Singleton();
        return instance;
    }
    private Singleton(){
        try{Thread.sleep(5000);}
        catch (Exception e){
            ;
        }
    }
    public static void main(String[] args){
        System.out.println("main start");
        Singleton s = Singleton.getInstance();
        System.out.println("main end");
    }
}
