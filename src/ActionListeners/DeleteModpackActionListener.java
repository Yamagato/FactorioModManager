package ActionListeners;

import main.ModpackPanel;
import main.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class DeleteModpackActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		String modpackName = (String) ModpackPanel.getModlistDropdown().getSelectedItem();
		int confirmation = JOptionPane.showConfirmDialog(null, String.format("Are you sure you want to delete %s? There is no going back after this!", modpackName), "Deleting Modpack", JOptionPane.YES_NO_OPTION);
		if(confirmation == JOptionPane.YES_OPTION){
			File modpackDirectory;
			File saveDirectory;
			if(modpackName.equals(Window.CURRENT_MODPACK)){
				JOptionPane.showMessageDialog(null, "This is your currently selected modpack. Please change to a different modpack before deleting this one.\n(I'll fix this later. For now just switch modpacks)");
				return;
				//modpackDirectory = new File(Window.FACTORIO_DIRECTORY + "\\mods - " + modpackName);
				//saveDirectory = new File(Window.FACTORIO_DIRECTORY + "\\save - " + modpackName);
			} else {
				modpackDirectory = new File(Window.FACTORIO_DIRECTORY + "\\mods - " + modpackName);
				saveDirectory = new File(Window.FACTORIO_DIRECTORY + "\\save - " + modpackName);
			}
			deleteDirectory(modpackDirectory);
			deleteDirectory(saveDirectory);
			ModpackPanel.removeFromModpackList(modpackName);
			JOptionPane.showMessageDialog(null, "Modpack " + modpackName + " deleted successfully.");
		}
	}

	private static void deleteDirectory(File directory){
		String[] files = directory.list();
		if(files !=null){
			for(String file: files){
				File currentFile = new File(directory.getPath(), file);
				if(currentFile.isDirectory()){
					deleteDirectory(currentFile);
				} else {
					currentFile.delete();
				}
			}
		}
		directory.delete();

	}
}
