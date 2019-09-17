package com.parisesoftware.model.factory

import com.parisesoftware.model.INode
import spock.lang.Specification

class NodeFactoryTest extends Specification {

    def "createNode(T): should return a Node of type INode"() {

        given: 'a NodeFactory instance'
        final NodeFactory testFactory = new NodeFactory()

        when: "the NodeFactory receives a request to create a Node with some test value"
        final Object resultant = testFactory.createNode(1979)

        then: 'the resultant Node is of type INode'
        resultant instanceof INode
    }

    def "createNodeWithLink(INode, T): should return a Node of type INode"() {

        given: 'a NodeFactory instance'
        final NodeFactory testFactory = new NodeFactory()

        when: "the NodeFactory receives a request to create a Node with the test value"
        final Object resultant = testFactory.createNodeWithLink(Mock(INode), 'Mad Max')

        then: 'the resultant Node is of type INode'
        resultant instanceof INode
    }

}
