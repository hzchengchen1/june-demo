package com.june.demo.jdk8;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Lambda 核心思想：行为参数化(behavior parameterization)
 */
public class LambdaTest {

    // 行为参数化
    // ----------------jdk8之前的实现-------------------
    // 1. 对过滤行为建模

    public interface ApplePredicate {
        boolean test(Apple apple);
    }

    // 2. 定义过滤行为

    public static class AppleRedAndHeavyPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return "red".equals(apple.getColor())
                    && apple.getWeight() > 150;
        }
    }

    // 3. 定义过滤方法
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = Lists.newArrayList();
        for (Apple apple : inventory) {
            // 对比之前filterApples方法， 这个地方ApplePredicate封装了行为
            // 所有的过滤行为 由参数 ApplePredicate决定
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Apple> inventory = Lists.newArrayList();
        Apple oldApple = new Apple();
        oldApple.setColor("red");
        oldApple.setWeight(151);
        inventory.add(oldApple);

        // filterApples 方法的行为取决于你通过 ApplePredicate 对象传递的代码。
        //换句话说，filterApples 方法的行为参数化了！

        List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);

        // 匿名内部类实现方法略....
        //   ----------------jdk8的实现-------------------
        // filterApples 方法定义同上
        // 代码干净简洁很多...

        List<Apple> result = filterApples(inventory,
                (Apple apple) -> "red".equals(apple.getColor())
                        && apple.getWeight() > 150);
        System.out.println(result);
    }


}

class Apple {

    private String color;

    private int weight;

    String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }

    int getWeight() {
        return weight;
    }

    void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}