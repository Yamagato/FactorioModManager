import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ModlistPanel extends JPanel {
	ModlistPanel(){
		super();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		HashMap<String, String> modList = detectMods();

		for(Map.Entry<String,String> entry : modList.entrySet()){
			ModDetailPanel modDetailPanel = new ModDetailPanel(entry.getKey(), entry.getValue());
			add(modDetailPanel);
		}
		setVisible(true);
	}

	public static HashMap<String, String> detectMods(){
		HashMap<String,String> mods = new HashMap<>();
		for(int i=0; i<30; i++){
			mods.put(Integer.toString(i), Integer.toHexString(i));
		}
		return mods;
	}

}
