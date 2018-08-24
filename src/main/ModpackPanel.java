package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static main.Window.FACTORIO_DIRECTORY;

public class ModpackPanel extends JPanel {
	private static JComboBox<String> modlistDropdown;
	private static String[] modpackList = findModpacks();
	ModpackPanel(){
		super();

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady=0;
		c.ipadx=100;
		c.weightx =1;
		c.weighty =1;
		c.anchor=GridBagConstraints.PAGE_START;

		JPanel modpackSelection = new JPanel();
		modpackSelection.setLayout( new GridBagLayout());

		JLabel modpackNameLabel = new JLabel("Select Modpack:     ", SwingConstants.CENTER);
		c.gridx=0;
		c.gridy=0;
		modpackNameLabel.setBorder( new EmptyBorder(4,0,0,0));
		modpackSelection.add(modpackNameLabel, c);

		modlistDropdown = new JComboBox<>(getModpackList());
		c.gridx=1;
		c.gridy=0;
		c.weightx=256;
		modpackSelection.add(modlistDropdown, c);

		c.gridx=0;
		c.gridy=0;
		modpackSelection.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new EtchedBorder()));
		add(modpackSelection,c);

		JScrollPane modlist = new JScrollPane(new ModlistPanel());
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=2;
		c.weighty=256;
		c.weightx=1;
		c.anchor=GridBagConstraints.CENTER;
		c.fill=GridBagConstraints.BOTH;
		modlist.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		modlist.getVerticalScrollBar().setUnitIncrement(20);
		modlist.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new EtchedBorder()));
		add(modlist, c);

		setVisible(true);
	}

	public static JComboBox<String> getModlistDropdown() {
		return modlistDropdown;
	}

	private static String[] findModpacks(){
		String[] possibleModpacks = findFolderList();
		ArrayList<String> modpackNamesAL = new ArrayList<>();
		for(String folder: possibleModpacks){
			try{
				String modpackName = getNameIfModpackDirectory(folder);
				modpackNamesAL.add(modpackName);
			} catch (FileNotFoundException ignored){}
		}
		String[] modpackNamesA = new String[modpackNamesAL.size()];
		for(int i=0; i<modpackNamesAL.size(); i++){
			modpackNamesA[i] = modpackNamesAL.get(i);
		}
		return modpackNamesA;
	}

	private static String[] findFolderList(){
		File[] directories = new File(FACTORIO_DIRECTORY).listFiles(File::isDirectory);
		String[] folderNames = new String[0];
		if (directories != null) {
			folderNames = new String[directories.length];
			for(int i=0; i< directories.length; i++){
				folderNames[i] = directories[i].getName();
			}
		}
		return folderNames;
	}

	private static String getNameIfModpackDirectory(String folderName) throws FileNotFoundException{
		File f = new File(FACTORIO_DIRECTORY+"\\" + folderName + "\\modpackname.txt");
		Scanner sc = new Scanner(f);
		String name = sc.nextLine();
		sc.close();
		return name;
	}

	public static String[] getModpackList(){
		return modpackList;
	}

	public static void addToModpackList(String modpackName){
		modlistDropdown.addItem(modpackName);
	}
	public static void removeFromModpackList(String modpackName){
		modlistDropdown.removeItem(modpackName);
	}
}
