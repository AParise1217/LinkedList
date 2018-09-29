package com.parisesoftware.datastructure.linkedlist;

import com.parisesoftware.model.Node;


public interface ILinkedList {

	/**
	 * Creates node with info then places at head
	 * @param info the data to be stored in the Node
	 */
	void insertHead(String info);

    /**
     * Creates node with info then places at end
     * @param info the data to be stored in the Node
     */
	void insertEnd(String info);

    /**
     * @param info the data to be stored in the Node
     * @param index the index where the Node will be inserted
     */
	void insertIndex(String info, int index); //creates node with info then places at index

    /**
     * @return the number of nodes in linked list
     */
	int getNumElements();

    /**
     * Removes the node at index
     * @param index the index where the Node will be inserted
     * @return success case
     */
	boolean removeNode(int index);

    /**
     * Iterates through linked list and returns the node at the index
     * @param index the index of the Node to be fetched
     * @return the Node at the @param index
     */
	Node search(int index);

    /**
     * @return true if linked list is empty, false if has > 0 nodes
     */
	boolean isEmpty();

    /**
     * @return the contents of the linked list formatted as a String
     */
	String toString();

    /**
     * Deletes the head of the Linked List and returns its node
     * @return the Node located at the head of the Linked List
     */
	Node deleteHead();

}
