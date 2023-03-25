package Person;

import Product.Chicken;
import Product.Food;
import Product.Pasta;
import Product.Spaghetti;

public class Producer extends Person implements ProducingMan{

    public Producer(String name, String surname) {
        super(name, surname);
    }




    @Override
    public void consume(Food food) {
        System.out.println("Consumer is eating: "+ food);
    }

    @Override
    public String getExpectations() {
        return "no expectations";
    }

    @Override
    public Food produce(String productName,  ConsumingMan consumingMan) {
        switch(productName){
            case "Chicken":
                return new Chicken(productName,this,consumingMan);
            case "Spaghetti":
                return new Spaghetti(productName,this,consumingMan);
            default:
                return new Pasta(productName,this,consumingMan);


        }

    }

}
