package poke.view;

import javax.swing.JFrame;
import poke.controller.PokedexController;

public class PokedexFrame extends JFrame
{
	private PokedexController appController;
	private PokedexPanel panel;
	
	public PokedexFrame(PokedexController appController)
	{
		super();
		
		this.appController = appController;
		this.panel = new PokedexPanel(appController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(panel);
		this.setSize(800,800);
		this.setTitle("Pokemon");
		this.setResizable(true);
		this.setVisible(true);
	}
}
