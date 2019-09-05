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
    private static int numElements;

    public LinkedListImpl() {
        //constructor
        head = null;
        numElements = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertHead(Comparable info) {
        //creates a new node, then adds it to the front of the linked list
        Node newNode = new Node<>(null, info);
        incNumElements();
        if (head == null) {
            //if the linked list is currently empty
            head = newNode;
        } else {
            newNode.setLink(head);
            head = newNode;
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertEnd(Comparable info) {
        Node newNode = new Node<>(null, info);
        incNumElements();
        if (head == null) {
            //linked list is empty
            head = newNode;
        } else {
            Node<T> curNode = head;

            while (curNode.getLink() != null) {
                //iterates to end of linked list
                curNode = curNode.getLink();
            }
            curNode.setLink(newNode); //add node as next link to current last in list
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertIndex(Comparable info, int index) {
        //creates node, then adds it to a specific index
        Node newNode = new Node<>(null, info);
        incNumElements();
        if (head == null) {
            //linked list is empty
            head = newNode;
        } else {
            Node curNode = head;
            for (int i = 1; i < index && curNode.getLink() != null; i++) {
                //iterate to index location, or end, whichever comes first
                curNode = curNode.getLink();
            }
            newNode.setLink(curNode.getLink()); //set new Node's link to the current node's next link
            curNode.setLink(newNode); //set the current node's link to the new Node

        }
    }

    private void incNumElements() {
        //Increments the number of elements in the linkedlist
        numElements++;
    }

    private void decNumElements() {
        //Decrements the number of elements in the linkedList
        numElements--;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNumElements() {
        //returns the total number of elements
        return numElements;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeNode(int index) {
        //removes the node at given index,
        //returns true if successful, false if null pointer exception or index out of bounds were going to occur
        if (index > getNumElements() || index <= 0) {
            return false; //index out of bounds
        } else {
            Node curNode = head;
            if (head != null) {
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
            } else {
                return false; //null pointer
            }
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node<T> search(int index) {
        //returns the node at the index location
        Node<T> curNode = null;
        if (index <= 0) { //can't be an index of zero or less
            return null;
        } else {
            if (head != null) {

                curNode = head;
                for (int i = 0; i < index; i++) {
                    //iterates up until the index where the node is located
                    if (curNode.getLink() == null) {
                        return null;
                    }
                    curNode = curNode.getLink();
                }
                //curNode now is the correct node
                return curNode;
            }
        }
        return curNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        //returns the elements of the linked list

        String retVal = "";

        if (head != null) { //suppress null pointer exception
            Node curNode = head;
            while (curNode != null) {
                retVal += "[" + curNode.getData() + "]";
                curNode = curNode.getLink();
            }
        }

        return retVal;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node<T> deleteHead() {
        Node<T> retNode = head;
        head = head.getLink();
        numElements--;
        return retNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node<T> getHead() {
        return head;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node<T> getTail() {
        return search(numElements - 1); //returns the tail (element in the last index)
    }

}
