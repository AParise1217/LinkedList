package com.parisesoftware.datastructure.linkedlist.factory

import spock.lang.Specification

class LinkedListFactoryTest extends Specification {

    def "createLinkedList(): should return an empty ILinkedList"() {

        given: 'a LinkedListFactory instance'
        final LinkedListFactory testFactory = new LinkedListFactory()

        when: "a LinkedList is instantiated, then queried for if it is Empty"
        final boolean resultant = testFactory.createLinkedList().isEmpty()

        then: "the resultant boolean is true"
        resultant
    }

}
