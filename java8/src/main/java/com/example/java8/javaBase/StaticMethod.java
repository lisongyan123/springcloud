package com.example.java8.javaBase;

/**
 * 静态代码块内容先执行（父先后子），接着执行父类非静态代码块和构造方法，然后执行子类非静态代码块和构造方法。
 * 静态变量和静态代码块的初始化顺序：谁在前面先初始化谁。
 * 子类的构造方法，不管这个构造方法带不带参数，默认的它都会先去寻找父类的不带参数的构造方法。父类构造带参 子类必须用super调用
 */
public class StaticMethod {

    static class Insect {
        private int i = 9;
        protected int j;

        Insect() {
            System.out.println("i = " + i + ", j = " + j);
            j = 39;
        }

        private static int x1 = printInit("static Insect.x1 initialized");

        static int printInit(String s) {
            System.out.println(s);
            return 47;
        }
    }

    static class Beetle extends Insect {

        public Beetle() {
            System.out.println("k = " + k);
            System.out.println("j = " + j);
        }

        private int k = printInit("Beetle.k.initialized");

        private static int x2 = printInit("static Beetle.x2 initialized");

        public static void main(String[] args) {
            /**
             * 先加载父类的静态类
             * static Insect.x1 initialized
             * static Beetle.x2 initialized
             * Beetle constructor
             * i = 9, j = 0
             * Beetle.k.initialized
             * k = 47
             * j = 39
             */
            System.out.println("Beetle constructor");
            Beetle b = new Beetle();
        }
    }
}