package com.parisesoftware.datastructure.linkedlist;

import com.parisesoftware.model.Node;

/**
 * Default implementation of {@link ILinkedList}
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.1
 * @since 1.0.0
 */
public class LinkedListImpl<T extends Comparable<T>> implements ILinkedList<T> {

    private Node<T> head;
    private int numElements;

    public LinkedListImpl() {
        //constructor
        this.head = null;
        this.numElements = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertHead(T info) {
        //creates a new node, then adds it to the front of the linked list

        incNumElements();

        if (isEmpty()) {
            this.head = createNode(info);
            return;
        }

        this.head = createNodeWithLink(this.head, info);
    }

    /**
     * Creates a new {@link Node} based on the given info
     *
     * @param info {@code T} to create the Node with
     * @return {@code Node} constructed with the given info
     */
    private Node<T> createNode(final T info) {
        return new Node<>(null, info);
    }

    /**
     * Creates a new {@link Node} based on the given info
     *
     * @param link {@code Node} to be set as the next in the sequence
     * @param info {@code Comparable} data to create the Node with
     * @return {@code Node} constructed with the given info
     */
    private Node<T> createNodeWithLink(Node<T> link, final T info) {
        return new Node<>(link, info);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertEnd(T info) {
        Node<T> newNode = createNode(info);
        incNumElements();

        if (isEmpty()) {
            this.head = newNode;
            return;
        }

        Node<T> curNode = this.head;

        while (curNode.getLink() != null) {
            //iterates to end of linked list
            curNode = curNode.getLink();
        }
        curNode.setLink(newNode); //add node as next link to current last in list
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertIndex(T info, int index) {
        //creates node, then adds it to a specific index
        Node<T> newNode = createNode(info);
        incNumElements();

        if (isEmpty()) {
            this.head = newNode;
            return;
        }

        Node<T> curNode = this.head;
        for (int i = 1; i < index && curNode.getLink() != null; i++) {
            //iterate to index location, or end, whichever comes first
            curNode = curNode.getLink();
        }

        newNode.setLink(curNode.getLink()); //set new Node's link to the current node's next link
        curNode.setLink(newNode); //set the current node's link to the new Node
    }

    /**
     * Increments the number of elements in the linkedlist
     */
    private void incNumElements() {
        this.numElements++;
    }

    /**
     * Decrements the number of elements in the linkedList
     */
    private void decNumElements() {
        this.numElements--;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNumElements() {
        //returns the total number of elements
        return this.numElements;
    }

    /**
     * Helper to determine if the given index is out of bounds
     *
     * @param index to check if it is in bounds or not
     * @return {@code boolean} true if it is out of bounds, false if it is not
     */
    private boolean isIndexOutOfBounds(final int index) {
        return (index <= 0 || index > this.numElements);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeNode(int index) {
        if (isIndexOutOfBounds(index) || isEmpty()) {
            return false; //index out of bounds
        }

        Node<T> curNode = this.head;

        for (int i = 0; i < index - 1; i++) {
            if (curNode.getLink() == null) {
                return false; //index out of bounds
            }

            curNode = curNode.getLink();
        }

        //curNode is now the node before the index that needs to be removed
        curNode.setLink(curNode.getLink().getLink()); //set the node before to be linked to the node after the one needing to be removed
        decNumElements();
        return true; //node successfully removed
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node<T> search(int index) {

        if (isIndexOutOfBounds(index)) {
            return null;
        }

        Node<T> curNode = this.head;
        for (int i = 0; i < index; i++) {
            //iterates up until the index where the node is located
            if (curNode.getLink() == null) {
                return null;
            }
            curNode = curNode.getLink();
        }

        return curNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return (this.head == null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        if (isEmpty()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();

        Node curNode = this.head;
        while (curNode != null) {
            stringBuilder.append("[")
                    .append(curNode.getData())
                    .append("]");

            curNode = curNode.getLink();
        }

        return stringBuilder.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node<T> deleteHead() {
        Node<T> retNode = this.head;
        this.head = this.head.getLink();
        this.numElements--;
        return retNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node<T> getHead() {
        return this.head;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node<T> getTail() {
        return search(this.numElements - 1); //returns the tail (element in the last index)
    }

}
