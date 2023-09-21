package TheBaseDateType;

import java.util.Iterator;
import java.util.Scanner;

public class Queue<Item> implements Iterable<Item> {
    private class Node {
        Node next;
        Item item;
        Node(Item item) {
            this.item = item;
        }
        Node() {
        }

    }

    private Node head, tail;
    private int length;

    public boolean isEmpty() {
        return length == 0;
    }

    public void enQueue(Item item) {
        Node node = new Node(item);
        if (this.tail == null) {
            head = tail = node;
        }
        tail.next = node;
        tail=node;
        length++;
    }

    public Item deQueue() {
        if (this.length == 0) return null;
        Node node = this.head;
        head = head.next;
        length--;
        return node.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = head;

        @Override
        public boolean hasNext() {
//            return length != 0;for each 循环实现的是 Iterator 接口来进行的结果输出，所以在 判断has next 的时间需要判断当前结果是否为空
            return current!=null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;

            return item;
        }
    }


}
