package com.parisesoftware.datastructure.linkedlist.factory;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;

/**
 * Encapsulation of Creational Logic for {@link ILinkedList} instances
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.6
 * @since 1.0.6
 */
public interface ILinkedListFactory<T extends Comparable<T>> {

    /**
     * Creates a new {@link ILinkedList} instance
     * @return {@code ILinkedList} that is empty
     */
    ILinkedList<T> createLinkedList();

}
