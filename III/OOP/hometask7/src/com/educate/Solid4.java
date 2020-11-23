package com.educate;
/*Даний інтерфейс поганий тим, що він включає занадто багато методів.
 А що, якщо наш клас товарів не може мати знижок або промокодом, або для нього немає сенсу встановлювати матеріал з
 якого зроблений (наприклад, для книг). Таким чином, щоб не реалізовувати в кожному класі невикористовувані в ньому методи, краще
розбити інтерфейс на кілька дрібних і кожним конкретним класом реалізовувати потрібні інтерфейси.
Перепишіть, розбивши інтерфейс на декілька інтерфейсів, керуючись принципом розділення інтерфейсу.
Опишіть класи книжки (розмір та колір не потрібні, але потрібна ціна та знижки) та верхній одяг (колір, розмір, ціна знижка),
які реалізують притаманні їм інтерфейси.*/

interface PriceItemInterface {
    void setPrice(double price);
}

interface ColorSizeInterface {
    void setColor(byte color);
    void setSize(byte size);
}

interface PriceReductionInterface
{
    void applyDiscount(String discount);
    void applyPromocode(String promocode);
}
class Book implements PriceItemInterface, PriceReductionInterface {

    @Override
    public void setPrice(double price) {

    }

    @Override
    public void applyDiscount(String discount) {

    }

    @Override
    public void applyPromocode(String promocode) {

    }
}

class Cloth implements PriceReductionInterface, ColorSizeInterface, PriceItemInterface {

    @Override
    public void setPrice(double price) {

    }

    @Override
    public void setColor(byte color) {

    }

    @Override
    public void setSize(byte size) {

    }

    @Override
    public void applyDiscount(String discount) {

    }

    @Override
    public void applyPromocode(String promocode) {

    }
}

class Program
{
    static void main(String[] args)
    {

    }
}