public class ExceptionLearning {
    public static void main(String[] args) throws Exception {
        try{
            System.out.println("before");
            exceptionMaker();   
            System.out.println("after");
        }
        /*
        catch(MyException e) {
            System.out.println("1");
            System.out.println(e.getMessage());
            return;
        }
        finally {
            System.out.println("finally");
            
        }*/
        System.out.println("outside");
    }
    
    public static void exceptionMaker() throws Exception {
        throw new MyException();
    }
}

class MyException extends Exception {
    public String getMessage() {
        return "MyException";   
    }
}