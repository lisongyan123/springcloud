package com.example.java8.javaBase.enums;

/**
 * 枚举实例天生就具备整数值的次序，
 * 可以在 switch 语句中使用 enum。
 */
public class TrafficLight {

    enum Signal { GREEN, YELLOW, RED, }

    Signal color = Signal.RED;
    public void change() {
        switch(color) {
            // Note you don't have to say Signal.RED
            // in the case statement:
            case RED: color = Signal.GREEN;
                break;
            case GREEN: color = Signal.YELLOW;
                break;
            case YELLOW: color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }

    /**
     * The traffic light is RED
     * The traffic light is GREEN
     * The traffic light is YELLOW
     * The traffic light is RED
     * The traffic light is GREEN
     * The traffic light is YELLOW
     * The traffic light is RED
     */
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for(int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}