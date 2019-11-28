package com.dp.Facade;

interface MobileShop {
    public void modelNo();
    public void price();
}

class Iphone implements MobileShop {
    @Override
    public void modelNo() {
        System.out.println(" Iphone 6 ");
    }
    @Override
    public void price() {
        System.out.println(" Rs 65000.00 ");
    }
}

class Blackberry implements MobileShop {
    @Override
    public void modelNo() {
        System.out.println(" Blackberry Z10 ");
    }
    @Override
    public void price() {
        System.out.println(" Rs 55000.00 ");
    }
}

class ShopKeeper {
    private MobileShop iphone;
    private MobileShop blackberry;

    public ShopKeeper(){
        iphone= new Iphone();
        blackberry=new Blackberry();
    }

    public void iphoneSale(){
        iphone.modelNo();
        iphone.price();
    }

    public void blackberrySale(){
        blackberry.modelNo();
        blackberry.price();
    }

    void getAllPhoneDetails() {
        iphoneSale();
        blackberrySale();
    }
}

public class Main {
    public static void main(String args[]){
        ShopKeeper sk = new ShopKeeper();
        sk.iphoneSale();
        sk.getAllPhoneDetails();
    }
}
