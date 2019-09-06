package com.parisesoftware.model;

/**
 * Model to encapsulate Data inside the
 * {@link com.parisesoftware.datastructure.linkedlist.ILinkedList} Data Structure
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.2
 * @since 1.0.0
 */
public class Node<T extends Comparable<T>> implements INode<T> {

    private INode<T> link;

    protected T data;

    /**
     * @param data the information to store in the Node
     */
    public Node(T data) {
        this.data = data;
    }

    /**
     * @param link the next Node in the Linked List
     * @param data the information to be stored in the Node
     */
    public Node(INode<T> link, T data) {
        this.data = data;
        this.link = link;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getData() {
        return this.data;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public INode<T> getLink() {
        return this.link;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLink(INode<T> link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Node's data = " + this.data;
    }

}
