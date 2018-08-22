import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;

	public static void main(String[] args){
		new Window();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Window w = new Window();
				w.setVisible(true);
			}
		});
	}

	Window(){
		super("Factorio Mod Manager");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(WIDTH, HEIGHT);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

		add(new ButtonsPanel(), BorderLayout.NORTH);
		add(new ModpackPanel(), BorderLayout.CENTER);


	}
}
