package com.company;

/**
 * Created by axeleroy on 16/10/2014.
 */
class CircularLinkedList {
    private ListNode head = null;
    private int numberOfElements = 0;
    private ListNode actualElement = null;
    private int index = 0;

    public boolean isEmpty() {
        return (numberOfElements == 0);
    }

    public int lenght() {
        return numberOfElements;
    }

    public void add(Object data ){
        insertAfterActual(data);
    }

    private void insertFirst(Object data) {
        if (!(isEmpty())) {
            index++;
        }
        ListNode listNode = new ListNode(data, head);
        head = listNode;
        numberOfElements++;
    }

    private void insertAfterActual(Object data) {
        ListNode listNode = new ListNode(data, actualElement.next);
        actualElement.next = listNode;
        numberOfElements++;
    }

    private boolean deleteFirst() {
        if (isEmpty())
            return false;
        if (index > 0)
            index--;
        head = head.next;
        numberOfElements--;
        return true;
    }

    private boolean deleteActualElement() {
        if (index > 0) {
            numberOfElements--;
            index--;
            ListNode listNode = head;
            while (listNode.next.equals(actualElement) == false)
                listNode = listNode.next;
            listNode.next = actualElement.next;
            actualElement = listNode;
            return true;
        }
        else {
            actualElement = head.next;
            index = 0;
            return deleteFirst();
        }
    }

    public boolean next() {
        if (isEmpty())
            return false;
        index = (index + 1) % numberOfElements;
        if (index == 0)
            actualElement = head;
        else
            actualElement = actualElement.next;
        return true;
    }

    public Object get() {
        return actualElement.data;
    }

    private void setActualElementData(Object data) {
        actualElement.data = data;
    }
}
