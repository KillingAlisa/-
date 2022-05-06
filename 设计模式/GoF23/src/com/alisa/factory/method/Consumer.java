package com.alisa.factory.method;

import com.alisa.Object.car.Car;

public class Consumer {
    public static void main(String[] args) {
        Car car1=new TeslaFactory().getCar();

        car1.name();
    }
}
