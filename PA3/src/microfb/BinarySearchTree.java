package microfb;

/**
 * Models a Binary Search Tree that contains several Leaf objects.
 * @author Jerom Estrada
 *
 */
public class BinarySearchTree {
	/**
	 * Constructs a new empty BinarySearchTree.
	 */
	public BinarySearchTree()
	{
		root = null;
		treeSize = 0;
	}
	/**
	 * Inserts a new Leaf into this BinarySearchTree.
	 * @param newLeaf to be inserted into this BinarySearchTree.
	 */
	public void insert(Leaf newLeaf)
	{
		Leaf trailingPointer = null;
		Leaf pointer = root;
		
		while(pointer != null)
		{
			trailingPointer = pointer;
			if(newLeaf.getData().getName().compareTo(pointer.getData().getName()) < 0)
			{
				pointer = pointer.getLeft();
			}
			else
			{
				pointer = pointer.getRight();
			}
		}
		newLeaf.setParent(trailingPointer);
		if(trailingPointer == null)
		{
			root = newLeaf;
		}
		else if(newLeaf.getData().getName().compareTo(trailingPointer.getData().getName()) < 0)
		{
			trailingPointer.setLeft(newLeaf);
		}
		else
		{
			trailingPointer.setRight(newLeaf);
		}
		treeSize++;
	}
	/**
	 * Deletes the target Leaf from this BinarySearchTree.
	 * @param target to be deleted in this BinarySearchTree.
	 */
	public void delete(Leaf target)
	{
		if(target.getLeft() == null)
		{
			this.transplant(target, target.getRight());
		}
		else if(target.getRight() == null)
		{
			this.transplant(target, target.getLeft());
		}
		else
		{
			Leaf successor = this.minimum(target.getRight());
			if(successor.getParent() != target)
			{
				this.transplant(successor, successor.getRight());
				successor.setRight(target.getRight());
				successor.getRight().setParent(successor);
			}
			
			this.transplant(target, successor);
			successor.setLeft(target.getLeft());
			successor.getLeft().setParent(successor);
		}
		treeSize--;
	}
	/**
	 * Transplants a donor subtree into the recipient subtree in this BinarySearchTree.
	 * @param recipient subtree of this BinarySearchTree.
	 * @param donor subtree for this BinarySearchTree.
	 */
	public void transplant(Leaf recipient, Leaf donor)
	{
		if(recipient.getParent() == null)
		{
			root = donor;
		}
		else if(recipient == recipient.getParent().getLeft())
		{
			recipient.getParent().setLeft(donor);
		}
		else
		{
			recipient.getParent().setRight(donor);
		}
		if(donor != null)
		{
			donor.setParent(recipient.getParent());
		}
	}
	/**
	 * Stores the String format of every leaf in this BinarySearchTree into a String Buffer in an Inorder manner.
	 * @param start leaf of the tree being printed in this BinarySearchTree.
	 * @param output is a String Buffer that is passed into the recursive calls of the Inorder algorithm.
	 */
	public void inorder(Leaf start, StringBuffer output)
	{
		if(start != null)
		{
			inorder(start.getLeft(), output);
			if(output.length() == 0)
			{
				output.append(start.toString());
			}
			else
			{
				output.append(", " + start.toString());
			}
			inorder(start.getRight(), output);
		}
	}
	/**
	 * Gets the minimum leaf in this BinarySearchTree.
	 * @param subtree of this BinarySearchTree that the minimum leaf is being searched.
	 * @return the minimum Leaf that is found.
	 */
	public Leaf minimum(Leaf subtree)
	{
		while(subtree.getLeft() != null)
		{
			subtree = subtree.getLeft();
		}
		return subtree;
	}
	/**
	 * Gets the maximum leaf in this BinarySearchTree.
	 * @param subtree subtree of this BinarySearchTree that the maximum leaf is being searched.
	 * @return the maximum Leaf that is found.
	 */
	public Leaf maximum(Leaf subtree)
	{
		while(subtree.getRight() != null)
		{
			subtree = subtree.getRight();
		}
		return subtree;
	}
	/**
	 * Searches for a Leaf that contains a Person with the given name in this BinarySearchTree from the given pointer.
	 * @param pointer to start the search for the Leaf.
	 * @param name of the Person in the Leaf.
	 * @return
	 */
	public Leaf search(Leaf pointer, String name)
	{
		if(pointer == null || pointer.getData().getName().compareTo(name) == 0)
		{
			return pointer;
		}
		if(name.compareTo(pointer.getData().getName()) < 0)
		{
			return search(pointer.getLeft(), name);
		}
		else
		{
			return search(pointer.getRight(), name);
		}
	}
	/**
	 * Gets the root of this BinarySearchTree.
	 * @return the root of this BinarySearchTree.
	 */
	public Leaf getRoot()
	{
		return root;
	}
	/**
	 * Gets the current size of this BinarySearchTree.
	 * @return the current size of this BinarySearchTree.
	 */
	public int getSize()
	{
		return treeSize;
	}
	
	private Leaf root;
	private int treeSize;

}
