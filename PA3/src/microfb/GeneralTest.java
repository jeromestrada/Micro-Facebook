package microfb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * General tests for all essential the methods involved in MicroFB.
 * @author Jerom Estrada
 *
 */
class GeneralTest {

	@Test
	void test() {
		/*
		 * Tests for the creation of new Persons.
		 */
		Person p4 = new Person("test4");
		Person p5 = new Person("test5");
		Person p1 = new Person("test1");
		Person p2 = new Person("test2");
		Person p3 = new Person("test3");
		
		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(p3);
		assertNotNull(p4);
		assertNotNull(p5);

		/*
		 * Tests for the creation of new Leafs.
		 */
		Leaf l1 = new Leaf(p1);
		Leaf l2 = new Leaf(p2);
		Leaf l3 = new Leaf(p3);
		Leaf l4 = new Leaf(p4);
		Leaf l5 = new Leaf(p5);
		assertNotNull(l1);
		assertNotNull(l2);
		assertNotNull(l3);
		assertNotNull(l4);
		assertNotNull(l5);
		/*
		 * Creation of a new BST.
		 */
		BinarySearchTree bst = new BinarySearchTree();
		assertNotNull(bst);
		/*
		 * Testing for insertion into the BST.
		 */
		bst.insert(l1);
		bst.insert(l2);
		bst.insert(l3);
		bst.insert(l4);
		bst.insert(l5);
		assertTrue(bst.getSize() != 0);
		/*
		 * Checking results of the insertion.
		 */
		System.out.println("Printing BST...");
		StringBuffer output = new StringBuffer("");
		bst.inorder(bst.getRoot(), output);
		System.out.println(output);
		assertNotNull(output);
		/*
		 * Testing for deletion of a leaf in the BST.
		 */
		System.out.println("\nTesting delete in BST, deleting test2...");
		bst.delete(l2);
		assertTrue(bst.getSize() == 4);
		System.out.println("\nPrinting BST after deleting...");
		output.delete(0, output.length());
		assertTrue(output.length() == 0);
		bst.inorder(bst.getRoot(), output);
		System.out.println(output);
		assertTrue(output.length() != 0);
		
		/*
		 * Tests for the contains method of the BST.
		 */
		System.out.println("\nTesting contains()...");
		System.out.println(bst.search(bst.getRoot(), "test5"));
		assertEquals(bst.search(bst.getRoot(), "test5"), l5);
		/*
		 * Testing for the functionality of the DLinkedList.
		 */
		System.out.println("\nTesting DLinkedList...");
		DLinkedList dlink = new DLinkedList();
		assertNotNull(dlink);
		/*
		 * Testing for the creation of new Nodes using the created Person objects.
		 */
		Node n1 = new Node(p1);
		Node n2 = new Node(p2);
		Node n3 = new Node(p3);
		Node n4 = new Node(p4);
		Node n5 = new Node(p5);
		assertNotNull(n1);
		assertNotNull(n2);
		assertNotNull(n3);
		assertNotNull(n4);
		assertNotNull(n5);
		
		/*
		 * Testing for the addition of new Nodes into the DLinkedList.
		 */
		dlink.add(n1);
		dlink.add(n2);
		dlink.add(n3);
		dlink.add(n4);
		dlink.add(n5);
		assertTrue(dlink.getSize() == 5);
		
		/*
		 * Testing the toString method of the DLinkedList.
		 */
		System.out.println("\nPrinting out DLinkedList...");
		System.out.println(dlink);
		
		/*
		 * Testing for the deletion of a node in the DLinkedList.
		 */
		System.out.println("\nDeleting test3...");
		dlink.remove("test3");
		System.out.println(dlink);
		assertTrue(dlink.getSize() == 4);
		
		/*
		 * Testing for the functionality of the HashTable.
		 */
		System.out.println("\nTesting hash table...");
		HashTable ht = new HashTable(3);
		assertNotNull(ht);
		/*
		 * Testing for insertion of new Persons into the HashTable.
		 */
		System.out.println("\nTesting insert/make friend...");
		ht.chainedHashInsert("Bob");
		ht.chainedHashInsert("Fish");
		ht.chainedHashInsert("Maracas");
		ht.chainedHashInsert("Korok");
		ht.chainedHashInsert("Zelda");
		assertTrue(ht.getEntries() == 5);
		/*
		 * Testing for Friending two Person in the HashTable.
		 */
		ht.chainedHashInsert("Bob", "Fish");
		ht.chainedHashInsert("Bob", "Maracas");
		ht.chainedHashInsert("Bob", "Korok");
		ht.chainedHashInsert("Bob", "Zelda");
		assertTrue(ht.chainedHashSearch("Bob").getData().getFriends().getSize() == 4);
		/*
		 * Listing one Person's friend list.
		 */
		System.out.println("\nListing friends...");
		assertNotNull(ht.listFriends("Bob"));
		System.out.println(ht.listFriends("Bob"));
		/*
		 * Checking for the areFriends method.
		 */
		System.out.println("\nChecking if two Persons are really Friends.");
		assertTrue(ht.areFriends("Bob", "Fish"));
		System.out.println(ht.areFriends("Bob", "Fish"));
		/*
		 * Testing the Unfriending method.
		 */
		System.out.println("\nTesting delete friend and areFriends immediately...");
		ht.chainedHashDelete("Bob", "Fish");
		System.out.println(ht.areFriends("Bob", "Fish"));
		assertFalse(ht.areFriends("Bob", "Fish"));
		/*
		 * Testing for the toString method of the HashTable.
		 */
		System.out.println("\n" + ht);
		
		/*
		 * Relisting the Friend list of a Person after deletion of one.
		 */
		System.out.println("\nListing friends...");
		assertTrue(ht.chainedHashSearch("Bob").getData().getFriends().getSize() == 3);
		System.out.println(ht.listFriends("Bob"));
	}

}
