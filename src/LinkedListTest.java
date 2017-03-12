import java.util.regex.Pattern;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyLinkedListClass linkedList = new MyLinkedListClass();
		
		
		if(linkedList.isEmpty()){ //test to see if the list is empty
			System.out.println("The Linked List is currently empty.");
		}
		
		
		//Sample Data
		String nameList = "James John Michael Peter Allison Daniel George Simon Jason Mark";
		final String[] studentNameList = nameList.split(Pattern.quote(" "));
		
		//Populate the Linked List
		for(int i = 0; i < studentNameList.length; i++){
			//System.out.println(studentNameList[i] + " adding at end of Linked List");
			linkedList.insertEnd(studentNameList[i]);
		}
		
		System.out.println(linkedList.toString()); //Linked List should be full of student names at this point

		
		System.out.println("Linked List currently has " + linkedList.getNumElements() + " elements."); //Using sample data above, should be 10
		
		linkedList.removeNode(1); //remove second node
		
		//Confirm
		System.out.println(linkedList.toString());
		System.out.println("Linked List currently has " + linkedList.getNumElements() + " elements.");
		
		linkedList.removeNode(8); //remove the 9th (last) node
		
		//confirm
		System.out.println(linkedList.toString());
		System.out.println("Linked List currently has " + linkedList.getNumElements() + " elements.");
		
		linkedList.insertHead("Jimmy"); //add new node at head
		
		//confirm
		System.out.println(linkedList.toString());
		System.out.println("Linked List currently has " + linkedList.getNumElements() + " elements.");
		
		linkedList.insertEnd("Justin"); //add new node at end
		
		//confirm
		System.out.println(linkedList.toString());
		System.out.println("Linked List currently has " + linkedList.getNumElements() + " elements.");
		
		if(linkedList.isEmpty()){ //test to see if the list is empty
			System.out.println("The Linked List is currently empty.");
		}
		System.out.println("The node at the third index is: " + linkedList.search(2).getInfo());
		
		
	}

}
