package com.educate;

import java.util.List;

//Який принцип S.O.L.I.D. порушено? Виправте!
//Single responsibility principle is violated
// class order should be refactored to classes that are responsible for OrderEntity, OrderService, etc.
class Item {

}

class Order {
    private List<Item> itemList;

    List<Item> getItemList() {
        return itemList;
    }

    void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void calculateTotalSum() {/*...*/}

    public void getItems() {/*...*/}

    public void getItemCount() {/*...*/}

    public void addItem(Item item) {/*...*/}

    public void deleteItem(Item item) {/*...*/}
}

class OrderPrinter {
    public void printOrder() {/*...*/}

}
class OrderUI {
    public void showOrder() {/*...*/}

}
class OrderService {
    public void load() {/*...*/}

    public void save() {/*...*/}

    public void update() {/*...*/}

    public void delete() {/*...*/}
}

public class Solid1 {
}


