package com.example.java8.javaBase;

public class Transmogrify {

    static class Actor {
        public void act() {}
    }

    static class HappyActor extends Actor {
        @Override
        public void act() {
            System.out.println("HappyActor");
        }
    }

    static class SadActor extends Actor {
        @Override
        public void act() {
            System.out.println("SadActor");
        }
    }

    static class Stage {
        private Actor actor = new HappyActor();

        public void change() {
            actor = new SadActor();
        }

        public void performPlay() {
            actor.act();
        }
    }

    public static void main(String[] args) {
        /**
         * 返回值
         * HappyActor
         * SadActor
         */
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}