package com.wangtao.mylibrary.datastructure.skipList;

import java.util.Random;

/**
 * @author wangtao
 * @Description:跳表的Java实现
 * @date 2019/2/25 16:02
 */
public class SkipList {
    /**
     * 存储正整数，并且不重复
     */
    private static final int MAX_LEVEL = 16;
    //索引层数
    private int levelCount = 1;
    //带头链表
    private Node head = new Node();
    //用于随机生成的插入索引层数
    private Random r = new Random();

    public Node find(int value){
        Node p = head;
        for (int i = levelCount -1; i >= 0 ; i--) {
            while (p.forwards[i] != null && p.forwards[i].data <value){
                p = p.forwards[i];
            }
        }

        if(p.forwards[0] != null && p.forwards[0].data == value){
            return p.forwards[0];
        }else {
            return null;
        }
    }

    public void insert(int value){
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node[] update = new Node[level];
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }
        //记录每层小于value值中最大值
        // record every level largest value which smaller than insert value in update[]
        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;// use update save node in search path
        }

        // in search path node next node become new node forwords(next)
        for (int i = 0; i < level; ++i) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        // update node hight
        if (levelCount < level) levelCount = level;
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
    }

    //随机生成level，如果是奇数层数+1，防止伪随机
    private int randomLevel(){
        int level =1;
        for (int i = 0; i < MAX_LEVEL; i++) {
            if(r.nextInt() % 2 ==1){
                level++;
            }
        }
        return level;
    }


    private class Node{
        private int data = -1;
        private Node[] forwards = new Node[MAX_LEVEL];
        private int maxLevel =0;
    }
}
