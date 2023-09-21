package TheBaseDateType;


import java.util.Iterator;
import java.util.Scanner;

public class Stack<Item> implements Iterable<Item> {


    /**
     * 首先定义链表的节点。
     */
    private class Node {
        Node next;
        Item item;
    }

    private Node Top;//表示栈顶
    private int N;//表示栈中的数据

    /**
     * 在栈顶 插入元素 item
     */
    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = this.Top;
        this.Top = node;
        N++;
    }

    /**
     * 返回栈顶的元素
     */
    public Item pop() {
        Item item = this.Top.item;
        Top = Top.next;
        N--;
        return item;
    }

    /**
     * 实现Iterable< T > 接口自带的迭代器
     *
     * @return
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }


    private class ListIterator implements Iterator<Item> {
        private Node current = Top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    }
