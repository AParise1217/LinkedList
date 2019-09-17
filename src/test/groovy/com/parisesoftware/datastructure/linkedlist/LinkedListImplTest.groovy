package com.parisesoftware.datastructure.linkedlist

import com.parisesoftware.model.INode
import com.parisesoftware.model.factory.INodeFactory
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

        given: 'a mocked INodeFactory instance, set to always return mocked INode instances'
        INodeFactory mockFactory = Mock(INodeFactory) {
            createNode(_) >> Mock(INode)
        }

        and: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl(mockFactory)

        and: 'an Element is inserted into the LinkedList'
        testLinkedList.insertHead('a Farewell to Kings')

        when: "the LinkedList is queried for if it is Empty"
        final boolean resultant = testLinkedList.isEmpty()

        then: "the resultant boolean is false"
        !resultant
    }

    def "getSize(): should return 0 immediately following construction"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl()

        when: "the LinkedList is queried for how many elements are contained"
        final int resultant = testLinkedList.getSize()

        then: "the resultant integer is 0"
        resultant == 0
    }

    def "getSize(): should return 1 after an element is inserted into the LinkedList"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl(Mock(INodeFactory))

        and: 'an Element is inserted into the LinkedList'
        testLinkedList.insertHead('Hemispheres')

        when: "the LinkedList is queried for how many elements are contained"
        final int resultant = testLinkedList.getSize()

        then: "the resultant integer is 1"
        resultant == 1
    }

    def "removeNode(): should return false when an index out of bounds is requested"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl(Mock(INodeFactory))

        and: 'two Elements are inserted into the LinkedList'
        testLinkedList.insertHead('Signals')
        testLinkedList.insertHead('Grace Under Pressure')

        and: 'an out of bounds integer to be used in the removal request'
        final int outOfBoundsNumber = 50

        when: "the LinkedList receives a request to remove a Node that is out of bounds"
        final boolean resultant = testLinkedList.removeNode(outOfBoundsNumber)

        then: "Sanity Check: validate that the out of bounds number is greater than the size of the LinkedList"
        outOfBoundsNumber >= testLinkedList.getSize()

        and: 'the resultant boolean is false'
        !resultant
    }

    def "search(): should return an Optional.empty() when an index out of bounds is requested"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl(Mock(INodeFactory))

        and: 'three Elements are inserted into the LinkedList'
        testLinkedList.insertHead('Twilight Zone')
        testLinkedList.insertHead('Passage To Bangkok')
        testLinkedList.insertHead('2112')

        and: 'an out of bounds integer to be used in the search request'
        final int outOfBoundsNumber = 500

        when: "the LinkedList receives a query for an out of bounds Node"
        final Optional<INode> resultant = testLinkedList.search(outOfBoundsNumber)

        then: "Sanity Check: validate that the out of bounds number is greater than the size of the LinkedList"
        outOfBoundsNumber >= testLinkedList.getSize()

        and: 'the resultant Optional is not present'
        !resultant.isPresent()
    }

    def "deleteHead(): should return an Optional.empty() when the LinkedList is empty"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl()

        when: "the LinkedList receives a command to delete the head"
        final Optional<INode> resultant = testLinkedList.deleteHead()

        then: "Sanity Check: validate that the LinkedList is empty"
        testLinkedList.isEmpty()

        and: 'the resultant Node is not present'
        !resultant.isPresent()
    }

    def "getTail(): should return an Optional.empty() when the LinkedList is empty"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl()

        when: "the LinkedList receives a query for the tail"
        final Optional<INode> resultant = testLinkedList.getTail()

        then: "Sanity Check: validate that the LinkedList is empty"
        testLinkedList.isEmpty()

        and: 'the resultant Node is not present'
        !resultant.isPresent()
    }

    def "getTail(): should not return null when the LinkedList is empty"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl()

        when: "the LinkedList receives a query for the tail"
        final Optional<INode> resultant = testLinkedList.getTail()

        then: "Sanity Check: validate that the LinkedList is empty"
        testLinkedList.isEmpty()

        and: 'the resultant is not null'
        resultant != null
    }

    def "getTail(): should not throw a NPE when the LinkedList is empty"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl()

        when: "the LinkedList receives a query for the tail"
        testLinkedList.getTail()

        then: "Sanity Check: validate that the LinkedList is empty"
        testLinkedList.isEmpty()

        and: 'a NPE was not thrown'
        notThrown(NullPointerException)
    }

    def "getHead(): should return an Optional.empty() when the LinkedList is empty"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl()

        when: "the LinkedList receives a query for the head"
        final Optional<INode> resultant = testLinkedList.getHead()

        then: "Sanity Check: validate that the LinkedList is empty"
        testLinkedList.isEmpty()

        and: 'the resultant Node is not present'
        !resultant.isPresent()
    }

    def "getHead(): should not return null when the LinkedList is empty"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl()

        when: "the LinkedList receives a query for the head"
        final Optional<INode> resultant = testLinkedList.getHead()

        then: "Sanity Check: validate that the LinkedList is empty"
        testLinkedList.isEmpty()

        and: 'the resultant is not null'
        resultant != null
    }

    def "getHead(): should not throw a NPE when the LinkedList is empty"() {

        given: 'a LinkedList instance'
        final LinkedListImpl testLinkedList = new LinkedListImpl()

        when: "the LinkedList receives a query for the head"
        testLinkedList.getHead()

        then: "Sanity Check: validate that the LinkedList is empty"
        testLinkedList.isEmpty()

        and: 'a NPE was not thrown'
        notThrown(NullPointerException)
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
