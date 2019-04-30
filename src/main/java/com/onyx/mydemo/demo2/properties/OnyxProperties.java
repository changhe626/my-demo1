package com.onyx.mydemo.demo2.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zk on 2017/12/20.
 * 作用: com.example.onyx.
 */
@Component
@ConfigurationProperties(prefix = "com/onyx2")
public class OnyxProperties {
    private String cupSize;
    private int age;

    public String getCupSize() {
        return cupSize;
    }

    public int getAge() {
        return age;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "onyxProperties{" +
                "cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
