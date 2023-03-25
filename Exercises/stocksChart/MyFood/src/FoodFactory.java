import Person.Consumer;
import Person.ConsumingMan;
import Person.Producer;
import Person.ProducingMan;
import Product.Food;

import java.util.Arrays;

public class FoodFactory {


    public static void main(String[] args) {

        FoodFactory foodFactory = new FoodFactory();
        foodFactory.run();
    }

    private void run() {
        ProducingMan[] ProducingPeople = new ProducingMan[]{
                new Producer("Adam", "Smakosz"),
                new Producer("Mateusz", "Kulinarny"),
                new Producer("Monika", "Kuchenna")
        };
        ConsumingMan[] ConsumingPeople = new ConsumingMan[]{
                new Consumer("Florian", "Delicja","no expensive"),
                new Consumer("Ewelina", "Janocka","delicious"),
                new Consumer("Tomek", "Atomek","big portion")
        };
        int counter = 0;
        for (ProducingMan ProducingPerson : ProducingPeople) {
            for (ConsumingMan ConsumingPerson : ConsumingPeople) {
                Food food = ProducingPerson.produce("Pizza", ConsumingPerson);
                counter++;
            }
        }
        Food[] foods = new Food[counter];

        int index = 0;
        for (ProducingMan ProducingPerson : ProducingPeople) {
            for (ConsumingMan ConsumingPerson : ConsumingPeople) {
                Food food = ProducingPerson.produce(ConsumingPerson.getExpectations(), ConsumingPerson);
                foods[index] = food;
                index++;

            }

        }

        System.out.println("PRINTING FOOD: ");

        for (Food food : foods) {
            System.out.println(food);
        }
    }

}
