public class hello{
    public static void main(String[] args){
        Sender sender1 = Factory.produce("mail"); 
        sender1.send();
        sender1 = Factory.produce("sms"); 
        sender1.send();
    }
}

class Factory{
    //public static Sender produce(String type){
    public static Sender produce(){
        ;
    }
}

class SmsFactory extends Factory{
    public static Sender produce(){
        return new SmsSender();
    }
}

class MailFactory extends Factory{
    public static Sender produce(){
        return new MailSender();
    }
}

class Sender{
    public Sender(){
        System.out.println("Sender");
    }
    public void send(){
        System.out.println("-Sender:sending");
    }
}

class SmsSender extends Sender{
    public SmsSender(){
        System.out.println("SmsSender");
    }
    public void send(){
        System.out.println("-Sms:sending");
    }
}

class MailSender extends Sender{
    public MailSender(){
        System.out.println("MailSender");
    }
    public void send(){
        System.out.println("-Mail:sending");
    }
}
