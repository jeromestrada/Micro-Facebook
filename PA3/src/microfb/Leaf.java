package microfb;

/**
 * Models a Leaf for Trees that contains a Person object.
 * @author Jerom Estrada
 *
 */
public class Leaf{
	/**
	 * Constructs a new Leaf with the given Person.
	 * @param data contains a Person to be set for this new Leaf.
	 */
	public Leaf(Person data)
	{
		this.data = data;
		this.parent = null;
		this.left = null;
		this.right = null;
	}
	/**
	 * Sets the data of this Leaf with the given new data.
	 * @param newData to be set for this Leaf.
	 */
	public void setData(Person newData)
	{
		this.data = newData;
	}
	/**
	 * Gets the data of this Leaf.
	 * @return the data of this Leaf.
	 */
	public Person getData()
	{
		return this.data;
	}
	/**
	 * Sets the parent leaf of this Leaf with the given parent leaf.
	 * @param parent to be set for this Leaf.
	 */
	public void setParent(Leaf parent)
	{
		this.parent = parent;
	}
	/**
	 * Gets the parent leaf of this Leaf.
	 * @return parent leaf of this Leaf.
	 */
	public Leaf getParent()
	{
		return this.parent;
	}
	/**
	 * Sets the left leaf of this Leaf with the given left leaf.
	 * @param left to be set for this Leaf.
	 */
	public void setLeft(Leaf left)
	{
		this.left = left;
	}
	/**
	 * Gets the left leaf of this Leaf.
	 * @return left leaf of this Leaf.
	 */
	public Leaf getLeft()
	{
		return this.left;
	}
	/**
	 * Sets the right leaf of this Leaf with the given right leaf.
	 * @param right to be set for this Leaf.
	 */
	public void setRight(Leaf right)
	{
		this.right = right;
	}
	/**
	 * Gets the right leaf of this Leaf.
	 * @return right leaf of this Leaf.
	 */
	public Leaf getRight()
	{
		return this.right;
	}
	/**
	 * Returns the data of this Leaf in String format.
	 */
	public String toString()
	{
		return data.toString();
	}
	
	private Person data;
	private Leaf parent;
	private Leaf left;
	private Leaf right;
}
