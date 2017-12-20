package com.ksenobyte.structure;

import lombok.EqualsAndHashCode;

import java.util.Objects;

public class MyTree<T extends Comparable> {
    private Node<T> root;

    public MyTree(T value) {
        root = new Node<>();
        root.value = value;
    }

    @EqualsAndHashCode(of = "value")
    public static class Node<T extends Comparable> {
        private T value;
        private Node<T> parent;
        private Node<T> left;
        private Node<T> right;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", parent=" + (parent == null ? null : parent.value) +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public void replaceValue(T valueToBeReplaced, T replacementValue) {
        replaceValue(root, valueToBeReplaced, replacementValue);
    }

    private void replaceValue(Node<T> node, T valueToBeReplaced, T replacementValue) {
        if (Objects.equals(node.value, valueToBeReplaced)) {
            node.value = replacementValue;
        } else if (node.right != null) {
            replaceValue(node.right, valueToBeReplaced, replacementValue);
        } else if (node.left != null) {
            replaceValue(node.left, valueToBeReplaced, replacementValue);
        }
    }

    public Node<T> getRoot() {
        return root;
    }

    public Node<T> addChild(T value) {
        return findNodeToAdd(root, value);
    }

    private Node<T> findNodeToAdd(Node<T> node, T value) {

        if (node.value.compareTo(value) > 0) {
            if (node.left == null) {
                Node<T> child = new Node<>();
                child.value = value;
                child.parent = node;
                node.left = child;
                return child;
            } else {
                return findNodeToAdd(node.left, value);
            }
        } else {
            if (node.right == null) {
                Node<T> child = new Node<>();
                child.value = value;
                child.parent = node;
                node.right = child;
                return child;
            } else {
                return findNodeToAdd(node.right, value);
            }
        }
    }

    @Override
    public String toString() {
        return "MyTree{" +
                "root=" + root +
                '}';
    }
}