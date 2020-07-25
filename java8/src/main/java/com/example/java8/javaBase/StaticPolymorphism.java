package com.example.java8.javaBase;

public class StaticPolymorphism {
    public static void main(String[] args) {
        /**
         * 静态的方法不具备多态性  即使被继承也不存在重写关系
         * Base staticGet()
         * Derived dynamicGet()
         */
        StaticSuper sup = new StaticSub(); // Upcast
        System.out.println(StaticSuper.staticGet());
        System.out.println(sup.dynamicGet());
    }

    static class StaticSuper {
        public static String staticGet() {
            return "Base staticGet()";
        }

        public String dynamicGet() {
            return "Base dynamicGet()";
        }
    }

    static class StaticSub extends StaticSuper {
        public static String staticGet() {
            return "Derived staticGet()";
        }
        @Override
        public String dynamicGet() {
            return "Derived dynamicGet()";
        }
    }
}
