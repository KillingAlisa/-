package com.alisa.factory.simple;

import com.alisa.Object.car.Car;
import com.alisa.Object.car.Porsche;
import com.alisa.Object.car.Tesla;

public class Consumer {
    public static void main(String[] args) {
        // 不需要自己造车，我们从工厂拿到车
        Car car1=new Tesla();
        Car car2=new Porsche();

        car1=CarFactory.getCar("Tesla");

        car1.name();
        car2.name();
    }
}
