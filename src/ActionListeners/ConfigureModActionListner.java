package ActionListeners;

import main.ModDetailPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigureModActionListner implements ActionListener{
	private ModDetailPanel modDetailPanel;
	public ConfigureModActionListner(ModDetailPanel modDetailPanel){
		this.modDetailPanel = modDetailPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Configured " + modDetailPanel.getMod().getModName());
	}
}
