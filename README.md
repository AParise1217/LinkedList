# LinkedList
JAVA implementation of the linked list data structure.

Project completed on Feb 17th 2016

------------------------------------------------------------------
Assignment Overview:

"This programming exercise introduces the linked lists data structure. 
The students must create all the necessary methods for the linked list and use the 
linked list in a Java program."

MyLinkedListClass.java
 Implementation of a linked list, 
 		which is a sequence of nodes containing some string of data, 
 		and a pointer (referred to as a link in my code)

# Releasing to Maven Central
## Performing a Release Deployment
*Note: This must occur prior to the Release Deployment!*

Make sure the "release-sign-artifacts" and "ossrh" 
    Maven profiles are active.

1) `mvn clean`
2) `mvn release:prepare -Possrh,release-sign-artifacts`
3) `mvn release:perform -Possrh,release-sign-artifacts`

* await the release process to finish *

4) `git push --tags`
5) `git push origin master`

## Updating the Release Version
1) `mvn versions:set -DnewVersion=1.2.3`