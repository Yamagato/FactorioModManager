import javax.swing.*;
import java.awt.*;

public class ModpackPanel extends JPanel {
	ModpackPanel(){
		super();

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady=10;
		c.ipadx=100;
		c.weightx =1;
		c.weighty =0.25;
		c.anchor=GridBagConstraints.PAGE_START;

		Label modpackNameLabel = new Label("Select Modpack :");
		c.gridx=0;
		c.gridy=0;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		add(modpackNameLabel, c);

		JComboBox<String> modlistDropdown = new JComboBox<>(findModpacks());
		c.gridx=1;
		c.gridy=0;
		c.weightx=16;
		add(modlistDropdown, c);

		ModlistPanel modlist = new ModlistPanel();
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=4;
		c.weighty=256;
		c.weightx=1;
		c.anchor=GridBagConstraints.CENTER;
		c.fill=GridBagConstraints.BOTH;
		add(modlist, c);

		setVisible(true);
	}

	public String[] findModpacks(){

		return new String[]{"Yah", "Nah"};
	}
}
