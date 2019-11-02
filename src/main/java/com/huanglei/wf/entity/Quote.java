package com.huanglei.wf.entity;


import lombok.Data;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Instant;

@Data
public class Quote {

    private static final MathContext MATH_CONTEXT = new MathContext(2);

    private String ticker;

    private BigDecimal price;

    private Instant instant;

    public Quote() {
    }

    public Quote(String ticker, BigDecimal price) {
        this.ticker = ticker;
        this.price = price;
    }

    public Quote(String ticker, Double price) {
        this(ticker, new BigDecimal(price, MATH_CONTEXT));
    }

    @Override
    public String toString() {
        return "Quote{" +
                "ticker='" + ticker + '\'' +
                ", price=" + price +
                ", instant=" + instant +
                '}';
    }
}
//————————————————
//        版权声明：本文为CSDN博主「Allen716」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/wshl1234567/article/details/80320116
