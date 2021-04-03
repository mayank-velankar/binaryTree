package com.mayank_project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Node tree = null;
        tree = createTree(tree);
        inOrder(tree);
        System.out.println();
        preOrder(tree);
        System.out.println();
        postOrder(tree);
        System.out.println();
        levelOrder(tree);
        System.out.println();
        int heightTree = height(tree);
        System.out.println(heightTree);
    }

    public static Node createTree(Node parent) {
        Node root = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        root = new Node(data);
        root.setParent(parent);
        System.out.println("Enter data for left");
        Node left = createTree(root);
        root.setLeft(left);

        System.out.println("Enter data for right");
        Node right = createTree(root);
        root.setRight(right);

        return root;

    }

    public static void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.getValue());
            inOrder(node.getRight());
        }
    }
    public static void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.getValue());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    public static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println(node.getValue());
        }
    }
    public static void levelOrder(Node node) {
        LinkedList <Node> l = new LinkedList<>();
        if(node == null)
            return;
        l.add(node);
        while(!l.isEmpty()) {
            Node temp = l.poll();
            System.out.println(temp.getValue());
            if(temp.getLeft()!=null)
                l.add(temp.getLeft());
            if(temp.getRight()!=null)
                l.add(temp.getRight());
        }
    }
    public static int height(Node node){
        if(node==null)
            return 0;
        int l = height(node.getLeft());
        int r = height(node.getRight());

        return Math.max(l,r)+1;
        }
    }

