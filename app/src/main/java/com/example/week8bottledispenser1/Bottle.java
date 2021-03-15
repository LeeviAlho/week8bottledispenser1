package com.example.week8bottledispenser1;

public class Bottle {

    private String name;
    private String manufacturer;
    private double total_energy;
    private double size;
    private double price;

    public Bottle(){
        name = "Pepsi Max";
        manufacturer = "Pepsi";
        total_energy = 0.3d;
        size = 0.5d;
        price = 1.80d;
    }
    public Bottle(String nameOfBottle, String manuf, float totE, float volume, float cost){
        name = nameOfBottle;
        manufacturer = manuf;
        total_energy = totE;
        size = volume;
        price = cost;

    }
    public String getName(){
        return (name);
    }
    public String getManufacturer(){
        return (manufacturer);
    }
    public double getEnergy(){
        return (total_energy);
    }
    public double getSize(){
        return (size);
    }
    public double getPrice(){
        return (price);
    }

    public void setName(String s){
        name = s;
    }
    public void setManufacturer(String s){
        manufacturer = s;
    }
    public void setEnergy(double d){
        total_energy = d;
    }
    public void setSize(double d){
        size = d;
    }
    public void setPrice(double d){
        price = d;
    }

}
