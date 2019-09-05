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

}
