
public class Car {
    // instance attributes
    int id;
    String model,year;
    
    //construtor
    public Car (int i, String m, String y)
    {
        this.id = i;
        this.model = m;
        this.year = y;
    }
    
    public Car (){}
    
    //method behavior
    public void changeGear(){
        System.out.println("a car can change gear");
    }
    
     public void applyBrake(){
        System.out.println("a car can apply brake");
    }
    // to return object's retail
     public String toString(){
         return "id = " + id + "\nModel = " + model + "\nYear = " + year;
  }
}