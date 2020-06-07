package com.example.cloudservice.extra.designpattern.facade;

class Facade {
    private System1 system1 = new System1();
    private System2 system2 = new System2();
    private System3 system3 = new System3();
    public void method() {
        system1.method();
        system2.method();
        system3.method();
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }
}

class System1{
    public void method(){
        System.out.println("System1");
    }
}

class System2{
    public void method(){
        System.out.println("System2");
    }
}

class System3{
    public void method(){
        System.out.println("System3");
    }
}