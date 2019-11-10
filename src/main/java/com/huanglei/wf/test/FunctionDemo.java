package com.huanglei.wf.test;

import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class FunctionDemo {
    public static void main(String[] args) {
        // 断言接口返回true或者false 使用test
        IntPredicate predicate = i->i>0;
        System.out.println(predicate.test(-9));

        //消费接口 没有返回值使用accept
        Consumer<String> consumer= s-> System.out.println(s);
        consumer.accept("输入的数据");
    }
}
