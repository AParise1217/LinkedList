package com.parisesoftware.datastructure.linkedlist;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.parisesoftware.model.INode;
import com.parisesoftware.model.NodeModule;
import com.parisesoftware.model.factory.INodeFactory;

import java.util.Optional;
import java.util.regex.Pattern;

public class LinkedListTest {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new NodeModule());

        ILinkedList linkedList = new LinkedListImpl<>(injector.getInstance(INodeFactory.class));

        if (linkedList.isEmpty()) { //test to see if the list is empty
            System.out.println("The Linked List is currently empty.");
        }

        //Sample Data
        String nameList = "James John Michael Peter Allison Daniel George Simon Jason Mark";
        final String[] studentNameList = nameList.split(Pattern.quote(" "));

        //Populate the Linked List
        for (String aStudentNameList : studentNameList) {
            //System.out.println(studentNameList[i] + " adding at end of Linked List");
            linkedList.insertEnd(aStudentNameList);
        }

        System.out.println(linkedList.toString()); //Linked List should be full of student names at this point


        System.out.println("Linked List currently has " + linkedList.getSize() + " elements."); //Using sample data above, should be 10

        linkedList.removeNode(1); //remove second node

        //Confirm
        System.out.println(linkedList.toString());
        System.out.println("Linked List currently has " + linkedList.getSize() + " elements.");

        linkedList.removeNode(8); //remove the 9th (last) node

        //confirm
        System.out.println(linkedList.toString());
        System.out.println("Linked List currently has " + linkedList.getSize() + " elements.");

        linkedList.insertHead("Jimmy"); //add new node at head

        //confirm
        System.out.println(linkedList.toString());
        System.out.println("Linked List currently has " + linkedList.getSize() + " elements.");

        linkedList.insertEnd("Justin"); //add new node at end

        //confirm
        System.out.println(linkedList.toString());
        System.out.println("Linked List currently has " + linkedList.getSize() + " elements.");

        if (linkedList.isEmpty()) { //test to see if the list is empty
            System.out.println("The Linked List is currently empty.");
        }

        final Optional<INode<String>> optionalThirdIndexNode = linkedList.search(2);
        if(!optionalThirdIndexNode.isPresent()) {
            // TODO: when this is converted to unit test cases, this should not be the case that is hit
            System.out.println("There is no node at the third index");
        } else {
            // TODO: when this is converted to unit test cases, this case should be hit
            System.out.println("The node at the third index is: " + optionalThirdIndexNode.get().getData());
        }

    }

}
