package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ModlistPanel extends JPanel {
	ModlistPanel(){
		super();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel headings = new JPanel();
		headings.setLayout(new GridLayout(1,5));
		headings.add(new JLabel("Mod Name", SwingConstants.CENTER));
		headings.add(new JLabel("Mod Version", SwingConstants.CENTER));
		headings.add(new JLabel("Toggle Mod", SwingConstants.CENTER));
		headings.add(new JLabel("Configure Mod", SwingConstants.CENTER));
		headings.add(new JLabel("Delete Mod", SwingConstants.CENTER));
		add(headings);
		ArrayList<Mod> modList = detectMods();

		for(Mod mod : modList){
			ModDetailPanel modDetailPanel = new ModDetailPanel(mod);
			add(modDetailPanel);
		}
		setVisible(true);
	}

	private static ArrayList<Mod> detectMods(){
		ArrayList<Mod> mods = new ArrayList<>();
		for(int i=0; i<50; i++){
			mods.add(new Mod(Integer.toString(i), Integer.toHexString(i), "0.16", "blah"));
		}
		return mods;
	}

}
