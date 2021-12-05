package com.zhl.test.provider.user.rest;

import java.util.*;

/**
 * @description 测试相关类
 * @author zhenghualiang
 * @date 2021/01/01
 */
public class Test {

    public static final void main(String[] args) {
        // 缩进 4个空格
        String say = "hello";
        // 运算符的左右必须有一个空格
        int flag = 0;
        // 关键词 if与括号之间必须有一个空格，括号内的 f与左括号，0与右括号不需要空格
        if (flag == 0) {
            System.out.println(say);
        }
        // 左大括号前加空格且不换行；左大括号后换行
        if (flag == 1) {
            System.out.println("world");
            // 右大括号前换行，右大括号后有 else，不用换行
        } else {
            System.out.println("ok");
        // 在右大括号后直接结束，则必须换行
        }


//        if (condition) {
//            // 业务代码...
//            return obj;
//        }

        // 其他业务代码

//        return anotherObj;

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");

        List<String> subList = list.subList(0, 1);
//        ArrayList<String> subList2 = (ArrayList<String>) list.subList(0, 1);

        list.add("3");
//        for (String str : subList) {
//        System.out.println(subList.get(0));
//        }
        String[] array = new String[list.size()];
        array = list.toArray(array);

        Arrays.asList();

        Map<String, String> map = new HashMap<String, String>();
        map.put("", "");

        List<? extends Fruit> l = new ArrayList<Apple>();

        l.add(new Apple());
        l.add(new Fruit());
        l.add(new Banana());

        Fruit f = l.get(0);

        List<? super Apple> l1 = new ArrayList<Apple>();

        l1.add(new Apple());
//        l1.add(new Fruit());
        l1.add(new Banana());

        Fruit f = l1.get(0);
    }
}
