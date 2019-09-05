package com.parisesoftware.datastructure.linkedlist

import spock.lang.Specification

class LinkedListImplTest extends Specification {

    def "isEmpty(): should return true immediately following construction"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl()

        when: "the LinkedList is queried for if it is Empty"
        final boolean resultant = testLinkedList.isEmpty()

        then: "the resultant boolean is true"
        resultant
    }

    def "isEmpty(): should return false after an element is inserted"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl()

        and: 'an Element is inserted into the LinkedList'
        testLinkedList.insertHead('a Farewell to Kings')

        when: "the LinkedList is queried for if it is Empty"
        final boolean resultant = testLinkedList.isEmpty()

        then: "the resultant boolean is false"
        !resultant
    }

    def "getNumElements(): should return 0 immediately following construction"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl()

        when: "the LinkedList is queried for how many elements are contained"
        final int resultant = testLinkedList.getNumElements()

        then: "the resultant integer is 0"
        resultant == 0
    }

    def "getNumElements(): should return 1 after an element is inserted into the LinkedList"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl()

        and: 'an Element is inserted into the LinkedList'
        testLinkedList.insertHead('Hemispheres')

        when: "the LinkedList is queried for how many elements are contained"
        final int resultant = testLinkedList.getNumElements()

        then: "the resultant integer is 1"
        resultant == 1
    }

    def "removeNode(): should return false when an index out of bounds is requested"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl()

        and: 'two Elements are inserted into the LinkedList'
        testLinkedList.insertHead('Signals')
        testLinkedList.insertHead('Grace Under Pressure')

        and: 'an out of bounds integer to be used in the removal request'
        final int outOfBoundsNumber = 50

        when: "the LinkedList receives a request to remove a Node that is out of bounds"
        final boolean resultant = testLinkedList.removeNode(outOfBoundsNumber)

        then: "Sanity Check: validate that the out of bounds number is greater than the size of the LinkedList"
        outOfBoundsNumber >= testLinkedList.getNumElements()

        and: 'the resultant boolean is false'
        !resultant
    }

    def "removeNode(): should return false if the LinkedList is empty"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl()

        when: "the LinkedList receives a request to remove a Node"
        final boolean resultant = testLinkedList.removeNode(4)

        then: "Sanity Check: validate that the LinkedList is empty"
        testLinkedList.isEmpty()

        and: 'the resultant boolean is false'
        !resultant
    }

    def "removeNode(): should not throw a NPE when the LinkedList is empty"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl()

        when: "the LinkedList receives a request to remove a Node"
        testLinkedList.removeNode(65)

        then: "Sanity Check: validate that the LinkedList is empty"
        testLinkedList.isEmpty()

        and: 'a NPE was not thrown'
        notThrown(NullPointerException)
    }

}
