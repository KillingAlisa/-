package com.alisa.factory.abstractFactory.Impl.Xiaomi;

import com.alisa.factory.abstractFactory.product.Factory;
import com.alisa.factory.abstractFactory.product.Phone;
import com.alisa.factory.abstractFactory.product.Router;

public class MiFactory implements Factory {
    @Override
    public Phone phoneProduct() {
        return new MiPhone();
    }

    @Override
    public Router routerProduct() {
        return new MiRouter();
    }
}
