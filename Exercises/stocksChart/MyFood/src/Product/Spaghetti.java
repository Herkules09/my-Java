package Product;

import Person.ConsumingMan;
import Person.ProducingMan;

public class Spaghetti extends Food {
    public Spaghetti(String name, ProducingMan producingMan, ConsumingMan consumingMan) {
        super(name, consumingMan, producingMan);
    }
}
