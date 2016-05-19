package com.example.sony.customtoast;

/**
 * Created by SONY on 11-02-2016.
 */
public class Menu {
    int order;
    String salad;
    String sabji;
    String papad;
    String cold;
    String dal;
    String sweet;
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getSalad() {
        return salad;
    }

    public void setSalad(String salad) {
        this.salad = salad;
    }

    public String getSabji() {
        return sabji;
    }

    public void setSabji(String sabji) {
        this.sabji = sabji;
    }

    public String getPapad() {
        return papad;
    }

    public void setPapad(String papad) {
        this.papad = papad;
    }

    public String getCold() {
        return cold;
    }

    public void setCold(String cold) {
        this.cold = cold;
    }

    public String getDal() {
        return dal;
    }

    public void setDal(String dal) {
        this.dal = dal;
    }

    public String getSweet() {
        return sweet;
    }

    public void setSweet(String sweet) {
        this.sweet = sweet;
    }

public  String toString(){return order+salad+sabji+papad+cold+dal+sweet;}
}
