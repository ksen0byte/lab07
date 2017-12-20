package com.ksenobyte;

import com.ksenobyte.structure.MyTree;

public class Main {
    public static void main(String[] args) {
        MyTree<Integer> tree = new MyTree<>(0);
        tree.addChild(1);
        tree.addChild(2);
        tree.addChild(3);
        tree.addChild(-2);
        tree.addChild(-1);
        tree.addChild(4);
        System.out.println(tree);
        tree.replaceValue(1, 2);
        System.out.println(tree);
    }
}
