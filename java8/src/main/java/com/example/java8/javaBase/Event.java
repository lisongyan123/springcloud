package com.example.java8.javaBase;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public abstract class Event {
    private Instant eventTime;
    protected final Duration delayTime;
    public Event(long millisecondDelay) {
        delayTime = Duration.ofMillis(millisecondDelay);
        start();
    }
    public void start() { // Allows restarting
        eventTime = Instant.now().plus(delayTime);
    }
    public boolean ready() {
        return Instant.now().isAfter(eventTime);
    }
    public abstract void action();

    static class Controller {
        // A class from java.util to hold Event objects:
        private List<Event> eventList = new ArrayList<>();
        public void addEvent(Event c) { eventList.add(c); }
        public void run() {
            while(eventList.size() > 0)
                // Make a copy so you're not modifying the list
                // while you're selecting the elements in it:
                for(Event e : new ArrayList<>(eventList))
                    if(e.ready()) {
                        System.out.println(e);
                        e.action();
                        eventList.remove(e);
                    }
        }
    }

    public static class GreenhouseControls extends Controller {
        private boolean light = false;
        public class LightOn extends Event {
            public LightOn(long delayTime) {
                super(delayTime);
            }
            @Override
            public void action() {
                light = true;
            }
            @Override
            public String toString() {
                return "Light is on";
            }
        }

        public class LightOff extends Event {
            public LightOff(long delayTime) {
                super(delayTime);
            }
            @Override
            public void action() {
                light = false;
            }
            @Override
            public String toString() {
                return "Light is off";
            }
        }

        private boolean water = false;
        public class WaterOn extends Event {
            public WaterOn(long delayTime) {
                super(delayTime);
            }
            @Override
            public void action() {
                water = true;
            }
            @Override
            public String toString() {
                return "Greenhouse water is on";
            }
        }

        public class WaterOff extends Event {
            public WaterOff(long delayTime) {
                super(delayTime);
            }
            @Override
            public void action() {
                water = false;
            }
            @Override
            public String toString() {
                return "Greenhouse water is off";
            }
        }

        private String thermostat = "Day";
        public class ThermostatNight extends Event {
            public ThermostatNight(long delayTime) {
                super(delayTime);
            }
            @Override
            public void action() {
                thermostat = "Night";
            }
            @Override
            public String toString() {
                return "Thermostat on night setting";
            }
        }

        public class ThermostatDay extends Event {
            public ThermostatDay(long delayTime) {
                super(delayTime);
            }
            @Override
            public void action() {
                thermostat = "Day";
            }
            @Override
            public String toString() {
                return "Thermostat on day setting";
            }
        }

        public class Bell extends Event {
            public Bell(long delayTime) {
                super(delayTime);
            }
            @Override
            public void action() {
                addEvent(new Bell(delayTime.toMillis()));
            }
            @Override
            public String toString() {
                return "Bing!";
            }
        }

        public class Restart extends Event {
            private Event[] eventList;
            public Restart(long delayTime, Event[] eventList) {
                super(delayTime);
                this.eventList = eventList;
                for(Event e : eventList)
                    addEvent(e);
            }
            @Override
            public void action() {
                for(Event e : eventList) {
                    e.start(); // Rerun each event
                    addEvent(e);
                }
                start(); // Rerun this Event
                addEvent(this);
            }
            @Override
            public String toString() {
                return "Restarting system";
            }
        }

        public static class Terminate extends Event {
            public Terminate(long delayTime) {
                super(delayTime);
            }
            @Override
            public void action() { System.exit(0); }
            @Override
            public String toString() {
                return "Terminating";
            }
        }
    }

    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        gc.addEvent(new GreenhouseControls.Terminate(5000));
        gc.run();
    }
}

