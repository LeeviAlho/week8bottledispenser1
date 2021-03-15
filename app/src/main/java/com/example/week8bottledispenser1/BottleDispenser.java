package com.example.week8bottledispenser1;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Scanner;

public class BottleDispenser {
    private int bottlecount;

    private static BottleDispenser dispenser = new BottleDispenser();

    public static BottleDispenser getInstance() {
        return dispenser;
    }


    private double money;
    ArrayList<Bottle> bottles = new ArrayList();
    //Bottle abottle = new Bottle();

    public String listBottles() {
        int i = 0;
        String text = "";
        for (Bottle a : bottles) {
            text = text + (i + 1 +". Name: " + bottles.get(i).getName()) + "\n";
            text = text + ("	Size: " + bottles.get(i).getSize() + "	Price: " + bottles.get(i).getPrice()) + "\n";
            i++;
        }
        return text;
    }

    private BottleDispenser() {
        bottlecount = 5;
        money = 0.0d;
        for (int i = 0; i < bottlecount; i++){
            Bottle temp = new Bottle();
            if (i % 2 == 1) {
                temp.setSize(1.5);
            }
            if (i == 2 || i == 3) {
                temp.setName("Coca-Cola Zero");
            } else if (i == 4 || i == 5) {
                temp.setName("Fanta Zero");
            }
            switch (i){
                case 1:
                    temp.setPrice(2.2);
                    break;
                case 2:
                    temp.setPrice(2.0);
                    break;
                case 3:
                    temp.setPrice(2.5);
                    break;
                case 4:
                    temp.setPrice(1.95);
                    break;
                case 0:
                    break;
            }
            bottles.add(temp);
        }
    }

    public String getMoney(){
        DecimalFormat df = new DecimalFormat("#0.00");
        DecimalFormatSymbols sym = DecimalFormatSymbols.getInstance();
        sym.setDecimalSeparator(',');
        df.setDecimalFormatSymbols(sym);
        return(df.format(money));
    }

    public String addMoney() {
        money += 1;
        return("Klink! Added more money!");
    }

    private int selectDrink(String s){
        int index = -1;
        try {
            index = Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            System.out.println("Choose a number");
        }
        return (index - 1);
    }

    public String buyBottle() {

        try {
            if (bottles.size() > 0 & money >= bottles.get(0).getPrice()){
                money -= bottles.get(0).getPrice();
                bottlecount -= 1;

                String text = ("KACHUNK! " + bottles.get(0).getName() + " came out of the dispenser!");
                bottles.remove(0);
                return(text);
            } else if (bottles.size() > 0 & money < bottles.get(0).getPrice()) {
                return("Add money first!");
            }
        } catch (IndexOutOfBoundsException e) {
            return("No more bottles left");
        }
        return("Something broke");
    }

    public String returnMoney() {
        DecimalFormat df = new DecimalFormat("#0.00");
        DecimalFormatSymbols sym = DecimalFormatSymbols.getInstance();
        sym.setDecimalSeparator(',');
        df.setDecimalFormatSymbols(sym);
        return("Klink klink. Money came out! You got " + df.format(money) + "€ back");

    }



}
