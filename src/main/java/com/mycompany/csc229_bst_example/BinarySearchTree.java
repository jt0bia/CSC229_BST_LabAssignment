package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        if (root!= null) {
            doInOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            doInOrder(root.getRight());
        }
    }

    public void preOrderTraversal() {
        doPreOrder(this.root);
    }

    // added private method for dePreOrder
    private void doPreOrder(BstNode root) {
        if (root!= null) {
            System.out.print(root.getData() + " ");
            doPreOrder(root.getLeft());
            doPreOrder(root.getRight());
        }
    }

    public Integer findHeight() {
        return calculateHeight(root);
    }

    // added private method for height calculation
    private int calculateHeight(BstNode node) {
        if (node == null)
            return -1;
        int leftHeight = calculateHeight(node.getLeft());
        int rightHeight = calculateHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getDepth(BstNode node) {
        return calculateDepth(root, node, 0);
    }

    // added private method for depth calculation
    private int calculateDepth(BstNode current, BstNode target, int depth) {
        if (current == null)
            return -1;
        if (current == target)
            return depth;
        int leftDepth = calculateDepth(current.getLeft(), target, depth + 1);
        if (leftDepth != -1)
            return leftDepth;
        return calculateDepth(current.getRight(), target, depth + 1);
    }

    
   public void print() {
       System.out.println("\n==== BST Print ===== \n");
       printTree(root, ""); // print changed to printTree()
   }

   // method to print the binary tree
   private void printTree(BstNode node, String prefix) {
        if (node != null) {
            System.out.println(prefix + "|__ " + node.getData());
            printTree(node.getLeft(), prefix + "|   ");
            printTree(node.getRight(), prefix + "    ");
        }
   }




}
