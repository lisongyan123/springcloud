package com.example.java8.javaBase.interfaces;

/**
 * 接口中带有静态方法
 */
public class Machine {

    interface Operations {
        void execute();

        static void runOps(Operations... ops) {
            for (Operations op: ops) {
                op.execute();
            }
        }

        static void show(String msg) {
            System.out.println(msg);
        }
    }

    static class Bing implements Operations {
        @Override
        public void execute() {
            Operations.show("Bing");
        }
    }

    static class Crack implements Operations {
        @Override
        public void execute() {
            Operations.show("Crack");
        }
    }

    static class Twist implements Operations {
        @Override
        public void execute() {
            Operations.show("Twist");
        }
    }

    /**
     * Bing
     * Crack
     * Twist
     */
    public static void main(String[] args) {
        Operations.runOps(new Bing(), new Crack(), new Twist());
    }
}