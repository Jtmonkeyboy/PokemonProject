package poke.view;

import javax.swing.JFrame;
import poke.controller.PokeController;

public class PokeFrame extends JFrame
{
	private PokeController controller;
	private PokePanel panel;
	
	public PokeFrame(PokeController controller)
	{
		super();
		
		this.controller = controller;
		this.panel = new PokePanel(controller);
		
		setupFrame();
	}
	
	public void setupFrame()
	{
		this.setContentPane(panel);
		this.setSize(800,800);
		this.setTitle("Pokemon");
		this.setResizable(true);
		this.setVisible(true);
	}
}
