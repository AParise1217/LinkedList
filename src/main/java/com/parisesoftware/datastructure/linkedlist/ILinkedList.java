package com.parisesoftware.datastructure.linkedlist;

import com.parisesoftware.model.INode;

import java.util.Optional;

/**
 * Abstraction for a Linked List Data Structure
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.4
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
     * @return {@code Optional} {@link INode} at the given index
     */
    Optional<INode<T>> search(int index);

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
     * Returns the {@link INode} at the front of the LinkedList
     * @return {@code Optional} {@link INode} that is first in the LinkedList
     */
    Optional<INode<T>> getHead();

    /**
     * Returns the {@link INode} at the end of the LinkedList
     * @return {@code Optional} {@link INode} that is last in the LinkedList
     * @since 1.0.0
     */
    Optional<INode<T>> getTail();

}
