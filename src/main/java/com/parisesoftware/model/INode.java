package com.parisesoftware.model;

/**
 * Abstraction for the some Container of Data to be housed in a
 * {@link com.parisesoftware.datastructure.linkedlist.ILinkedList} Data Structure
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.1
 * @since 1.0.1
 */
public interface INode<T extends Comparable<T>> {

    /**
     * Getter for the Data contained within this Node
     * @return {@code T} Generic Encapsulated Data
     */
    T getData();

    /**
     * Getter for the Node that is linked to this one
     * @return {@code Node} that is linked
     */
    INode<T> getLink();

    /**
     * Setter for the Linked Node
     * @param link to be set as the link
     */
    void setLink(INode<T> link);

}
