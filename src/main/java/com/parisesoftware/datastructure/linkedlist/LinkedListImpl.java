package com.parisesoftware.datastructure.linkedlist;

import com.parisesoftware.model.Node;

/**
 * @author Andrew Parise
 * Feb 17th 2016
 * Assignment 3.1
 * Programming II
 *
 * Assignment Overview:
 *
 * "This programming exercise introduces the linked lists data structure. 
 * The students must create all the necessary methods for the linked list and use the 
 * linked list in a Java program."
 *
 *
 * LinkedListImpl.java
 * Implementation of a linked list, 
 * 		which is a sequence of nodes containing some string of data, 
 * 		and a pointer (referred to as a link in my code)
 *
 *
 * Usage:
 * 
 * 
 * Creating a Node			: 	"Node nameOfNode = new Node()" 							for link = null, info = ""
 * 								"Node nameofNode = new Node(Node link, String info)"	link is the next Node in the list, info is the data being stored
 * 
 * Valid Method Calls:
 * 
 * 		insertHead(String)					:		insert a Node (from Node.java), with String being the data contained
 * 		insertEnd(String)					:		insert a Node (^^^^^^^^^^^), with String being the data contained
 * 
 * 		insertIndex(Node,int)				:		add a node at a particular index
 * 		incNumElements()/decNumElements() 	:		private methods - modify the counter of the number of elements in the linked list
 * 		getNumElements()					:		returns the number of elements in the linked list
 * 		removeNode(int)						:		removes the node from the linked list at given index
 * 														Return Values:
 * 															True: if the removal was successful
 * 															False: if some exception was going to occur, so removal did not happen
 * 		search(int)							:		returns the node at the index
 * 		isEmpty()							:		returns a boolean of whether or not the linked list is empty
 * 		determineSize()						:		counts the number of nodes in linked list, alternative to getNumElements()
 * 		toString()							:		returns a string containing all of the data contained within the linked list
 * 		deleteHead()						:		deletes the head and returns the node
 * 
 * 		
 * 
 * 		ChangeLog:
 * 			Feb 17th 2016	: 	Initial Revision
 * 			Feb 28th 2016	: 	Added deleteHead()
 * 			Mar 4th 2016	:	Added getHead(), getTail(), insertHead(Object)
 * 			Mar 10 2016		:	Fixed functionality to work with different Node Class
 * 								- Deleted deleteHead(Customer obj)
 * 								- changed toString to support nodeObj.getData()
 * 			
 * 		
 */
public class LinkedListImpl implements ILinkedList {

	private Node head;
	private int numElements;

    /**
     * Default Constructor
     */
	public LinkedListImpl(){
		head = null;
		numElements = 0;
	}
	
	public void insertHead(String info){
		//creates a new node, then adds it to the front of the linked list
		Node newNode = new Node(null, info);
		incNumElements();
		if(head == null){
			//if the linked list is currently empty
			head = newNode;
		}
		else{
			newNode.setLink(head);
			head = newNode;
		}
		
	}

	public void insertEnd(String info){
		//creates a new node, then adds it at the end of the linked list
		Node newNode = new Node(null, info);
		incNumElements();
		if(head == null){
			//linked list is empty
			head = newNode;
		}
		else{
			Node curNode = head;
			
			while(curNode.getLink() != null){ 
				//iterates to end of linked list
				curNode = curNode.getLink();
			}
			curNode.setLink(newNode); //add node as next link to current last in list
			//System.out.println(newNode.getInfo() + " has been successfully added at the end of the linked list");
		}
	}

	public void insertIndex(String info, int index){
		//creates node, then adds it to a specific index
		Node newNode = new Node(null, info);
		incNumElements();
		if(head == null){
			//linked list is empty
			head = newNode;
		}
		else{
			Node curNode = head;
			for(int i = 1; i < index && curNode.getLink() != null; i++){
				//iterate to index location, or end, whichever comes first
				curNode = curNode.getLink();
			}
			newNode.setLink(curNode.getLink()); //set new Node's link to the current node's next link
			curNode.setLink(newNode); //set the current node's link to the new Node
			
		}
	}

	private void incNumElements(){
		//Increments the number of elements in the linkedlist
		numElements++;
	}
	private void decNumElements(){
		//Decrements the number of elements in the linkedList
		numElements--;
	}
	
	public int getNumElements(){
		//returns the total number of elements
		return numElements;
	}

	public boolean removeNode(int index){
		//removes the node at given index, 
		//returns true if successful, false if null pointer exception or index out of bounds were going to occur
		if(index > getNumElements() || index <= 0){
			return false; //index out of bounds
		}
		else{
			Node curNode = head;
			if(head != null){
				for(int i = 0; i < index - 1; i++){
					if(curNode.getLink() == null){
						return false; //index out of bounds
					}
					
					curNode = curNode.getLink();
				}
				//curNode is now the node before the index that needs to be removed
				curNode.setLink(curNode.getLink().getLink()); //set the node before to be linked to the node after the one needing to be removed
				decNumElements();
				return true; //node successfully removed
			}
			else{
				return false; //null pointer
			}
		}
	}

	public Node search(int index){
		//returns the node at the index location
		Node curNode;
		if(index <= 0){ //can't be an index of zero or less
			return null;
		}
		else{
			if(head != null){
				
				curNode = head;
				for(int i = 0; i < index; i++){
					//iterates up until the index where the node is located
					if(curNode.getLink() == null){
						return null;
					}
					curNode = curNode.getLink();
				}
				//curNode now is the correct node
				return curNode;
			}
		}
		return null;
	}

	public boolean isEmpty(){
        return head == null;
    }
	
	public String toString(){
		//returns the elements of the linked list
		
		StringBuilder retVal = new StringBuilder();
		
		if(head != null){ //suppress null pointer exception
			Node curNode = head;
			while(curNode != null){
				retVal.append("[").append(curNode.getData()).append("]");
				curNode = curNode.getLink();
			}
		}
		
		return retVal.toString();
	}

	public Node deleteHead(){
		//removes the first node and returns it
		Node retNode = head;
		head = head.getLink();
		numElements--;
		return retNode;
	}
	
	public Node getHead(){
		//returns the head node of the linked list
		return head;
	}

	public Node getTail(){
		return search(numElements - 1); //returns the tail (element in the last index)
	}

}
