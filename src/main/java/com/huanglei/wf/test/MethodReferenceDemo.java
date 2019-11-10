package com.huanglei.wf.test;

import javax.sound.midi.Soundbank;
import java.util.function.*;

class Dog{
    private String name="哮天犬";

    private int food = 10;
    public static void bark(Dog dog){
        System.out.println(dog+"汪汪");
    }

    @Override
    public String toString() {
        return this.name;
    }

    /**
     * 吃狗粮
     * @param num
     * @return 还剩下多少斤
     */
    public int eat(Dog this,int num){
        System.out.println("吃了 "+num+" 斤");
        this.food -= num;
        return this.food;
    }


    public Dog(){

    }
    public Dog(String name){
        this.name=name;
    }
}



public class MethodReferenceDemo {
    public static void main(String[] args) {
        Dog dog=new Dog();
        dog.eat(3);


        Consumer<String> consumer =System.out::println;
        consumer.accept("接受字符串");

        Consumer<Dog> consumer2 = Dog::bark;
        consumer2.accept(dog);

        // 非静态方法使用静态实例来引用
        //UnaryOperator<Integer> function = dog::eat;
        IntUnaryOperator function = dog::eat;
        System.out.println(function.applyAsInt(100));

        // 使用类名来方法引用
        BiFunction<Dog,Integer,Integer> eatFunction= Dog::eat;
        System.out.println(eatFunction.apply(dog,2));

        // 构造函数的方法引用
       Supplier<Dog> supplier= Dog::new;
        System.out.println("创建了新对象"+supplier.get());

        // 带参数的构造函数的方法引用
        Function<String,Dog> function2 = Dog::new;
        System.out.println(function2.apply("旺财"));

    }
}
