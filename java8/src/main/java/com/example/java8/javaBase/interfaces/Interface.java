package com.example.java8.javaBase.interfaces;

public class Interface {

    interface AnInterface {
        void firstMethod();
        void secondMethod();
        /**新加一个default表示接口的默认实现*/
        default void newMethod() {
            System.out.println("newMethod");
        }
    }

    public static class InterfaceImpl implements AnInterface {

        public void firstMethod() {
            System.out.println("firstMethod");
        }

        public void secondMethod() {
            System.out.println("secondMethod");
        }
    }

    /**
     * firstMethod
     * secondMethod
     * newMethod
     */
    public static void main(String[] args) {
        AnInterface i = new InterfaceImpl();
        i.firstMethod();
        i.secondMethod();
        i.newMethod();
    }

}