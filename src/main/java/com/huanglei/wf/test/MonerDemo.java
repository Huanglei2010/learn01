package com.huanglei.wf.test;

import java.text.DecimalFormat;
import java.util.function.Function;


class MyMoney{
    private final int money;

    public MyMoney(int money) {
        this.money = money;
    }

    public void printMoney(Function<Integer,String> moneyFormat){
        System.out.println(" --->"+moneyFormat.apply(money));
    }
}
public class MonerDemo {
    public static void main(String[] args) {
        MyMoney me = new MyMoney(99999);
        Function<Integer,String> moneyFormat = i->new DecimalFormat("#,###").format(i);
        me.printMoney(moneyFormat.andThen(s->"人民币"+s));
    }
}
