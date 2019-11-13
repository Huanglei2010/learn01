package com.huanglei.wf.test;

/**
 * 定义一个接口为函数式接口
 * 函数式接口中 只能有一个非default方法
 */
@FunctionalInterface
interface IMath{
    int add(int x,int y);
}


public class TypeDemo {
    public static void main(String[] args) {
        IMath lambda = (x,y)->x+y; // 用lambda方法去实现接口
        IMath[] lambdas = {(x,y)->x+y};
        // 强转
        Object lambda2 = (IMath)(x,y)->x+y;
    }
}
