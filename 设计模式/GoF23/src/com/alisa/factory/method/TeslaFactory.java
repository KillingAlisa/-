package com.alisa.factory.method;

import com.alisa.Object.car.Car;
import com.alisa.Object.car.Tesla;

public class TeslaFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
