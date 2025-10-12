
package Inheritance;

public class AnimalDemo {
    public static void main(String[] args){
        //creating objects
        Animal t1 = new Animal();
        Cat c1 = new Cat();
        Dog d1 = new Dog();
        
        t1.id = 1;
        t1.color = "black";
        
        c1.id = 2;
        c1.color = "white";
        c1.breed = "british short hair";
        
        d1.id = 3;
        d1.color = "black";
        
        System.out.println("\nTiger");
        System.out.println(t1.toString());
    }
    
}
