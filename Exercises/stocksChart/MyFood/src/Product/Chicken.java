package Product;

import Person.ConsumingMan;
import Person.ProducingMan;

public class Chicken extends Food {
    public Chicken(String name, ProducingMan producingMan, ConsumingMan consumingMan) {
        super(name, consumingMan, producingMan);
    }

}