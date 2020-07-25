package com.example.java8.javaBase.interfaces;

public class HorrorShow {

    interface Monster {
        void menace();
    }

    interface Lethal {
        void kill();
    }

    interface DangerousMonster extends Monster {
        void destroy();
    }

    interface Vampire extends DangerousMonster, Lethal {
        void drinkBlood();
    }

    static class DragonZilla implements DangerousMonster {
        @Override
        public void menace() {System.out.println("DragonZilla : menace");}

        @Override
        public void destroy() {System.out.println("DragonZilla : destroy");}
    }

    static class VeryBadVampire implements Vampire {
        @Override
        public void menace() {System.out.println("VeryBadVampire : menace");}

        @Override
        public void destroy() {System.out.println("VeryBadVampire : destroy");}

        @Override
        public void kill() {System.out.println("VeryBadVampire : kill");}

        @Override
        public void drinkBlood() {System.out.println("VeryBadVampire : drinkBlood");}
    }

    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }

    public static void main(String[] args) {
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}

