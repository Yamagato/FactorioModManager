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
		JOptionPane.showMessageDialog(null, "Switching active modpack to " + ModpackPanel.getModlistDropdown().getSelectedItem());
		if(switchMods(Window.CURRENT_MODPACK, (String) ModpackPanel.getModlistDropdown().getSelectedItem())){
			if(switchSaves(Window.CURRENT_MODPACK, (String) ModpackPanel.getModlistDropdown().getSelectedItem())){
				JOptionPane.showMessageDialog(null, "Switching active modpack to " + ModpackPanel.getModlistDropdown().getSelectedItem() + " has been successful!");
			}else{
				JOptionPane.showMessageDialog(null, "Switching saves unsuccessful, attempting to revert");
				if(switchMods((String) ModpackPanel.getModlistDropdown().getSelectedItem(),Window.CURRENT_MODPACK))
					JOptionPane.showMessageDialog(null, "Reverting mods folder successful");
			}
		} else{
			JOptionPane.showMessageDialog(null, "Switching mods unsuccessful");
		}
	}

	private boolean switchMods(String oldModpack, String newModpack){
		File oldMods = new File(Window.FACTORIO_DIRECTORY + "\\mods");
		File shelvedMods = new File(Window.FACTORIO_DIRECTORY + "\\mods - " + oldModpack);
		boolean s1 = oldMods.renameTo(shelvedMods);

		File newMods = new File(Window.FACTORIO_DIRECTORY + "\\mods - " + newModpack);
		File activeMods = new File(Window.FACTORIO_DIRECTORY + "\\mods");
		boolean s2 = newMods.renameTo(activeMods);

		return s1 && s2;
	}

	private boolean switchSaves(String oldModpack, String newModpack){
		File oldSaves = new File(Window.FACTORIO_DIRECTORY + "\\saves");
		File shelvedSaves = new File(Window.FACTORIO_DIRECTORY + "\\saves - " + oldModpack);
		boolean s1 = oldSaves.renameTo(shelvedSaves);

		File newSaves = new File(Window.FACTORIO_DIRECTORY + "\\saves - " + newModpack);
		File activeSaves = new File(Window.FACTORIO_DIRECTORY + "\\saves");
		boolean s2 = newSaves.renameTo(activeSaves);

		return s1 && s2;
	}
}
