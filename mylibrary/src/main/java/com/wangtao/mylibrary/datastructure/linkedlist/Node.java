package com.wangtao.mylibrary.datastructure.linkedlist;

/**
 * @author wangtao
 * @Description:单链表节点
 * @date 2019/4/19 16:21
 */
public class Node<Data> {
    public Data value;
    public Node<Data> next;

    public Node(Data value) {
        this.value = value;
    }
}
