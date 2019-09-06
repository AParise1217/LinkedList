package com.parisesoftware.model

import spock.lang.Specification

class NodeTest extends Specification {

    def "getData: should return the Data set in the Constructor"() {

        given: 'a sample data value'
        final String testData = 'Fly by Night'

        and: "a Node is instantiated with this sample data value"
        final Node testNode = new Node(testData)

        when: "the data is queried for on the Node"
        final String resultant = testNode.getData()

        then: "the resultant is equal to the sample data value"
        resultant == testData
    }

    def "getLink: should return the Link set in the Constructor"() {

        given: 'a mocked Node'
        final INode testLink = Mock(INode)

        and: "a Node is instantiated with this mocked Node as the Link"
        final Node testNode = new Node(testLink, 'Anthem')

        when: "the Link is queried for on the Node"
        final INode resultant = testNode.getLink()

        then: "the resultant Node is equal to the mocked Node"
        resultant == testLink
    }

}
