package main;

import ActionListeners.ConfigureModActionListner;
import ActionListeners.DeleteModActionListener;
import ActionListeners.DeleteModpackActionListener;
import ActionListeners.ToggleModActionListener;

import javax.swing.*;
import java.awt.*;

public class ModDetailPanel extends JPanel{
	private Mod mod;
	ModDetailPanel(Mod mod){
		super();

		this.mod = mod;
		JLabel modName = new JLabel(mod.getModName());
		JLabel modVersion = new JLabel(mod.getModVersion());
		JButton toggleModAvalability = new JButton("T");
		JButton deleteMod = new JButton("D");
		JButton configureMod = new JButton("C");

		toggleModAvalability.addActionListener(new ToggleModActionListener(this));
		deleteMod.addActionListener(new DeleteModActionListener(this));
		configureMod.addActionListener(new ConfigureModActionListner(this));

		setLayout(new GridLayout(1,5));
		add(modName);
		add(modVersion);
		add(toggleModAvalability);
		add(deleteMod);
		add(configureMod);

		setVisible(true);
	}

	public Mod getMod() {
		return mod;
	}
}
