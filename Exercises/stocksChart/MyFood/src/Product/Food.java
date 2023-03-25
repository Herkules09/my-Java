package Product;

import Person.ConsumingMan;
import Person.ProducingMan;

public abstract class Food  {

    private final String name;

    private final ConsumingMan ConsumingMan;

    private final ProducingMan ProducingMan;

      public  Food(String name, ConsumingMan ConsumingMan, ProducingMan ProducingMan){
         this.name = name;
         this.ConsumingMan = ConsumingMan;
         this.ProducingMan = ProducingMan;
     }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", consumingMan=" + ConsumingMan +
                ", producingMan=" + ProducingMan +
                '}';
    }
}
