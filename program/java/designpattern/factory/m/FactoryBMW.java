interface FactoryBMW {  
    BMW createBMW();  
}  
  
public class FactoryBMW320 implements FactoryBMW{  
    @Override  
    public BMW320 createBMW() {  
        return new BMW320();  
    }  
}  
public class FactoryBMW523 implements FactoryBMW {  
    @Override  
    public BMW523 createBMW() {  
        return new BMW523();  
    }  
} 
