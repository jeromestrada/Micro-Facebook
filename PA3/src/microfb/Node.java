package microfb;

/**
 * Models a Node that contains a Person object and allows for chaining with other Nodes.
 * @author Jerom Estrada
 *
 */
public class Node {

	/**
	 * Constructs a new Node with the given data.
	 * @param data in this Node containing a Person.
	 */
	public Node(Person data)
	{
		this.data = data;
		next = null;
		prev = null;
	}
	/**
	 * Sets the data of this Node with the new data.
	 * @param newData to be set for this Node.
	 */
	public void setData(Person newData)
	{
		data = newData;
	}
	/**
	 * Gets the data of this Node.
	 * @return the data of this Node.
	 */
	public Person getData()
	{
		return data;
	}
	/**
	 * Sets the next Node connected to this Node with the given node.
	 * @param next node to be set for this Node.
	 */
	public void setNext(Node next)
	{
		this.next = next;
	}
	/**
	 * Gets the next node connected to this Node.
	 * @return the next node of this Node.
	 */
	public Node getNext()
	{
		return next;
	}
	/**
	 * Sets the previous node connected to this Node with the given node.
	 * @param prev node to be set for this Node.
	 */
	public void setPrev(Node prev)
	{
		this.prev = prev;
	}
	/**
	 * Gets the previous node connected to this Node.
	 * @return the previous node of this Node.
	 */
	public Node getPrev()
	{
		return prev;
	}
	/**
	 * Returns the data of this Node in String format.
	 */
	public String toString()
	{
		return data.getName();
	}
	
	private Person data;
	private Node next;
	private Node prev;
}
