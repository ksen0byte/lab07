package com.ksenobyte;

import com.ksenobyte.structure.MyTree;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyTree<Integer> tree = new MyTree<>(0);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1 + " : iteration");
            tree.addChild(random.nextInt(10));
            System.out.println(tree);
            System.out.println("==================================================");
        }
    }
}
