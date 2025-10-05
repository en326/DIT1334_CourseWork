
public class carDemo {
    public static void main(String[] args){
        //creating car object
        Car c1 = new Car(); //default construtor
        Car c2 = new Car(2,"honda","2025");    
        
        //display the object
        System.out.println(c1.toString());
        c1.applyBrake();
        c1.changeGear();
        
        System.out.println(c2.toString());
        c2.applyBrake();
        c2.changeGear();
        
    }
    
}
