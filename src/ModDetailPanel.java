import javax.swing.*;
import java.awt.*;

public class ModDetailPanel extends JPanel{
	Label modName;
	Label modVersion;
	ModDetailPanel(String modName, String modVersion){
		super();

		setLayout(new FlowLayout());

		this.modName = new Label(modName);
		this.modVersion = new Label(modVersion);
		JButton toggleModAvalability = new JButton("T");
		JButton deleteMod = new JButton("D");
		JButton configureMod = new JButton("C");

		add(this.modName);
		add(this.modVersion);
		add(toggleModAvalability);
		add(deleteMod);
		add(configureMod);

		setVisible(true);
	}
}
