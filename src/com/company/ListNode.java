package com.company;

/**
 * Created by axeleroy on 16/10/2014.
 */
public class ListNode {
    public ListNode next;
    public Object data;

    public ListNode(Object data, ListNode next) {
        this.next = next;
        this.data = data;
    }
}