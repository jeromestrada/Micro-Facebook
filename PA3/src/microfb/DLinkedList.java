package microfb;

/**
 * Models a Doubly Linked List using multiple Nodes.
 * @author Jerom Estrada
 *
 */
public class DLinkedList {

	/**
	 * Constructs a Doubly Linked List.
	 */
	public DLinkedList()
	{
		head = null;
		size = 0;
	}
	/**
	 * Adds a new node into this DLinkedList.
	 * @param newNode to be added into this DLinkedList.
	 */
	public void add(Node newNode)
	{
		newNode.setNext(head);
		if(head != null)
		{
			head.setPrev(newNode);
		}
		head = newNode;
		newNode.setPrev(null);
		size++;
	}
	/**
	 * Removes the Node with a Person of the given name from this DLinkedList.
	 * @param name of the Person to be removed from this DLinkedList.
	 * @return the Node that is being removed from this DLinkedList.
	 */
	public Node remove(String name)
	{
		Node pointer = head;
		Node temp = null;
		while(pointer != null)
		{
			if(pointer.getData().getName().compareTo(name) == 0)
			{
				temp = pointer;
				pointer.getPrev().setNext(pointer.getNext());
			}
			pointer = pointer.getNext();
		}
		size--;
		return temp;
	}
	/**
	 * Searches for a Node that contains a Person with the given name.
	 * @param name of the Person in the Node that is being searched for in this DLinkedList.
	 * @return the Node that is being searched for in this DLinkedList.
	 */
	public Node search(String name)
	{
		Node pointer = head;
		Node temp = null;
		while(pointer != null)
		{
			if(pointer.getData().getName().compareTo(name) == 0)
			{
				temp = pointer;
			}
			pointer = pointer.getNext();
		}
		return temp;
	}
	/**
	 * Clears this DLinkedList for a complete reset.
	 */
	public void clear()
	{
		head = null;
		size = 0;
	}
	/**
	 * Gets the current size of this DLinkedList.
	 * @return the size of this DLinkedList.
	 */
	public int getSize()
	{
		return size;
	}
	
	@Override
	public String toString()
	{
		String list = "";
		Node pointer = head;
		if(pointer.getData() != null)
		{
			list += pointer.getData().getName();
			pointer = pointer.getNext();
		}
		while(pointer != null)
		{
			list += ", " + pointer.getData().getName();
			pointer = pointer.getNext();
		}
		return list;
	}
	
	private Node head;
	private int size;
}
