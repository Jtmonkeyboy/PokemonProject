package poke.view;

import javax.swing.JPanel;
import poke.controller.PokeController;

public class PokePanel extends JPanel
{
	private PokeController controller;
	
	public PokePanel(PokeController controller)
	{
		super();
		
		this.controller = controller;
	}
}
