package Person;


import Product.Food;



public class Consumer extends Person{

   private final String expectations;

    public Consumer(String name, String surname, String expectations) {
        super(name, surname);
        this.expectations = expectations;
    }

    @Override
    public void consume(Food food) {
        System.out.println("Consumer consuming : " + food);
    }

    @Override
    public String getExpectations() {
        return "My expectations is:";
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "expectations='" + expectations + '\'' +
                '}';
    }
}
