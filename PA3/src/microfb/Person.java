package microfb;

public class Person {

	public Person(String name)
	{
		this.name = name;
		friends = new BinarySearchTree();
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return name;
	}
	
	public BinarySearchTree getFriends()
	{
		return friends;
	}
	
	private String name;
	private BinarySearchTree friends;
}
