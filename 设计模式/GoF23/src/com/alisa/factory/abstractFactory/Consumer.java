package com.alisa.factory.abstractFactory;

import com.alisa.factory.abstractFactory.Impl.Xiaomi.MiFactory;
import com.alisa.factory.abstractFactory.Impl.Xiaomi.MiPhone;
import com.alisa.factory.abstractFactory.product.Phone;

public class Consumer {
    public static void main(String[] args) {
        MiFactory miFactory=new MiFactory();
        Phone miPhone= miFactory.phoneProduct();
        miPhone.call();

    }
}
