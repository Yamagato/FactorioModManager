package ActionListeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class NewModpackActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] availableVersions = new String[]{"0.16"};

		//String modpackVersion = JOptionPane.showInputDialog(null, "Select your Factorio Version", "Factorio Version", JOptionPane.PLAIN_MESSAGE, null , availableVersions );

		String modpackName = JOptionPane.showInputDialog("Creating a new Modpack: Enter the name");

		if(modpackName==null || modpackName.equals("")){
			JOptionPane.showMessageDialog(null, "You've not entered a name. New modpack will not be created.");
			return;
		}
		JOptionPane.showMessageDialog(new JFrame() , "You've named your new modpack: " + modpackName );
	}
}
