package main;

import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Window extends JFrame{
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	public static final String FACTORIO_DIRECTORY = System.getenv("APPDATA") + "\\Factorio";
	public static final String CURRENT_MODPACK = getCurrentModpackName();
	private static Window window;

	public static void main(String[] args){
		new Window();
		javax.swing.SwingUtilities.invokeLater(() -> {
			window = new Window();
			window.setVisible(true);
		});
	}

	public static Window getWindow(){
		return window;
	}

	private Window(){
		super("Factorio Mod Manager");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(WIDTH, HEIGHT);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		add(new ButtonsPanel(), BorderLayout.NORTH);
		add(new ModpackPanel(), BorderLayout.CENTER);
	}

	private static String getCurrentModpackName(){
		try{
			File f = new File(FACTORIO_DIRECTORY+"\\mods\\modpackname.txt");
			Scanner sc = new Scanner(f);
			return sc.nextLine();
		}catch (FileNotFoundException e){
			return "Untitled";
		}
	}

}
