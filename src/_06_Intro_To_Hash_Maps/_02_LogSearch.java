package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons.
	 *
	 * Button 1: Add Entry When this button is clicked, use an input dialog to ask
	 * the user to enter an ID number. After an ID is entered, use another input
	 * dialog to ask the user to enter a name. Add this information as a new entry
	 * to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 */

	HashMap<Integer, String> NameHash = new HashMap<Integer, String>();
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	JButton jb1 = new JButton();
	JButton jb2 = new JButton();
	JButton jb3 = new JButton();
	JButton jb4 = new JButton();

	public void run() {

		jp.add(jb1);
		jp.add(jb4);
		jp.add(jb2);
		jp.add(jb3);

		jf.add(jp);
		jf.setVisible(true);
		jf.setSize(200, 175);

		jb1.setText("Add Entry");
		jb2.setText("Search by ID");
		jb3.setText("View List");
		jb4.setText("Remove Entry");
		jf.setTitle("Menu");

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);

		jb1.setFocusable(false);
		jb2.setFocusable(false);
		jb3.setFocusable(false);
		jb4.setFocusable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jb1) {
			String entryvs = JOptionPane.showInputDialog("Please enter an ID number to be connected with the name.");

			int entryv = Integer.parseInt(entryvs);
			String entryS = JOptionPane.showInputDialog("Please enter a valid name.");
			NameHash.put(entryv, entryS);

		}
		if (e.getSource() == jb2) {
			String searchidstr = JOptionPane.showInputDialog("Enter a valid ID.");
			int searchid = Integer.parseInt(searchidstr);
			if (NameHash.containsKey(searchid)) {
				JOptionPane.showMessageDialog(null, "ID: " + searchid + "\nName: " + NameHash.get(searchid),
						"Search ID", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Sorry, Invalid ID number. Try again.", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if (e.getSource() == jb3) {

			String string = "";
			for (int id : NameHash.keySet()) {
				string = string + "Id: " + id + " | Name: " + NameHash.get(id) + "\n";
			}

			JOptionPane.showMessageDialog(null, string, "View List", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == jb4) {
			String removes = JOptionPane.showInputDialog("Please neter the ID of the entry you would like to remove");
			int remove = Integer.parseInt(removes);
			if (NameHash.containsKey(remove)) {
				JOptionPane
						.showMessageDialog(
								null, "The following entry was sucessfully removed.\n Entry: ID: " + remove
										+ " | Name: " + NameHash.get(remove),
								"Entry Removed", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Failed to remove Entry: Entry or ID does not exist or is invalid.",
						"Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

}
