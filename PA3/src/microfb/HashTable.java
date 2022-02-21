package microfb;

/**
 * Models a Hash Table of DLinkedList that lists several Persons with the given size.
 * @author Jerom Estrada
 *
 */
public class HashTable {
	/**
	 * Constructs a new empty HashTable with the given size.
	 * @param tableSize to set the HashTable with.
	 */
	public HashTable(int tableSize)
	{
		table = new DLinkedList[tableSize];
		for(int i = 0; i < tableSize; i++)
		{
			table[i] = new DLinkedList();
		}
		this.tableSize = tableSize;
		this.entries = 0;
	}
	/**
	 * Inserts a new Person with the given name into this HashTable.
	 * @param name of the Person being inserted into the HashTable.
	 */
	public void chainedHashInsert(String name)
	{
		Person person = new Person(name);
		Node node = new Node(person);
		table[(int)hash(name)].add(node);
		entries++;
	}
	/**
	 * Deletes a Person with the given name in this HashTable.
	 * @param name of the Person to be deleted in this HashTable.
	 * @return the Node that contains the Person being deleted.
	 */
	public Node chainedHashDelete(String name)
	{
		Node temp = table[(int)hash(name)].remove(name);
		if(temp != null)
		{
			entries--;
		}
		return temp;
	}
	/*
	 * The two following methods are overloaded versions of the two previous ones.
	 * They are overloaded to simplify the API of this HashTable.
	 */
	/**
	 * Overloaded insertion that creates a Friend relationship between two Persons in the HashTable.
	 * @param person1 for Friending.
	 * @param person2 for Friending.
	 */
	public void chainedHashInsert(String person1, String person2)
	{
		Node node1 = chainedHashSearch(person1);
		Node node2 = chainedHashSearch(person2);
		// That means both exists
		if(node1 != null && node2 != null)
		{
			node1.getData().getFriends().insert(new Leaf(node2.getData()));
			node2.getData().getFriends().insert(new Leaf(node1.getData()));
		}
	}
	/**
	 * Overloaded deletion that removes a Friend relationship between two Persons in the HashTable.
	 * @param person1 for Unfriending.
	 * @param person2 for Unfriending.
	 */
	public void chainedHashDelete(String person1, String person2)
	{
		Node node1 = chainedHashSearch(person1);
		Node node2 = chainedHashSearch(person2);

		// This checks if they both exist.
		if(node1 != null && node2 != null)
		{
			BinarySearchTree tree1 = node1.getData().getFriends();
			BinarySearchTree tree2 = node2.getData().getFriends();
			node1.getData().getFriends().delete(tree1.search(tree1.getRoot(), person2));
			node2.getData().getFriends().delete(tree2.search(tree2.getRoot(), person1));
		}
	}
	/**
	 * Searches for a Person with the given name in this HashTable.
	 * @param name of the Person being searched in this HashTable.
	 * @return the Node that contains the Person searched in this HashTable.
	 */
	public Node chainedHashSearch(String name)
	{
		return table[(int)hash(name)].search(name);
	}
	/**
	 * Checks the HashTable with the two given names of Persons for a Friend relationship.
	 * @param person1 being checked.
	 * @param person2 being checked.
	 * @return
	 */
	public boolean areFriends(String person1, String person2)
	{
		Node node1 = chainedHashSearch(person1);
		Node node2 = chainedHashSearch(person2);
		// That means both exists
		if(node1 != null && node2 != null)
		{
			Leaf root1 = node1.getData().getFriends().getRoot();
			Leaf root2 = node2.getData().getFriends().getRoot();
			if(node1.getData().getFriends().search(root1, person2) != null
					&& node2.getData().getFriends().search(root2, person1) != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}
	/**
	 * Lists the list of Friends of a Person in this HashTable.
	 * @param person name of the Person listing the Friends from.
	 * @return a String Buffer that contains the list of names of the Friends of the Person with the given name.
	 */
	public StringBuffer listFriends(String person)
	{
		StringBuffer output = new StringBuffer("");
		Node node = chainedHashSearch(person);
		if(node != null && node.getData().getFriends().getSize() != 0)
		{
			Leaf leaf = node.getData().getFriends().getRoot();
			node.getData().getFriends().inorder(leaf, output);
		}
		return output;
	}
	/**
	 * Simple hashing function that uses ASCII values and a set base.
	 * @param string to be hashed.
	 * @return a long from the hashing.
	 */
	public long hash(String string)
	{
		long hashcode = 0;
		for(int i = string.length()-1, j = 0; i >= 0; i--, j++)
		{
			hashcode += (long)(string.charAt(j) * Math.pow(27, i)); // 27 seems to distribute the names better.
		}
		return hashcode%tableSize;
	}
	/**
	 * Returns the current number of entries in this HashTable.
	 * @return entries of this HashTable.
	 */
	public int getEntries()
	{
		return entries;
	}
	@Override
	public String toString()
	{
		String list = "Hash Table:\n";
		
		for(int i = 0; i < tableSize; i++)
		{
			list += i + ": ";
			if(table[i].getSize() != 0)
			{
				list += table[i].toString();
			}
			list += "\n";
		}
		return list;
	}
	
	private DLinkedList[] table;
	private int tableSize;
	private int entries;

}
