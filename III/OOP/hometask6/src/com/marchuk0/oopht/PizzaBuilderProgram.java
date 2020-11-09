package com.marchuk0.oopht;

public class PizzaBuilderProgram {
    static class Pizza {
        String dough;
        String sauce;
        String topping;

        public Pizza() {
        }

        public void setDough(String d) {
            dough = d;
        }

        public void setSauce(String s) {
            sauce = s;
        }

        public void setTopping(String t) {
            topping = t;
        }

        public void info() {
            System.out.printf("Dough: %s\nSause: %s\nTopping: %s\n\n", dough, sauce, topping);
        }
    }

    //Abstract Builder
    static abstract class PizzaBuilder {
        protected Pizza pizza;

        public PizzaBuilder() {
        }

        public Pizza getPizza() {
            return pizza;
        }

        public void createNewPizza() {
            pizza = new Pizza();
        }

        public abstract void buildDough();

        public abstract void buildSauce();

        public abstract void buildTopping();
    }

    //Concrete Builder
    static class HawaiianPizzaBuilder extends PizzaBuilder {
        @Override
        public void buildDough() {
            pizza.setDough("cross");
        }

        @Override
        public void buildSauce() {
            pizza.setSauce("mild");
        }

        @Override
        public void buildTopping() {
            pizza.setTopping("ham+pineapple");
        }
    }

    //Concrete Builder
    static class SpicyPizzaBuilder extends PizzaBuilder {
        @Override
        public void buildDough() {
            pizza.setDough("pan baked");
        }

        @Override
        public void buildSauce() {
            pizza.setSauce("hot");
        }

        @Override
        public void buildTopping() {
            pizza.setTopping("pepparoni+salami");
        }
    }

    static class MargaritaPizzaBuilder extends PizzaBuilder {

        @Override
        public void buildDough() {
            pizza.setDough("margarita dough");
        }

        @Override
        public void buildSauce() {
            pizza.setSauce("margarita souce");
        }

        @Override
        public void buildTopping() {
            pizza.setTopping("margarita topping");
        }
    }

    /**
     * "Director"
     */
    static class Waiter {
        private PizzaBuilder pizzaBuilder;

        public void setPizzaBuilder(PizzaBuilder pb) {
            pizzaBuilder = pb;
        }

        public Pizza getPizza() {
            return pizzaBuilder.getPizza();
        }

        public void constructPizza() {
            pizzaBuilder.createNewPizza();
            pizzaBuilder.buildDough();
            pizzaBuilder.buildSauce();
            pizzaBuilder.buildTopping();
        }
    }

    /**
     * A customer ordering a pizza.
     */
    public static void main(String[] args) {
        Pizza pizza;

        Waiter waiter = new Waiter();
        PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

        waiter.setPizzaBuilder(hawaiianPizzaBuilder);
        waiter.constructPizza();
        pizza = waiter.getPizza();
        pizza.info();

        waiter.setPizzaBuilder(spicyPizzaBuilder);
        waiter.constructPizza();
        pizza = waiter.getPizza();
        pizza.info();

        waiter.setPizzaBuilder(new MargaritaPizzaBuilder());
        waiter.constructPizza();
        pizza = waiter.getPizza();
        pizza.info();

    }
}
