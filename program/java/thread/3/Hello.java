public class Hello{
    public Hello(int name){
        System.out.println("Hello Construct " + name);
    }
    public static void main(String[] args){
        Hello he1 = new Hello(1);
        Hello he2 = new Hello(2);

        //Halo ha1 = new Halo("3");
    }
}

class Halo extends Hello{
    /*
    public Halo(String name){
        super(name);
    }
    */
    public void print(){
        ;
    }
}
