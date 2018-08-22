import ActionListeners.DeleteModpackActionListener;
import ActionListeners.NewModpackActionListener;
import ActionListeners.SwitchModpackActionListener;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {
	ButtonsPanel(){
		super();
		//setSize(400, 300);
		setLayout(new GridLayout(1,3));

		JButton newModpackButton =new JButton("New Modpack");
		JButton switchModpackButton =new JButton("Switch Modpack");
		JButton deleteModpackButton =new JButton("Delete Modpack");

		newModpackButton.addActionListener(new NewModpackActionListener());
		switchModpackButton.addActionListener(new SwitchModpackActionListener());
		deleteModpackButton.addActionListener(new DeleteModpackActionListener());

		add(newModpackButton);
		add(switchModpackButton);
		add(deleteModpackButton);

		setVisible(true);
	}
}
