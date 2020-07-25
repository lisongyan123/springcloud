package com.example.java8.javaBase.interfaces;

public class Factories {

    interface Service {
        void method1();
        void method2();
    }

    interface ServiceFactory {
        Service getService();
    }

    /**
     * 抽象类
     */
    static class Service1 implements Service {
        Service1() {System.out.println("Service1");} // Package access

        @Override
        public void method1() {
            System.out.println("Service1 method1");
        }

        @Override
        public void method2() {
            System.out.println("Service1 method2");
        }
    }

    static class Service2 implements Service {
        Service2() {System.out.println("Service2");} // Package access

        @Override
        public void method1() {
            System.out.println("Service2 method1");
        }

        @Override
        public void method2() {
            System.out.println("Service2 method2");
        }
    }

    /**
     * 工厂类
     */
    static class Service1Factory implements ServiceFactory {
        @Override
        public Service getService() {
            return new Service1();
        }
    }

    static class Service2Factory implements ServiceFactory {
        @Override
        public Service getService() {
            return new Service2();
        }
    }

    /**
     * 具体类
     * @param fact
     */
    public static void serviceConsumer(ServiceFactory fact) {
        Service s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Service1Factory());
        serviceConsumer(new Service2Factory());
    }
}
