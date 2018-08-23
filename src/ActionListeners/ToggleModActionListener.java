package ActionListeners;

import main.ModDetailPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToggleModActionListener implements ActionListener {
	private ModDetailPanel modDetailPanel;
	public ToggleModActionListener(ModDetailPanel modDetailPanel){
		this.modDetailPanel = modDetailPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Toggled " + modDetailPanel.getMod().getModName());
	}
}
