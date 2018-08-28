package ActionListeners;

import main.ModpackPanel;
import main.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NewModpackActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//String[] availableVersions = new String[]{"0.16"};
		//String modpackVersion = JOptionPane.showInputDialog(null, "Select your Factorio Version", "Factorio Version", JOptionPane.PLAIN_MESSAGE, null , availableVersions );
		boolean nameNotUniqueOrEmpty = true;
		String modpackName="";
		while(nameNotUniqueOrEmpty) {
			modpackName = JOptionPane.showInputDialog("Enter a name for the modpack:", "Creating new modpack...");
			if(modpackName == null){
				return;
			}else if (modpackName.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter a modpack name or press cancel", "Failure!");
			} else if(checkIfModpackExists(modpackName)){
				JOptionPane.showMessageDialog(null, String.format("Modpack names %s already exists. Please choose a different name", modpackName));
			} else {
				JOptionPane.showMessageDialog(null, modpackName + " modpack has been created! ", "Success!");
				nameNotUniqueOrEmpty = false;
			}
		}

		File modFolder = new File(Window.FACTORIO_DIRECTORY + "\\mods - " + modpackName);
		File modpackNameFile = new File(Window.FACTORIO_DIRECTORY + "\\mods - " + modpackName + "\\modpackname.txt");
		File savesFolder = new File(Window.FACTORIO_DIRECTORY + "\\saves - " + modpackName);
		try {
			if (modFolder.mkdirs() && modpackNameFile.createNewFile() && savesFolder.mkdirs()) {
				FileWriter writer = new FileWriter(modpackNameFile);
				writer.write(modpackName);
				writer.close();
				JOptionPane.showMessageDialog(null, modpackName + "was created.", "Success!");
				ModpackPanel.addToModpackList(modpackName);
			} else {
				JOptionPane.showMessageDialog(null, "Failed to create modpack with the name of " + modpackName, "Failure!");
			}
		}catch (IOException ignored){
			JOptionPane.showMessageDialog(null, "Modpack creation failed");
		}
	}

	private static boolean checkIfModpackExists(String proposedModpackName){
		String[] modpackNames = ModpackPanel.getModpackList();
		for (String modpackName : modpackNames) {
			if (modpackName.equals(proposedModpackName)) return true;
		}
		return false;
	}
}
