package com.example.java8.javaBase;

public class SandwihTest {
    static class Meal {
        Meal() {
            System.out.println("Meal()");
        }
    }

    static class Bread {
        Bread() {
            System.out.println("Bread()");
        }
    }

    static class Cheese {
        Cheese() {
            System.out.println("Cheese()");
        }
    }

    static class Lettuce {
        Lettuce() {
            System.out.println("Lettuce()");
        }
    }

    static class Lunch extends Meal {
        Lunch() {
            System.out.println("Lunch()");
        }
    }

    static class PortableLunch extends Lunch {
        PortableLunch() {
            System.out.println("PortableLunch()");
        }
    }

    public static class Sandwich extends PortableLunch {
        private Bread b = new Bread();
        private Cheese c = new Cheese();
        private Lettuce l = new Lettuce();

        public Sandwich() {
            System.out.println("Sandwich()");
        }

        public static void main(String[] args) {
            new Sandwich();
            /**
             * 打印顺序 因为Sandwich继承了PortableLunch
             * Meal()
             * Lunch()
             * PortableLunch()
             * Bread()
             * Cheese()
             * Lettuce()
             * Sandwich()
             */
        }
    }
}
