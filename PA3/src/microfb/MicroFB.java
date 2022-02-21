package microfb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Models a micro version of Facebook using a HashTable.
 * @author Jerom Estrada
 *
 */
public class MicroFB implements ActionListener{
	
	/**
	 * Initializes the HashTable with the common names.
	 */
	public static void initializeNames()
	{
		// Put the 50 names into the hash table.
		for(int i = 0; i < 50; i++)
		{
			names.chainedHashInsert(commonNames[i]);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * The following are executed from performing certain actions in the GUI.
		 */
		if(e.getSource() == displayNamesButton)
		{
			 namesTextArea.setText(names.toString());
			 namesTextArea.setCaretPosition(0);
		}
		if(e.getSource() == friendCheckButton && !friendCheckField1.getText().equals("")
				&& !friendCheckField2.getText().equals(""))
		{
			String name1 = friendCheckField1.getText();
			String name2 = friendCheckField2.getText();
			
			if(names.areFriends(name1, name2))
			{
				friendCheckResultLabel.setText(name1 + " and " + name2 + " are friends!");
			}
			else
			{
				friendCheckResultLabel.setText("Unfortunately, " + name1 + " and " + name2 + " are not friends!");
			}
		}
		if(e.getSource() == makeFriendsButton && !friendCheckField1.getText().equals("")
				&& !friendCheckField2.getText().equals(""))
		{
			String name1 = friendCheckField1.getText();
			String name2 = friendCheckField2.getText();
			
			names.chainedHashInsert(name1, name2);
			friendCheckResultLabel.setText(name1 + " and " + name2 + " are now friends!");
		}
		
		if(e.getSource() == unfriendButton && !friendCheckField1.getText().equals("")
				&& !friendCheckField2.getText().equals(""))
		{
			String name1 = friendCheckField1.getText();
			String name2 = friendCheckField2.getText();
			
			names.chainedHashDelete(name1, name2);
			friendCheckResultLabel.setText(name1 + " and " + name2 + " are not friends anymore!");
		}
		
		if(e.getSource() == listFriendsButton && !addRemoveNameField.getText().equals(""))
		{
			String name = addRemoveNameField.getText();
			String output = names.listFriends(name).toString();
			friendListArea.setText(output);
		}
		
		if(e.getSource() == addNameButton && !addRemoveNameField.getText().equals(""))
		{
			String name = addRemoveNameField.getText();
			names.chainedHashInsert(name);
			addRemoveResult.setText(name + " is added into the Hash Table!");
		}
		
		if(e.getSource() == removeNameButton && !addRemoveNameField.getText().equals(""))
		{
			String name = addRemoveNameField.getText();
			names.chainedHashInsert(name);
			addRemoveResult.setText(name + " is removed from the Hash Table!");
		}
		
	}
	
	/*
	 * List of GUI objects.
	 */
	private static JPanel panel;
	private static JFrame frame;
	
	private static JLabel namesLabel;
	private static JTextArea namesTextArea;
	private static JButton displayNamesButton;
	private static JScrollPane namesScrollPane;
	
	private static JLabel friendCheckLabel1;
	private static JTextField friendCheckField1;
	private static JLabel friendCheckLabel2;
	private static JTextField friendCheckField2;
	private static JLabel friendCheckResultLabel;
	private static JButton friendCheckButton;
	private static JButton makeFriendsButton;
	private static JButton unfriendButton;
	
	private static JLabel addRemoveLabel;
	
	private static JLabel addRemoveNameLabel;
	private static JTextField addRemoveNameField;
	private static JButton addNameButton;
	private static JButton removeNameButton;
	private static JLabel addRemoveResult;
	
	private static JButton listFriendsButton;
	private static JTextArea friendListArea;
	private static JScrollPane friendListScrollPane;
	private static JLabel friendListLabel;
	
	
	private static HashTable names = new HashTable(50);
	// List of 50 common names
	private static String [] commonNames = 
		{ "Liam", "Emma",
			"Noah", "Olivia",
			"William", "Ava",
			"James", "Isabella",
			"Logan", "Sophia",
			"Benjamin", "Mia",
			"Mason", "Charlotte",
			"Elijah", "Amelia",
			"Oliver", "Evelyn",
			"Jacob", "Abigail",
			"Lucas", "Harper",
			"Michael", "Emily",
			"Alexander", "Elizabeth",
			"Ethan", "Avery",
			"Daniel", "Sofia",
			"Matthew", "Ella",
			"Aiden", "Madison",
			"Henry", "Scarlett",
			"Joseph", "Victoria",
			"Jackson", "Aria",
			"Samuel", "Grace",
			"Sebastian", "Chloe",
			"David", "Camila",
			"Carter", "Penelope",
			"Wyatt", "Riley"};
	
	/*
	 * Main program that runs the MicroFB.
	 */
	public static void main(String [] args)
	{
		initializeNames(); // calls the initialization of the HashTable.
		
		// Generate the frame of the GUI.
		panel = new JPanel();
		panel.setLayout(null);
		frame = new JFrame("Micro Facebook");
		frame.setLocation(300, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 525);
		frame.setResizable(false);
		frame.add(panel);
		
		/*
		 * The following are code to paint the GUI in the frame.
		 */
		namesLabel = new JLabel("Names:");
		namesLabel.setBounds(25, 25, 80, 25);
		panel.add(namesLabel);
		
		namesTextArea = new JTextArea("");
		namesTextArea.setBounds(25, 60, 200, 400);
		namesTextArea.setEditable(false);
		panel.add(namesTextArea);
		
		namesScrollPane = new JScrollPane(namesTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		namesScrollPane.setBounds(25, 60, 200, 400);
		panel.add(namesScrollPane);
		
		displayNamesButton = new JButton("Display Hash Table");
		displayNamesButton.setBounds(250, 400, 200, 25);
		displayNamesButton.addActionListener(new MicroFB());
		panel.add(displayNamesButton);
		
		friendCheckLabel1 = new JLabel("Name: ");
		friendCheckLabel1.setBounds(250, 60, 60, 25);
		panel.add(friendCheckLabel1);
		
		friendCheckField1 = new JTextField("");
		friendCheckField1.setBounds(300, 60, 100, 25);
		panel.add(friendCheckField1);
		
		friendCheckLabel2 = new JLabel("Name: ");
		friendCheckLabel2.setBounds(420, 60, 60, 25);
		panel.add(friendCheckLabel2);
		
		friendCheckField2 = new JTextField("");
		friendCheckField2.setBounds(470, 60, 100, 25);
		panel.add(friendCheckField2);
		
		friendCheckButton = new JButton("Friend Check");
		friendCheckButton.setBounds(250, 100, 120, 25);
		friendCheckButton.addActionListener(new MicroFB());
		panel.add(friendCheckButton);
		
		makeFriendsButton = new JButton("Make Friends");
		makeFriendsButton.setBounds(400, 100, 120, 25);
		makeFriendsButton.addActionListener(new MicroFB());
		panel.add(makeFriendsButton);
		
		unfriendButton = new JButton("Unfriend");
		unfriendButton.setBounds(550, 100, 120, 25);
		unfriendButton.addActionListener(new MicroFB());
		panel.add(unfriendButton);
		
		friendCheckResultLabel = new JLabel("");
		friendCheckResultLabel.setBounds(275, 135, 350, 25);
		panel.add(friendCheckResultLabel);
		
		addRemoveLabel = new JLabel("Add / Remove Names and List Friends");
		addRemoveLabel.setBounds(250, 170, 250, 25);
		panel.add(addRemoveLabel);
		
		addRemoveNameLabel = new JLabel("Name: ");
		addRemoveNameLabel.setBounds(250, 200, 50, 25);
		panel.add(addRemoveNameLabel);
		
		addRemoveNameField = new JTextField("");
		addRemoveNameField.setBounds(300, 200, 100, 25);
		panel.add(addRemoveNameField);
		
		addRemoveResult = new JLabel("");
		addRemoveResult.setBounds(415, 200, 275, 25);
		panel.add(addRemoveResult);
		
		addNameButton = new JButton("Add");
		addNameButton.setBounds(250, 240, 120, 25);
		addNameButton.addActionListener(new MicroFB());
		panel.add(addNameButton);
		
		removeNameButton = new JButton("Remove");
		removeNameButton.setBounds(400, 240, 120, 25);
		removeNameButton.addActionListener(new MicroFB());
		panel.add(removeNameButton);
		
		listFriendsButton = new JButton("List Friends");
		listFriendsButton.setBounds(550, 240, 120, 25);
		listFriendsButton.addActionListener(new MicroFB());
		panel.add(listFriendsButton);
		
		friendListLabel = new JLabel("Friend List:");
		friendListLabel.setBounds(250, 275, 80, 25);
		panel.add(friendListLabel);
		
		friendListArea = new JTextArea("");
		friendListArea.setBounds(250, 300, 400, 50);
		friendListArea.setEditable(false);
		panel.add(friendListArea);
		
		friendListScrollPane = new JScrollPane(friendListArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		friendListScrollPane.setBounds(250, 300, 400, 50);
		panel.add(friendListScrollPane);
		
		
		
		frame.setVisible(true);
	}

	
}
