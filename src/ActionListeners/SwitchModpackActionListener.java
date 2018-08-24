package ActionListeners;

import main.ModpackPanel;
import main.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SwitchModpackActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Window.CURRENT_MODPACK == ModpackPanel.getModlistDropdown().getSelectedItem()) return;
		JOptionPane.showMessageDialog(null, "Switching active modpack to " + ModpackPanel.getModlistDropdown().getSelectedItem());
		if(switchMods(Window.CURRENT_MODPACK, (String) ModpackPanel.getModlistDropdown().getSelectedItem())){
			if(switchSaves(Window.CURRENT_MODPACK, (String) ModpackPanel.getModlistDropdown().getSelectedItem())){
				JOptionPane.showMessageDialog(null, "Switching active modpack to " + ModpackPanel.getModlistDropdown().getSelectedItem() + " has been successful!");
			}else{
				JOptionPane.showMessageDialog(null, "Switching save folder unsuccessful, attempting to revert");
				if(switchMods((String) ModpackPanel.getModlistDropdown().getSelectedItem(), Window.CURRENT_MODPACK))
					JOptionPane.showMessageDialog(null, "Reverting mod folder successful");
			}
		} else{
			JOptionPane.showMessageDialog(null, "Switching mod folders unsuccessful");
		}
		Window.refreshCurrentModpack();
	}

	private static boolean switchMods(String oldModpack, String newModpack) {
		boolean s1 = false;
		boolean s2 = false;
		File oldMods = new File(Window.FACTORIO_DIRECTORY + "\\mods");
		File shelvedMods = new File(Window.FACTORIO_DIRECTORY + "\\mods - " + oldModpack);
		if (!oldMods.canWrite())
		{
			System.out.println("Cannot write destination file!!");
		} else{
			s1 = oldMods.renameTo(shelvedMods);
		}


		File newMods = new File(Window.FACTORIO_DIRECTORY + "\\mods - " + newModpack);
		File activeMods = new File(Window.FACTORIO_DIRECTORY + "\\mods");
		if (!newMods.canWrite())
		{
			System.out.println("Cannot write destination file!!");
		} else {
			s2 = newMods.renameTo(activeMods);
		}
		return s1 && s2;
	}

	private static boolean switchSaves(String oldModpack, String newModpack){
		File oldSaves = new File(Window.FACTORIO_DIRECTORY + "\\saves");
		File shelvedSaves = new File(Window.FACTORIO_DIRECTORY + "\\saves - " + oldModpack);
		boolean s1 = oldSaves.renameTo(shelvedSaves);

		File newSaves = new File(Window.FACTORIO_DIRECTORY + "\\saves - " + newModpack);
		File activeSaves = new File(Window.FACTORIO_DIRECTORY + "\\saves");
		boolean s2 = newSaves.renameTo(activeSaves);

		return s1 && s2;
	}
}
