/*
 * Andrew Parise
 * Feb 17th
 * 
 * 
 * 
 */



public interface MyLinkedList {
	
	public void insertHead(String info); //creates node with info then places at head
	public void insertEnd(String info); //creates node with info then places at end
	public void insertIndex(String info, int index); //creates node with info then places at index
	public int getNumElements(); //returns the number of nodes in linked list
	public boolean removeNode(int index); //removes the node at index
	public Node search(int index); //iterates through linked list and returns the node at the index
	public boolean isEmpty(); //returns true if linked list is empty, false if has > 0 nodes
	public String toString(); //returns the contents of the linked list
	
}
