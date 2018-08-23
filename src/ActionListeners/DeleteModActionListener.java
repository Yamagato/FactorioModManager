package ActionListeners;

import main.ModDetailPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteModActionListener implements ActionListener{
	private ModDetailPanel modDetailPanel;
	public DeleteModActionListener(ModDetailPanel modDetailPanel){
		this.modDetailPanel = modDetailPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Deleted " + modDetailPanel.getMod().getModName());
	}
}
