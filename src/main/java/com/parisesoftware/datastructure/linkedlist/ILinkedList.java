package com.parisesoftware.datastructure.linkedlist;

import com.parisesoftware.model.INode;
import com.parisesoftware.model.Node;

/**
 * Abstraction for a Linked List Data Structure
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.1
 * @since 1.0.0
 */
public interface ILinkedList<T extends Comparable<T>> {

    /**
     * Creates node with info then places at head
     *
     * @param info the data to be stored in the Node
     */
    void insertHead(T info);

    /**
     * Creates node with info then places at end
     *
     * @param info the data to be stored in the Node
     */
    void insertEnd(T info);

    /**
     * @param info  the data to be stored in the Node
     * @param index the index where the Node will be inserted
     */
    void insertIndex(T info, int index);

    /**
     * Fetch the Number of Elements in this Linked List
     * @return {@code int} the size of this data structure
     */
    int getSize();

    /**
     * Removes the node at index
     *
     * @param index the index where the Node will be inserted
     * @return success case
     */
    boolean removeNode(int index);

    /**
     * Iterates through linked list and returns the node at the index
     *
     * @param index the index of the Node to be fetched
     * @return the Node at the @param index
     */
    INode<T> search(int index);

    /**
     * @return true if linked list is empty, false if has greater than 0 nodes
     */
    boolean isEmpty();

    /**
     * @return the contents of the linked list formatted as a String
     */
    String toString();

    /**
     * Deletes the head of the Linked List and returns its node
     *
     * @return the Node located at the head of the Linked List
     */
    INode<T> deleteHead();

    /**
     * Returns the {@link Node} at the front of the LinkedList
     * @return {@code Node} that is first in the LinkedList
     */
    INode<T> getHead();

    /**
     * Returns the {@link Node} at the end of the LinkedList
     * @return {@code Node} that is last in the LinkedList
     */
    INode<T> getTail();

}
